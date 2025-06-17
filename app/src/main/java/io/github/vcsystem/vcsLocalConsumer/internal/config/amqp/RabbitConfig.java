package io.github.vcsystem.vcsLocalConsumer.internal.config.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration(value = "vcsLocalConsumerRabbitConfig")
public class RabbitConfig {
    @Bean
    public Queue vcsTempQueue() {
        return new Queue("vcs.temp.queue", true);
    }
}
