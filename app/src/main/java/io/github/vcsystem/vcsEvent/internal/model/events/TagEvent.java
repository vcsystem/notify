package io.github.vcsystem.vcsEvent.internal.model.events;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.vcsystem.vcsEvent.internal.model.Commit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TagEvent extends EventBase {
    private String before;
    private String after;
    private String ref;
    @JsonAlias("checkout_sha")
    private String checkoutSha;
    private String message;
    @JsonAlias("user_id")
    private Long userId;
    @JsonAlias("user_name")
    private String username;
    @JsonAlias("user_username")
    private String userUsername;
    @JsonAlias("User_email")
    private String userEmail;
    @JsonAlias("user_avatar")
    private String user_avatar;
    @JsonAlias("project_id")
    private Long projectId;
    private List<Commit> commits;
    @JsonAlias("total_commits_count")
    private Integer totalCommitsCount;
}
