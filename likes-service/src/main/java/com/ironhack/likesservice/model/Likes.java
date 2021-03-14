package com.ironhack.likesservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Likes {
    @Id
    private Long id;
    private Long likes;
    private Long dislikes;

    public Likes() {
    }

    public Likes(Long id, Long likes, Long dislikes) {
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }
}
