package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.dto.LikeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient("likes-service")
public interface LikesClient {
    @RequestMapping(value = "/recipes/likes", method = RequestMethod.GET)
    public List<LikeDTO> getAllLikes();

    @RequestMapping(value = "/recipes/likes/{id}", method = RequestMethod.GET)
    public LikeDTO getLikesById(@PathVariable("id") Long id);

    @RequestMapping(value = "/recipes/popular", method = RequestMethod.GET)
    public Long getMostLikedRecipe();

    @RequestMapping(value = "/recipes/post/likes", method = RequestMethod.POST)
    public LikeDTO createLikes(@RequestBody @Valid LikeDTO likeDTO);

    @RequestMapping(value = "/recipes/update/likes/{id}", method = RequestMethod.PUT)
    public LikeDTO updateLikes(@PathVariable("id") Long id, @RequestBody @Valid LikeDTO likeDTO);

    @RequestMapping(value = "/recipes/delete/likes/{id}", method = RequestMethod.DELETE)
    public void deleteLikes(@PathVariable("id") Long id);
}
