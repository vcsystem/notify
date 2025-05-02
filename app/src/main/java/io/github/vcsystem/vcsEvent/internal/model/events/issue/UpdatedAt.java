package io.github.vcsystem.vcsEvent.internal.model.events.issue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatedAt {
    private String previous;
    private String current;
}
