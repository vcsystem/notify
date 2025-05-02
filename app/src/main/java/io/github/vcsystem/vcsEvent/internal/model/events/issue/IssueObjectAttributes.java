package io.github.vcsystem.vcsEvent.internal.model.events.issue;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class IssueObjectAttributes {
    private Long id;
    private String title;
    @JsonAlias("assignee_ids")
    private List<Long> assigneeIds;
    @JsonAlias("assignee_id")
    private Long assigneeId;
    @JsonAlias("author_id")
    private Long authorId;
    @JsonAlias("project_id")
    private Long projectId;
    @JsonAlias("created_at")
    private String createdAt;
    @JsonAlias("updated_at")
    private String updatedAt;
    @JsonAlias("updated_by_id")
    private Long updatedById;
    @JsonAlias("last_edited_at")
    private String lastEditedAt;
    @JsonAlias("last_edited_by_id")
    private Long lastEditedById;
    @JsonAlias("relative_position")
    private Integer relativePosition;
    private String description;
    @JsonAlias("milestone_id")
    private Long milestoneId;
    @JsonAlias("state_id")
    private Long stateId;
    private Boolean confidential;
    @JsonAlias("discussion_locked")
    private Boolean discussionLocked;
    @JsonAlias("due_date")
    private LocalDate dueDate;
    @JsonAlias("moved_to_id")
    private Long movedToId;
    @JsonAlias("duplicated_to_id")
    private Long duplicatedToId;
    @JsonAlias("time_estimate")
    private Integer timeEstimate;
    @JsonAlias("total_time_spent")
    private Integer totalTimeSpent;
    @JsonAlias("time_change")
    private Integer timeChange;
    @JsonAlias("human_total_time_spent")
    private Integer humanTotalTimeSpent;
    @JsonAlias("human_time_estimate")
    private Integer humanTimeEstimate;
    @JsonAlias("human_time_change")
    private Integer humanTimeChange;
    private String weight;
    @JsonAlias("health_status")
    private String healthStatus;
    private Long iid;
    private String url;
    private String state;
    private String action;
    private String severity;
    @JsonAlias("escalation_status")
    private String escalationStatus;
    @JsonAlias("escalation_policy")
    private EscalationPolicy escalationPolicy;
    private List<Label> labels;
}
