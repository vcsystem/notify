package io.github.vcsystem.vcsEvent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/vcs/webhooks")
@Slf4j
public class VCSEventController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean handleEvent(@RequestBody String jsonBody) {
        log.info("REST request from vcs handled");
        log.info(jsonBody);
        return true;
    }
}
