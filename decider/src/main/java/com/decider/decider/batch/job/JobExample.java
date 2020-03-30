package com.decider.decider.batch.job;

import com.decider.decider.batch.decider.DecisorStep;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class JobExample {

    @NonNull
    public JobBuilderFactory jobBuilderFactory;


    @Bean
    public Job job(@Qualifier("step1") Step step1,
                   @Qualifier("step2") Step step2,
                   Step startStep,
                   JobExecutionDecider decider) {
        return jobBuilderFactory.get("job")
                .start(startStep)
                .next(decider).on("EMPTY").to(step2)
                .from(decider).on("EXISTS").to(step1)
                .end()
                .build();
    }
}