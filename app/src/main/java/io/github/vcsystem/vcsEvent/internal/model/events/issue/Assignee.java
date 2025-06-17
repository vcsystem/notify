package io.github.vcsystem.vcsEvent.internal.model.events.issue;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Assignee {
    private String name;
    private String username;
    @JsonAlias("avatar_url")
    private String avatarUrl;
}
