package io.github.vcsystem.vcsEvent.internal.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String username;
    @JsonAlias("avatar_url")
    private String avatarUrl;
    private String email;
}
