package io.github.vcsystem.vcsEvent.internal.model.events.comment;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentObjectAttributes {
    private Long id;
    private String note;
    @JsonAlias("noteable_type")
    private String noteableType;
    @JsonAlias("author_id")
    private Long authorId;
    @JsonAlias("created_at")
    private String createdAt;
    @JsonAlias("updated_at")
    private String updatedAt;
    @JsonAlias("project_id")
    private Long projectId;
    private String attachment;
    @JsonAlias("line_code")
    private String lineCode;
    @JsonAlias("commit_id")
    private String commitId;
    @JsonAlias("noteable_id")
    private String noteableId;
    private Boolean system;
    @JsonAlias("st_diff")
    private StDiff stDiff;
    private String url;
}
