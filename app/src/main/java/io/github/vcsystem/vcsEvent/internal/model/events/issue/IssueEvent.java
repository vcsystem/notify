package io.github.vcsystem.vcsEvent.internal.model.events.issue;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.vcsystem.vcsEvent.internal.model.User;
import io.github.vcsystem.vcsEvent.internal.model.events.EventBase;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IssueEvent extends EventBase {
    private User user;
    @JsonAlias("object_attributes")
    private IssueObjectAttributes issueObjectAttributes;
    private List<Assignee> assignees;
    private List<Label> labels;
    private Changes changes;
}
