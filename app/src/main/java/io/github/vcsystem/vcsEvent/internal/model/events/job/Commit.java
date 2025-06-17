package io.github.vcsystem.vcsEvent.internal.model.events.job;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Commit {
    @JsonAlias("id")
    private Long id;
    @JsonAlias("sha")
    private String sha;
    @JsonAlias("message")
    private String message;
    @JsonAlias("author_name")
    private String authorName;
    @JsonAlias("author_email")
    private String authorEmail;
    @JsonAlias("author_url")
    private String authorUrl;
    @JsonAlias("status")
    private String status;
    @JsonAlias("duration")
    private Double duration;
    @JsonAlias("started_at")
    private String startedAt;
    @JsonAlias("finished_at")
    private String finishedAt;
}
