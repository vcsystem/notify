package io.github.vcsystem.vcsEvent.internal.model.events.issue;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Changes {
    @JsonAlias("updated_by_id")
    private UpdatedById updatedById;
    @JsonAlias("updated_at")
    private UpdatedAt updatedAt;
    private Labels labels;
}
