package io.github.vcsystem.vcsEvent.internal.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Commit {
    private String id;
    private String message;
    private String title;
    private String timestamp; // TODO change type to LocalDateTime
    private String url;
    private Author author;
    private List<String> added;
    private List<String> modified;
    private List<String> removed;
}
