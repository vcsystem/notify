package io.github.vcsystem.common.event;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CodeCommitted extends VCEventTriggered {
    private String projectName;
    private String projectUrl;
    private String authorName;
    private String ref;
    private String branchName;
    private List<Commit> commits;

    public String getBranchName() {
        return branchNameFromRef(ref);
    }

    @Getter
    @Setter
    @Builder
    public static class Commit {
        private String id;
        private String author;
        private String title;
        private String url;
    }
}
