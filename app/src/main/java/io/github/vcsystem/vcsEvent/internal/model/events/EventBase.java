package io.github.vcsystem.vcsEvent.internal.model.events;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.vcsystem.vcsEvent.internal.model.Project;
import io.github.vcsystem.vcsEvent.internal.model.Repository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventBase {
    @JsonAlias("object_kind")
    private String objectKind;
    @JsonAlias("event_name")
    private String eventName;
    private Project project;
    private Repository repository;
}
