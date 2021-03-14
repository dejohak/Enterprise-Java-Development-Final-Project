package com.ironhack.forumservice.service.impl;

import com.ironhack.forumservice.dto.PostDTO;
import com.ironhack.forumservice.model.Post;
import com.ironhack.forumservice.repository.PostRepository;
import com.ironhack.forumservice.service.interfaces.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForumService implements IForumService {

    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post : posts) {
            postDTOS.add(new PostDTO(post.getId(), post.getTitle(), post.getName(), post.getComment()));
        }
        if (postDTOS.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no posts in the forum");
        } else {
            return postDTOS;
        }
    }

    public PostDTO createPost(PostDTO postDTO) {
        postRepository.save(new Post(postDTO.getId(), postDTO.getTitle(), postDTO.getName(), postDTO.getComment()));
        return postDTO;
    }

    public void deletePost(Long id) {
        if(postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found.");
    }
}
