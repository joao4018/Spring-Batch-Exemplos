package jobparameter.demo.batch.step;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StepExample {

    @NonNull
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    @StepScope
    public Tasklet helloWorldTasklet(@Value("#{jobParameters['message2']}") String message,
                                     @Value("#{jobParameters['message']}") String message2) {
        return (stepContribution, chunkContext) -> {
            System.out.println(message + " <- parameter1 - parameter2-> " + message2);
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .tasklet(helloWorldTasklet(null, null))
                .build();
    }
}
