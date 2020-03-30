package com.decider.decider.batch.step;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StepTasklet {

    @NonNull
    public StepBuilderFactory stepBuilderFactory;

    @Bean("step2")
    public Step resourceEmpty() {
        return stepBuilderFactory.get("resourceEmpty")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Resource Vazio");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
