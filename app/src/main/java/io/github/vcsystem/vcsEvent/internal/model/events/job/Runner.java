package io.github.vcsystem.vcsEvent.internal.model.events.job;

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
    @JsonAlias("active")
    private Boolean active;
    private List<String> tags;
}
