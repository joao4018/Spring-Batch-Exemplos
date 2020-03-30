package flatfile.exemploflatfile.batch.item;

import flatfile.exemploflatfile.core.domain.Person;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class itemWriterPrint {
    @Bean("writerPrintln")
    public ItemWriter<Person> customerItemWriter() {
        return items -> {
            for (Person item : items) {
                System.out.println("akiii" + item.toString());
            }
        };
    }
}
