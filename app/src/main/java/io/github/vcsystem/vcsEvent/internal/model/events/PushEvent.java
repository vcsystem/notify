package io.github.vcsystem.vcsEvent.internal.model.events;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.github.vcsystem.vcsEvent.internal.model.Commit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PushEvent extends EventBase {
    private String before;
    private String after;
    private String ref;
    @JsonAlias("checkout_sha")
    private String checkoutSha;
    private String message;
    @JsonAlias("user_id")
    private Integer userId;
    @JsonAlias("user_name")
    private String userFullname;
    @JsonAlias("user_username")
    private String userUsername;
    @JsonAlias("user_email")
    private String userEmail;
    @JsonAlias("user_avatar")
    private String userAvatar;
    @JsonAlias("project_id")
    private Long projectId;
    private List<Commit> commits;
    @JsonAlias("total_commits_count")
    private Integer totalCommitsCount;
    @JsonAlias("push_options")
    private Object pushOptions;
}

