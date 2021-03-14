package com.ironhack.forumservice.service.interfaces;

import com.ironhack.forumservice.dto.PostDTO;

import java.util.List;

public interface IForumService {
    List<PostDTO> getAllPosts();

    PostDTO createPost(PostDTO postDTO);

    void deletePost(Long id);
}
