package io.github.vcsystem.telegramAlert.internal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import io.github.vcsystem.common.event.CodeCommitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TelegramAlertConsumer {
    private final ObjectMapper objectMapper;

    public TelegramAlertConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "vcs.telegram.alert.queue", durable = "true"),
            exchange = @Exchange(value = "vcs.exchange", type = "fanout"))
    )
    public void handleEvent(String message) {
        log.info("Vcs telegram alert received: {}", message);
        String eventType = "PUSH";
        switch (eventType) {
            case "PUSH" -> handleCodeCommitted(message);
            default -> log.error("Unknown event type: {}", message);
        }

    }

    private void handleCodeCommitted(String message) {
        CodeCommitted codeCommitted;
        try {
            codeCommitted = objectMapper.readValue(message, CodeCommitted.class);
        } catch (IllegalArgumentException | JsonProcessingException e) {
            log.error(e.getMessage(), e);
            return;
        }
        String text = "<b>" + codeCommitted.getAuthorName() + "</b> pushed to " + codeCommitted.getProjectUrl() + "/-/tree/" + codeCommitted.getBranchName() + "\n" +
                "\n" +
                "\n" +
                "#push #" + projectTag(codeCommitted.getProjectName());
        sendMessage(text);
    }

    private static String projectTag(String projectName) {
        return Optional.ofNullable(projectName).map(p -> p.replaceAll(" ", "_")).map(String::toLowerCase).orElse("");
    }

    private static void sendMessage(String text) {
        TelegramBot bot = new TelegramBot("7861801678:AAG79U8TnTy0DXSQm1VyjCXD09SxPMWp-pY");
        SendMessage sendMessage = new SendMessage(781820533, text);
        sendMessage.parseMode(ParseMode.HTML);
        bot.execute(sendMessage);
    }
}
