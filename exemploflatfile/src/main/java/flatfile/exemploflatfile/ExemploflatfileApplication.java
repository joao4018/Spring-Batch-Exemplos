package flatfile.exemploflatfile;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class ExemploflatfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExemploflatfileApplication.class, args);
    }

}
