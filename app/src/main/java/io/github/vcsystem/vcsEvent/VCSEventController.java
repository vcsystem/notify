package io.github.vcsystem.vcsEvent;

import io.github.vcsystem.vcsEvent.internal.service.GitlabWebhookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/vcs/webhooks")
@Slf4j
public class VCSEventController {
    private final GitlabWebhookService gitlabWebhookService;

    public VCSEventController(GitlabWebhookService gitlabWebhookService) {
        this.gitlabWebhookService = gitlabWebhookService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean handleEvent(@RequestBody String jsonBody,
                               @RequestHeader(value = "X-Gitlab-Event", required = false) String eventHeader) {
        log.info("REST request from vcs handled");
        log.info(jsonBody);
        gitlabWebhookService.handleUpdate(jsonBody, eventHeader);
        return true;
    }
}
