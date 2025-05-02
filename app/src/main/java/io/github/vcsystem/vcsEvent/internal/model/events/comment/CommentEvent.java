package io.github.vcsystem.vcsEvent.internal.model.events.comment;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.vcsystem.vcsEvent.internal.model.Commit;
import io.github.vcsystem.vcsEvent.internal.model.User;
import io.github.vcsystem.vcsEvent.internal.model.events.EventBase;
import io.github.vcsystem.vcsEvent.internal.model.events.issue.IssueObjectAttributes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentEvent extends EventBase {
    @JsonAlias("project_id")
    private Long projectId;
    private User user;
    @JsonAlias("object_attributes")
    private CommentObjectAttributes objectAttributes;
    private IssueObjectAttributes issue;
    private Commit commit;
}
