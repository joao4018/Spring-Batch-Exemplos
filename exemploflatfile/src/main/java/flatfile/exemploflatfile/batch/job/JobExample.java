package flatfile.exemploflatfile.batch.job;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class JobExample {

    @NonNull
    public JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job job(@Qualifier("step1") Step step) {
        return jobBuilderFactory.get("job")
                .start(step)
                .build();
    }
}
