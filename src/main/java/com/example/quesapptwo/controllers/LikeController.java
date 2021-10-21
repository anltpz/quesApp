package com.example.quesapptwo.controllers;

import com.example.quesapptwo.entities.Like;
import com.example.quesapptwo.services.LikeService;
import org.springframework.web.bind.annotation.*;
import request.LikeCreateRequest;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
public class LikeController {

    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping //Bütün likeları getirme
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return likeService.getAllLikesWithParam(userId, postId);

    }

    @GetMapping("/{likeId}")  // tek like getirme
    public Like getOneLİke(@PathVariable Long likeId) {
        return likeService.getOneLikeById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {

        likeService.deleteOneLikeId(likeId);
    }
    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest request)
    {
        return  likeService.createOneLike(request);
    }

}
