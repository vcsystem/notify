package io.github.vcsystem.vcsEvent.internal.config;

import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Declarables fanoutBindings() {
        FanoutExchange exchange = new FanoutExchange("vcs.exchange");
        return new Declarables(exchange);
    }
}
