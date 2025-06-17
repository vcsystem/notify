package io.github.vcsystem.vcsEvent.internal.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {
    private Long id;
    private String name;
    private String description;
    @JsonAlias("web_url")
    private String webUrl;
    @JsonAlias("avatar_url")
    private String avatarUrl;
    @JsonAlias("git_ssh_url")
    private String gitSshUrl;
    @JsonAlias("git_http_url")
    private String gitHttpUrl;
    private String namespace;
    @JsonAlias("visibility_level")
    private Integer visibilityLevel;
    @JsonAlias("path_with_namespace")
    private String pathWithNamespace;
    @JsonAlias("default_branch")
    private String defaultBranch;
    @JsonAlias("ci_config_path")
    private String ciConfigPath;
    private String homepage;
    private String url;
    @JsonAlias("ssh_url")
    private String sshUrl;
    @JsonAlias("http_url")
    private String httpUrl;
}
