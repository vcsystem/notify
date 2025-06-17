package io.github.vcsystem.vcsEvent.internal.model.events.pipeline;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.vcsystem.vcsEvent.internal.model.Build;
import io.github.vcsystem.vcsEvent.internal.model.Commit;
import io.github.vcsystem.vcsEvent.internal.model.Project;
import io.github.vcsystem.vcsEvent.internal.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PipelineEvent {
    @JsonAlias("object_kind")
    private String objectKind;
    @JsonAlias("object_attributes")
    private PipelineObjectAttributes objectAttributes;
    @JsonAlias("merge_request")
    private Object mergeRequest;
    @JsonAlias("user")
    private User user;
    @JsonAlias("project")
    private Project project;
    @JsonAlias("commit")
    private Commit commit;
    @JsonAlias("builds")
    private List<Build> builds;
}
