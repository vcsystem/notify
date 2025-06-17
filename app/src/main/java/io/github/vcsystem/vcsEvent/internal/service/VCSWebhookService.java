package io.github.vcsystem.vcsEvent.internal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.vcsystem.vcsEvent.internal.enums.EventType;
import io.github.vcsystem.vcsEvent.internal.producer.RabbitProducer;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

public sealed abstract class VCSWebhookService permits GitlabWebhookService {
    private final ObjectMapper objectMapper;
    private final RabbitProducer rabbitProducer;

    protected VCSWebhookService(ObjectMapper objectMapper, RabbitProducer rabbitProducer) {
        this.objectMapper = objectMapper;
        this.rabbitProducer = rabbitProducer;
    }

    public void handleUpdate(String updateJson, String eventHeader) {
        switch (getEventType(eventHeader)) {
            case PUSH -> handlePushEvent(updateJson);
            case TAG_PUSH -> handleTagPush(updateJson);
            case ISSUE -> handleIssue(updateJson);
            case NOTE -> handleNote(updateJson);
            case MERGE_REQUEST -> handleMergeRequest(updateJson);
            case WIKI_PAGE -> handleWikiPage(updateJson);
            case PIPELINE -> handlePipeline(updateJson);
            case JOB -> handleJob(updateJson);
            case DEVELOPMENT -> handleDevelopment(updateJson);
            case MEMBER -> handleMember(updateJson);
            case SUBGROUP -> handleSubgroup(updateJson);
            case FEATURE_FLAG -> handleFeatureFlag(updateJson);
            case RELEASE -> handleRelease(updateJson);
            default -> {
            }
        }
        // the switch statement above will return a constructed JSON object
        // it is a standard communication model
        // and serves to exchange with other services
        // the model will be used instead of the test message below
        // TODO remove test message and implement a model described above
        rabbitProducer.sendEventToRabbitMQ("This is vcs event message");
    }

    protected abstract void handlePushEvent(String updateJson);

    protected abstract void handleTagPush(String updateJson);

    protected abstract void handleIssue(String updateJson);

    protected abstract void handleNote(String updateJson);

    protected abstract void handleMergeRequest(String updateJson);

    protected abstract void handleWikiPage(String updateJson);

    protected abstract void handlePipeline(String updateJson);

    protected abstract void handleJob(String updateJson);

    protected abstract void handleDevelopment(String updateJson);

    protected abstract void handleMember(String updateJson);

    protected abstract void handleSubgroup(String updateJson);

    protected abstract void handleFeatureFlag(String updateJson);

    protected abstract void handleRelease(String updateJson);

    protected abstract EventType getEventType(String eventHeader);

    protected <T> Optional<T> readJson(Class<T> eventClass, String updateJson) {
        try {
            return Optional.ofNullable(objectMapper.readValue(updateJson, eventClass));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e); // TODO handle exception
        }
    }
}
