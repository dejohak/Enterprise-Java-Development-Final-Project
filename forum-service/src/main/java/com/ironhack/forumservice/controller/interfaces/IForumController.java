package com.ironhack.forumservice.controller.interfaces;

import com.ironhack.forumservice.dto.PostDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IForumController {

    List<PostDTO> getAllPosts();

    PostDTO createPost(@RequestBody @Valid PostDTO postDTO);

    void deletePost(@PathVariable("id") Long id);
}
