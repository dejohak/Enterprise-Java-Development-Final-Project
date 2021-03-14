package com.ironhack.forumservice.controller.impl;

import com.ironhack.forumservice.controller.interfaces.IForumController;
import com.ironhack.forumservice.dto.PostDTO;
import com.ironhack.forumservice.service.interfaces.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
@CrossOrigin(origins = "http://localhost:4200")
public class ForumController implements IForumController {

    @Autowired
    private IForumService forumService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<PostDTO> getAllPosts(){
        return forumService.getAllPosts();
    }

    @RequestMapping(value = "/create/post", method = RequestMethod.POST)
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        return forumService.createPost(postDTO);
    }

    @RequestMapping(value = "/delete/post/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("id") Long id) {
        forumService.deletePost(id);
    }
}
