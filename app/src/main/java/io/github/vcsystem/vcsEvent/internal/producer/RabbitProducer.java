package io.github.vcsystem.vcsEvent.internal.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {
    private final RabbitTemplate rabbitTemplate;

    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendEventToRabbitMQ(Object event) {
        rabbitTemplate.convertAndSend("vcs.exchange", "", event);
    }
}
