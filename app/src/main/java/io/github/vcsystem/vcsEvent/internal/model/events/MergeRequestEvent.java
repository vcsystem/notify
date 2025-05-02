package io.github.vcsystem.vcsEvent.internal.model.events;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.vcsystem.vcsEvent.internal.model.ObjectAttributes;
import io.github.vcsystem.vcsEvent.internal.model.Repository;
import io.github.vcsystem.vcsEvent.internal.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MergeRequestEvent extends EventBase {
    private User user;
    @JsonAlias("object_attributes")
    private ObjectAttributes objectAttributes;
    private List<Object> labels;
    private Object changes;
    private Repository repository;
}
