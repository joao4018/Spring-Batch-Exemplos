package com.decider.decider.batch.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class DecisorStep {

    @Bean
    public JobExecutionDecider decider() {

        return new JobExecutionDecider() {

            @Override
            public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
                final String path = new ClassPathResource("/data.csv").getPath();

                if (path.equals("data.csv")) {
                    return new FlowExecutionStatus("EXISTS");
                } else {
                    return new FlowExecutionStatus("EMPTY");
                }
            }
        };


    }

}

