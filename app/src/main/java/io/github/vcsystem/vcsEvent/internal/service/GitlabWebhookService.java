package io.github.vcsystem.vcsEvent.internal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.vcsystem.common.event.CodeCommitted;
import io.github.vcsystem.common.event.VCEventTriggered;
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

import java.util.List;

@Service
@Slf4j
public final class GitlabWebhookService extends VCSWebhookService {
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
    protected VCEventTriggered handlePushEvent(String updateJson) {
        PushEvent pushEvent = readJson(PushEvent.class, updateJson).orElseThrow();
        log.info("handlePushEvent: {}", pushEvent);
        List<CodeCommitted.Commit> commits = pushEvent.getCommits().stream()
                .map(commit -> CodeCommitted.Commit.builder().title(commit.getTitle()).url(commit.getUrl()).build())
                .toList();

        return CodeCommitted.builder()
                .projectName(pushEvent.getProject().getName())
                .projectUrl(pushEvent.getProject().getWebUrl())
                .authorName(pushEvent.getUserFullname())
                .ref(pushEvent.getRef())
                .commits(commits)
                .build();
    }

    @Override
    protected VCEventTriggered handleTagPush(String updateJson) {
        TagEvent tagEvent = readJson(TagEvent.class, updateJson).orElseThrow();
        log.info("handleTagPush: {}", tagEvent);
        return VCEventTriggered.builder().build();
    }

    @Override
    protected VCEventTriggered handleIssue(String updateJson) {
        IssueEvent issueEvent = readJson(IssueEvent.class, updateJson).orElseThrow();
        log.info("handleIssue: {}", issueEvent);
        return VCEventTriggered.builder().build();
    }

    @Override
    protected VCEventTriggered handleNote(String updateJson) {
        CommentEvent commentEvent = readJson(CommentEvent.class, updateJson).orElseThrow();
        log.info("handleNote: {}", commentEvent);
        return VCEventTriggered.builder().build();
    }

    @Override
    protected VCEventTriggered handleMergeRequest(String updateJson) {
        MergeRequestEvent mergeRequestEvent = readJson(MergeRequestEvent.class, updateJson).orElseThrow();
        log.info("handleMergeRequest: {}", mergeRequestEvent);
        return VCEventTriggered.builder().build();
    }

    @Override
    protected VCEventTriggered handleWikiPage(String updateJson) {
        WikiPageEvent wikiPageEvent = readJson(WikiPageEvent.class, updateJson).orElseThrow();
        log.info("handleWikiPage: {}", wikiPageEvent);
        return VCEventTriggered.builder().build();
    }

    @Override
    protected VCEventTriggered handlePipeline(String updateJson) {
        PipelineEvent pipelineEvent = readJson(PipelineEvent.class, updateJson).orElseThrow();
        log.info("handlePipeline: {}", pipelineEvent);
        return VCEventTriggered.builder().build(); // TODO
    }

    @Override
    protected VCEventTriggered handleJob(String updateJson) {
        JobEvent jobEvent = readJson(JobEvent.class, updateJson).orElseThrow();
        log.info("handleJob: {}", jobEvent);
        return VCEventTriggered.builder().build(); // TODO
    }

    @Override
    protected VCEventTriggered handleDevelopment(String updateJson) {
        // TODO handle
        return VCEventTriggered.builder().build();
    }

    @Override
    protected VCEventTriggered handleMember(String updateJson) {
        // TODO handle
        return VCEventTriggered.builder().build();
    }

    @Override
    protected VCEventTriggered handleSubgroup(String updateJson) {
        // TODO handle
        return VCEventTriggered.builder().build();
    }

    @Override
    protected VCEventTriggered handleFeatureFlag(String updateJson) {
        // TODO handle
        return VCEventTriggered.builder().build();
    }

    @Override
    protected VCEventTriggered handleRelease(String updateJson) {
        // TODO handle
        return VCEventTriggered.builder().build();
    }
}
