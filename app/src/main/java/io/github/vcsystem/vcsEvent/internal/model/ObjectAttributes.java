package io.github.vcsystem.vcsEvent.internal.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObjectAttributes {
    @JsonAlias("assignee_id")
    private Long assigneeId;
    @JsonAlias("author_id")
    private Long authorId;
    @JsonAlias("created_at")
    private String createdAt;
    private String description;
    @JsonAlias("head_pipeline_id")
    private Long headPipelineId;
    private Long id;
    private Integer iid;
    @JsonAlias("last_edited_at")
    private String lastEditedAt;
    @JsonAlias("last_edited_by_id")
    private Long lastEditedById;
    @JsonAlias("merge_commit_sha")
    private String mergeCommitSha;
    @JsonAlias("merge_error")
    private String mergeError;
    @JsonAlias("merge_params")
    private Object mergeParams;
    @JsonAlias("merge_status")
    private String mergeStatus;
    @JsonAlias("merge_user_id")
    private Long mergeUserId;
    @JsonAlias("merge_when_pipeline_succeeds")
    private Boolean mergeWhenPipelineSucceeds;
    @JsonAlias("milestone_id")
    private String milestoneId;
    @JsonAlias("source_branch")
    private String sourceBranch;
    @JsonAlias("source_project_id")
    private Long sourceProjectId;
    @JsonAlias("state_id")
    private Integer stateId;
    @JsonAlias("target_branch")
    private String targetBranch;
    @JsonAlias("target_project_id")
    private Long targetProjectId;
    @JsonAlias("time_estimate")
    private Long timeEstimate;
    private String title;
    @JsonAlias("updated_at")
    private String updatedAt;
    @JsonAlias("updated_by_id")
    private Long updatedById;
    private String url;
    private Project source;
    private Project target;
    @JsonAlias("last_commit")
    private Commit last_commit;
    @JsonAlias("work_in_progress")
    private Boolean workInProgress;
    @JsonAlias("total_time_spent")
    private Long totalTimeSpent;
    @JsonAlias("time_change")
    private Long timeChange;
    @JsonAlias("human_total_time_spent")
    private String humanTotalTimeSpent;
    @JsonAlias("human_time_change")
    private String humanTimeChange;
    @JsonAlias("human_time_estimate")
    private String humanTimeEstimate;
    @JsonAlias("assignee_ids")
    private List<Long> assigneeIds;
    @JsonAlias("reviewer_ids")
    private List<Long> reviewerIds;
    private List<Object> labels;
    private String state;
    @JsonAlias("blocking_discussions_resolved")
    private Boolean blockingDiscussionsResolved;
    @JsonAlias("first_contribution")
    private Boolean firstContribution;
    @JsonAlias("detailed_merge_status")
    private String detailedMergeStatus;
    private String action;

}
