package io.github.vcsystem.common.event;

import io.github.vcsystem.vcsEvent.internal.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VCEventTriggered {
    private EventType eventName;

    protected String branchNameFromRef(String ref) {
        if (ref == null) return "";
        String[] refSplit = ref.split("/");
        return refSplit[refSplit.length - 1];
    }
}
