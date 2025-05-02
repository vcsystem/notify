package io.github.vcsystem.vcsEvent.internal.model.events.job;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.vcsystem.vcsEvent.internal.model.Repository;
import io.github.vcsystem.vcsEvent.internal.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobEvent {
    @JsonAlias("object_kind")
    private String objectKind;
    private String ref;
    private Boolean tag;
    @JsonAlias("before_sha")
    private String beforeSha;
    private String sha;
    @JsonAlias("build_id")
    private Long buildId;
    @JsonAlias("build_name")
    private String buildName;
    @JsonAlias("build_stage")
    private String buildStage;
    @JsonAlias("build_status")
    private String buildStatus;
    @JsonAlias("build_created_at")
    private String buildCreatedAt;
    @JsonAlias("build_started_at")
    private String buildStartedAt;
    @JsonAlias("build_finished_at")
    private String buildFinishedAt;
    @JsonAlias("build_duration")
    private Double buildDuration;
    @JsonAlias("build_queued_duration")
    private Double buildQueuedDuration;
    @JsonAlias("build_allow_failure")
    private Boolean buildAllowFailure;
    @JsonAlias("build_failure_reason")
    private String buildFailureReason;
    @JsonAlias("pipeline_id")
    private Long pipelineId;
    private Runner runner;
    @JsonAlias("project_id")
    private Long projectId;
    @JsonAlias("project_name")
    private String projectName;
    private User user;
    private Commit commit;
    private Repository repository;
    private Object environment;
}
