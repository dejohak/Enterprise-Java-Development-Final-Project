package com.ironhack.likesservice.controller.interfaces;

import com.ironhack.likesservice.dto.LikeDTO;

import java.util.List;

public interface ILikesController {

    List<LikeDTO> getAllLikes();

    Long getMostLikedRecipe();

    LikeDTO getLikesById(Long id);

    LikeDTO createLikes(LikeDTO likeDTO);

    LikeDTO updateLikes(Long id, LikeDTO likeDTO);

    void deleteLikes(Long id);
}
