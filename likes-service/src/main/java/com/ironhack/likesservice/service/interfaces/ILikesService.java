package com.ironhack.likesservice.service.interfaces;

import com.ironhack.likesservice.dto.LikeDTO;

import java.util.List;

public interface ILikesService {

    List<LikeDTO> getAllLikes();

    LikeDTO getLikesById(Long id);

    LikeDTO updateLikes(Long id, LikeDTO likeDTO);

    void deleteLikes(Long id);

    LikeDTO postLikes(LikeDTO likeDTO);

    Long getPopularRecipe();
}
