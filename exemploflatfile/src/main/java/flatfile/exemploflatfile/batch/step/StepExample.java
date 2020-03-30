package flatfile.exemploflatfile.batch.step;

import flatfile.exemploflatfile.core.domain.Person;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StepExample {

    @NonNull
    public StepBuilderFactory stepBuilderFactory;

    @Bean("step1")
    public Step step1(@Qualifier("readerCSV") FlatFileItemReader<Person> personItemReader,
                     @Qualifier("writerPrintln") ItemWriter personItemWriter) {
        return stepBuilderFactory.get("step1")
                .<Person, Person>chunk(10)
                .reader(personItemReader)
                .writer(personItemWriter)
                .build();
    }
}
