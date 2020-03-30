package jobparameter.demo.batch.job;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class JobExample {
    @NonNull
    public JobBuilderFactory jobBuilderFactory;


    @Bean
    public Job jobParametersJob(Step step) {
        return jobBuilderFactory.get("jobParametersJob")
                .start(step)
                .build();
    }
}

