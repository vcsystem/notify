package io.github.vcsystem.vcsEvent.internal.model.events.pipeline;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PipelineObjectAttributes {
    @JsonAlias("id")
    private Long id;
    @JsonAlias("iid")
    private Long iid;
    @JsonAlias("name")
    private String name;
    @JsonAlias("ref")
    private String ref;
    @JsonAlias("tag")
    private Boolean tag;
    @JsonAlias("sha")
    private String sha;
    @JsonAlias("before_sha")
    private String beforeSha;
    @JsonAlias("source")
    private String source;
    @JsonAlias("status")
    private String status;
    @JsonAlias("detailed_status")
    private String detailedStatus;
    @JsonAlias("stages")
    private List<String> stages;
    @JsonAlias("created_at")
    private String createdAt;
    @JsonAlias("finished_at")
    private String finishedAt;
    @JsonAlias("duration")
    private Integer duration;
    @JsonAlias("queued_duration")
    private Integer queuedDuration;
    @JsonAlias("variables")
    private List<String> variables;
    @JsonAlias("url")
    private String url;
}
