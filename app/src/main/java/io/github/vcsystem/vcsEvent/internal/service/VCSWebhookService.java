package io.github.vcsystem.vcsEvent.internal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.vcsystem.common.event.VCEventTriggered;
import io.github.vcsystem.vcsEvent.internal.enums.EventType;
import io.github.vcsystem.vcsEvent.internal.producer.RabbitProducer;

import java.util.Optional;

public sealed abstract class VCSWebhookService permits GitlabWebhookService {
    private final ObjectMapper objectMapper;
    private final RabbitProducer rabbitProducer;

    protected VCSWebhookService(ObjectMapper objectMapper, RabbitProducer rabbitProducer) {
        this.objectMapper = objectMapper;
        this.rabbitProducer = rabbitProducer;
    }

    public void handleUpdate(String updateJson, String eventHeader) {
        EventType eventType = getEventType(eventHeader);
        VCEventTriggered eventTriggered = switch (eventType) {
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
            default -> VCEventTriggered.builder().eventName(eventType).build();
        };
        // the switch statement above will return a constructed JSON object
        // it is a standard communication model
        // and serves to exchange with other services
        eventTriggered.setEventName(eventType);
        rabbitProducer.sendEventToRabbitMQ(eventTriggered);
    }

    protected abstract VCEventTriggered handlePushEvent(String updateJson);

    protected abstract VCEventTriggered handleTagPush(String updateJson);

    protected abstract VCEventTriggered handleIssue(String updateJson);

    protected abstract VCEventTriggered handleNote(String updateJson);

    protected abstract VCEventTriggered handleMergeRequest(String updateJson);

    protected abstract VCEventTriggered handleWikiPage(String updateJson);

    protected abstract VCEventTriggered handlePipeline(String updateJson);

    protected abstract VCEventTriggered handleJob(String updateJson);

    protected abstract VCEventTriggered handleDevelopment(String updateJson);

    protected abstract VCEventTriggered handleMember(String updateJson);

    protected abstract VCEventTriggered handleSubgroup(String updateJson);

    protected abstract VCEventTriggered handleFeatureFlag(String updateJson);

    protected abstract VCEventTriggered handleRelease(String updateJson);

    protected abstract EventType getEventType(String eventHeader);

    protected <T> Optional<T> readJson(Class<T> eventClass, String updateJson) {
        try {
            return Optional.ofNullable(objectMapper.readValue(updateJson, eventClass));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e); // TODO handle exception
        }
    }
}
