package io.github.vcsystem.vcsEvent.internal.model.events.comment;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StDiff {
    private String diff;
    @JsonAlias("new_path")
    private String newPath;
    @JsonAlias("old_path")
    private String oldPath;
    @JsonAlias("a_mode")
    private String aMode;
    @JsonAlias("b_mode")
    private String bMode;
    @JsonAlias("new_file")
    private Boolean newFile;
    @JsonAlias("renamed_file")
    private Boolean renamedFile;
    @JsonAlias("deleted_file")
    private Boolean deletedFile;
}
