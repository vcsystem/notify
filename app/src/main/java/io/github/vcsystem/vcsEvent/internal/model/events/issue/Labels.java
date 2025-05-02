package io.github.vcsystem.vcsEvent.internal.model.events.issue;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Labels {
    private List<Label> previous;
    private List<Label> current;
}
