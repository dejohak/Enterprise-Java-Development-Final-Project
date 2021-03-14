package com.ironhack.likesservice.service.impl;

import com.ironhack.likesservice.dto.LikeDTO;
import com.ironhack.likesservice.model.Likes;
import com.ironhack.likesservice.repository.LikeRepository;
import com.ironhack.likesservice.service.interfaces.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LikesService implements ILikesService {

    @Autowired
    private LikeRepository likeRepository;

    public LikeDTO getLikesById(Long id) {
        Optional<Likes> like = likeRepository.findById(id);
        if (like.isPresent()) {
            return new LikeDTO(like.get().getId(), like.get().getLikes(), like.get().getDislikes());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found.");
    }

    public LikeDTO updateLikes(Long id, LikeDTO likeDTO) {
        Optional<Likes> like = likeRepository.findById(id);
        if(like.isPresent()) {
            like.get().setLikes(likeDTO.getLikes());
            like.get().setDislikes(likeDTO.getDislikes());
            likeRepository.save(like.get());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found.");
        return likeDTO;
    }

    public void deleteLikes(Long id) {
        if (likeRepository.existsById(id)) {
            likeRepository.deleteById(id);
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found.");
    }

    public LikeDTO postLikes(LikeDTO likeDTO) {
        List<Likes> recipes = likeRepository.findAll();
        if (recipes.size() > 0) {
            likeDTO.setId(recipes.get(recipes.size() - 1).getId() + 1);
        } else {
            likeDTO.setId(1L);
        }
        likeRepository.save(new Likes(likeDTO.getId(), likeDTO.getLikes(), likeDTO.getDislikes()));
        return likeDTO;
    }

    public Long getPopularRecipe() {
        List<Likes> likes = likeRepository.findAll();
        Long id = -1L;
        Long popular = -1L;
        if (!likes.isEmpty()) {
            for (Likes like : likes) {
                if (like.getLikes() > popular) {
                    popular = like.getLikes();
                    id = like.getId();
                }
            }
        } else throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no liked recipes.");
        return id;
    }

    public List<LikeDTO> getAllLikes() {
        List<Likes> likes = likeRepository.findAll();
        List<LikeDTO> likeDTOS = new ArrayList<>();
        for (Likes like : likes) {
            likeDTOS.add(new LikeDTO(like.getId(), like.getLikes(), like.getDislikes()));
        }
        if (likeDTOS.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "There are no recipes.");
        } else {
            return likeDTOS;
        }
    }
}
