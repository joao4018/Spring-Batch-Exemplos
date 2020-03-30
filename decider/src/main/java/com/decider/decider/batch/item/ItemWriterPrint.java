package com.decider.decider.batch.item;

import com.decider.decider.core.domain.Person;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemWriterPrint {
    @Bean("writerPrintln")
    public ItemWriter<Person> customerItemWriter() {
        return items -> {
            for (Person item : items) {
                System.out.println("akiii" + item.toString());
            }
        };
    }
}
