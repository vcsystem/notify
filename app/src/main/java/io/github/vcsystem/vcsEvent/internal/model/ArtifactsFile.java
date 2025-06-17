package io.github.vcsystem.vcsEvent.internal.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtifactsFile {
    private String filename;
    private Object size; // TODO change type
}
