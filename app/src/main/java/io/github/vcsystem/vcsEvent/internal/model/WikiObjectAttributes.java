package io.github.vcsystem.vcsEvent.internal.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WikiObjectAttributes {
    private String title;
    private String content;
    private String format;
    private String message;
    private String slug;
    private String url;
    private String action;
    @JsonAlias("diff_url")
    private String diffUrl;
}
