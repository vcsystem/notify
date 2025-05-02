package io.github.vcsystem.vcsEvent.internal.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Runner {
    @JsonAlias("id")
    private Long id;
    @JsonAlias("description")
    private String description;
    @JsonAlias("runner_type")
    private String runnerType;
    @JsonAlias("active")
    private Boolean active;
    @JsonAlias("is_shared")
    private Boolean isShared;
    @JsonAlias("tags")
    private List<String> tags;
}
