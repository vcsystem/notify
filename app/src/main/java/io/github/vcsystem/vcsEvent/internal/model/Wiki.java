package io.github.vcsystem.vcsEvent.internal.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wiki {
    @JsonAlias("web_url")
    private String webUrl;
    @JsonAlias("git_ssh_url")
    private String gitSshUrl;
    @JsonAlias("git_http_url")
    private String gitHttpUrl;
    @JsonAlias("path_with_namespace")
    private String pathWithNamespace;
    @JsonAlias("default_branch")
    private String defaultBranch;
}
