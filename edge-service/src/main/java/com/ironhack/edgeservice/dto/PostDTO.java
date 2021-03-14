package com.ironhack.edgeservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PostDTO {
    @NotNull
    @Positive
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50, message = "Posts' titles must be between 3 and 50 characters.")
    private String title;
    @NotBlank
    private String name;
    @NotBlank
    private String comment;

    public PostDTO() {
    }

    public PostDTO(Long id, String title, String name, String comment) {
        this.id = id;
        this.title = title;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
