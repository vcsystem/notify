package io.github.vcsystem.vcsEvent.internal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.vcsystem.vcsEvent.internal.enums.EventType;
import io.github.vcsystem.vcsEvent.internal.model.events.MergeRequestEvent;
import io.github.vcsystem.vcsEvent.internal.model.events.PushEvent;
import io.github.vcsystem.vcsEvent.internal.model.events.TagEvent;
import io.github.vcsystem.vcsEvent.internal.model.events.WikiPageEvent;
import io.github.vcsystem.vcsEvent.internal.model.events.comment.CommentEvent;
import io.github.vcsystem.vcsEvent.internal.model.events.issue.IssueEvent;
import io.github.vcsystem.vcsEvent.internal.model.events.job.JobEvent;
import io.github.vcsystem.vcsEvent.internal.model.events.pipeline.PipelineEvent;
import io.github.vcsystem.vcsEvent.internal.producer.RabbitProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GitlabWebhookService extends VCSWebhookService {
    public GitlabWebhookService(ObjectMapper objectMapper, RabbitProducer rabbitProducer) {
        super(objectMapper, rabbitProducer);
    }

    @Override
    protected EventType getEventType(String eventHeader) {
        if (eventHeader == null) return EventType.NONE;
        return switch (eventHeader) {
            case "Push Hook" -> EventType.PUSH;
            case "Tag Push Hook" -> EventType.TAG_PUSH;
            case "Issue Hook" -> EventType.ISSUE;
            case "Note Hook" -> EventType.NOTE;
            case "Merge Request Hook" -> EventType.MERGE_REQUEST;
            case "Wiki Page Hook" -> EventType.WIKI_PAGE;
            case "Pipeline Hook" -> EventType.PIPELINE;
            case "Job Hook" -> EventType.JOB;
            case "Deployment Hook" -> EventType.DEVELOPMENT;
            case "Member Hook" -> EventType.MEMBER;
            case "Subgroup Hook" -> EventType.SUBGROUP;
            case "Feature Flag Hook" -> EventType.FEATURE_FLAG;
            case "Release Hook" -> EventType.RELEASE;
            default -> EventType.NONE;
        };
    }

    @Override
    protected void handlePushEvent(String updateJson) {
        PushEvent pushEvent = readJson(PushEvent.class, updateJson).orElseThrow();
        log.info("handlePushEvent: {}", pushEvent);
    }

    private String branchNameFromRef(String ref) {
        if (ref == null) return "";
        String[] refSplit = ref.split("/");
        return refSplit[refSplit.length - 1];
    }

    @Override
    protected void handleTagPush(String updateJson) {
        TagEvent tagEvent = readJson(TagEvent.class, updateJson).orElseThrow();
        log.info("handleTagPush: {}", tagEvent);
    }

    @Override
    protected void handleIssue(String updateJson) {
        IssueEvent issueEvent = readJson(IssueEvent.class, updateJson).orElseThrow();
        log.info("handleIssue: {}", issueEvent);
    }

    @Override
    protected void handleNote(String updateJson) {
        CommentEvent commentEvent = readJson(CommentEvent.class, updateJson).orElseThrow();
        log.info("handleNote: {}", commentEvent);
    }

    @Override
    protected void handleMergeRequest(String updateJson) {
        MergeRequestEvent mergeRequestEvent = readJson(MergeRequestEvent.class, updateJson).orElseThrow();
        log.info("handleMergeRequest: {}", mergeRequestEvent);
    }

    @Override
    protected void handleWikiPage(String updateJson) {
        WikiPageEvent wikiPageEvent = readJson(WikiPageEvent.class, updateJson).orElseThrow();
        log.info("handleWikiPage: {}", wikiPageEvent);
    }

    @Override
    protected synchronized void handlePipeline(String updateJson) {
        PipelineEvent pipelineEvent = readJson(PipelineEvent.class, updateJson).orElseThrow();
        log.info("handlePipeline: {}", pipelineEvent);
    }

    @Override
    protected void handleJob(String updateJson) {
        JobEvent jobEvent = readJson(JobEvent.class, updateJson).orElseThrow();
    }

    @Override
    protected void handleDevelopment(String updateJson) {
        // TODO handle
    }

    @Override
    protected void handleMember(String updateJson) {
        // TODO handle
    }

    @Override
    protected void handleSubgroup(String updateJson) {
        // TODO handle
    }

    @Override
    protected void handleFeatureFlag(String updateJson) {
        // TODO handle
    }

    @Override
    protected void handleRelease(String updateJson) {
        // TODO handle
    }
}
