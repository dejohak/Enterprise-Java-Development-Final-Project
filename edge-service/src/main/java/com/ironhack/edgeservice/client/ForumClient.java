package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient("forum-service")
public interface ForumClient {
    @RequestMapping(value = "/forum/posts", method = RequestMethod.GET)
    public List<PostDTO> getAllPosts();

    @RequestMapping(value = "/forum/create/post", method = RequestMethod.POST)
    public PostDTO createPost(@RequestBody @Valid PostDTO postDTO);

    @RequestMapping(value = "/forum/delete/post/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("id") Long id);
}
