package io.github.vcsystem.vcsEvent.internal.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Repository {
    private String name;
    private String url;
    private String description;
    private String homepage;
    @JsonAlias("git_http_url")
    private String gitHttpUrl;
    @JsonAlias("git_ssh_url")
    private String gitSshUrl;
    @JsonAlias("visibility_level")
    private Integer visibilityLevel;
}
