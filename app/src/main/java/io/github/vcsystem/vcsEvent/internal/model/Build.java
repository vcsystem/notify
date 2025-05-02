package io.github.vcsystem.vcsEvent.internal.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Build {
    @JsonAlias("id")
    private Long id;
    @JsonAlias("stage")
    private String stage;
    @JsonAlias("name")
    private String name;
    @JsonAlias("status")
    private String status;
    @JsonAlias("created_at")
    private String createdAt;
    @JsonAlias("started_at")
    private String startedAt;
    @JsonAlias("finished_at")
    private String finishedAt;
    @JsonAlias("duration")
    private Double duration;
    @JsonAlias("queued_duration")
    private Double queuedDuration;
    @JsonAlias("failure_reason")
    private String failureReason;
    @JsonAlias("when")
    private String when;
    @JsonAlias("manual")
    private Boolean manual;
    @JsonAlias("allow_failure")
    private Boolean allowFailure;
    @JsonAlias("user")
    private User user;
    @JsonAlias("runner")
    private Runner runner;
    @JsonAlias("artifacts_file")
    private ArtifactsFile artifactsFile;
    @JsonAlias("environment")
    private String environment;
}


