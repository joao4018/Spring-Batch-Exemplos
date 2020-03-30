package flatfile.exemploflatfile.batch.item;

import flatfile.exemploflatfile.core.domain.Person;
import flatfile.exemploflatfile.core.rowMapper.PersonFieldSetMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class itemReaderCsv {

    @Bean("readerCSV")
    public FlatFileItemReader<Person> personItemReader() {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<>();

        reader.setLinesToSkip(1);
        reader.setResource(new ClassPathResource("/data.csv"));

        DefaultLineMapper<Person> personLineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer("|");
        tokenizer.setNames(new String[] {"id", "firstName", "lastName", "birthdate"});

        personLineMapper.setLineTokenizer(tokenizer);
        personLineMapper.setFieldSetMapper(new PersonFieldSetMapper());
        personLineMapper.afterPropertiesSet();

        reader.setLineMapper(personLineMapper);

        return reader;
    }
}
