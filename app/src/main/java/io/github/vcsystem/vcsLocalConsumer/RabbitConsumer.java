package io.github.vcsystem.vcsLocalConsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Deprecated(forRemoval = true)
@Slf4j
@Service
public class RabbitConsumer {
    // what it does is just listens for vcs events
    // then logs result to check if fanout works properly
    // as soon as this functionality is implemented by the appropriate service this class will be removed
    // (in our case telegram notification)

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "vcs.temp.queue", durable = "true"),
            exchange = @Exchange(value = "vcs.exchange", type = "fanout"))
    )
    public void receiveEventFromRabbitMQ(String message) {
        log.info("Received event in temp rabbit listener");
        log.info(message);
    }
}
