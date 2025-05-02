package io.github.vcsystem.vcsEvent.internal.model.events.issue;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Label {
    private Long id;
    private String title;
    private String color;
    @JsonAlias("project_id")
    private Long projectId;
    @JsonAlias("created_at")
    private LocalDateTime createdAt;
    @JsonAlias("updated_at")
    private LocalDateTime updatedAt;
    private Boolean template;
    private String description;
    private String type;
    @JsonAlias("group_id")
    private Long groupId;
}
