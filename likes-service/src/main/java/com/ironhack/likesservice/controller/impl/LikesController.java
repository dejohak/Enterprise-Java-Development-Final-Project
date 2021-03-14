package com.ironhack.likesservice.controller.impl;

import com.ironhack.likesservice.controller.interfaces.ILikesController;
import com.ironhack.likesservice.dto.LikeDTO;
import com.ironhack.likesservice.service.interfaces.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "http://localhost:4200")
public class LikesController implements ILikesController {

    @Autowired
    private ILikesService likesService;

    @RequestMapping(value = "/likes", method = RequestMethod.GET)
    public List<LikeDTO> getAllLikes() {
        return likesService.getAllLikes();
    }

    @RequestMapping(value = "/likes/{id}", method = RequestMethod.GET)
    public LikeDTO getLikesById(@PathVariable("id") Long id) {
        return likesService.getLikesById(id);
    }

    @RequestMapping(value = "/popular", method = RequestMethod.GET)
    public Long getMostLikedRecipe() {
        return likesService.getPopularRecipe();
    }

    @RequestMapping(value = "/post/likes", method = RequestMethod.POST)
    public LikeDTO createLikes(@RequestBody @Valid LikeDTO likeDTO) {
        return likesService.postLikes(likeDTO);
    }

    @RequestMapping(value = "/update/likes/{id}", method = RequestMethod.PUT)
    public LikeDTO updateLikes(@PathVariable("id") Long id, @RequestBody @Valid LikeDTO likeDTO) {
        return likesService.updateLikes(id, likeDTO);
    }

    @RequestMapping(value = "/delete/likes/{id}", method = RequestMethod.DELETE)
    public void deleteLikes(@PathVariable("id") Long id) {
        likesService.deleteLikes(id);
    }
}
