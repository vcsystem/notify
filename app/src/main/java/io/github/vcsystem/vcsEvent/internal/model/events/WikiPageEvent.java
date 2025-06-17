package io.github.vcsystem.vcsEvent.internal.model.events;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.vcsystem.vcsEvent.internal.model.Project;
import io.github.vcsystem.vcsEvent.internal.model.User;
import io.github.vcsystem.vcsEvent.internal.model.Wiki;
import io.github.vcsystem.vcsEvent.internal.model.WikiObjectAttributes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WikiPageEvent extends EventBase {
    private User user;
    private Project project;
    private Wiki wiki;
    @JsonAlias("object_attributes")
    private WikiObjectAttributes objectAttributes;
}
