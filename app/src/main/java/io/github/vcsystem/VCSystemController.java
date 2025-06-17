package io.github.vcsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VCSystemController {
    @GetMapping("/")
    public String index() {
        return "Hello, World!";
    }
}
