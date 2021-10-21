package com.example.quesapptwo.services;

import com.example.quesapptwo.entities.Comment;
import com.example.quesapptwo.entities.Like;
import com.example.quesapptwo.entities.Post;
import com.example.quesapptwo.entities.User;
import com.example.quesapptwo.repository.LikeRepository;
import org.springframework.stereotype.Service;
import request.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private LikeRepository likeRepository;
    private PostService postService;
    private UserService userService;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }


    public List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return likeRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return likeRepository.findByPostId(postId.get());
        } else {
            return likeRepository.findAll();

        }
    }

    public Like getOneLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public void deleteOneLikeId(Long likeId) {
        likeRepository.deleteById(likeId);
    }

    public Like createOneLike(LikeCreateRequest request) {
        Post post = postService.getOnePostId(request.getPostId());
        User user = userService.getOneByUserId(request.getUserId());
        if (user != null && post != null) {
            Like likeToSave = new Like();
            likeToSave.setId(request.getId());
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return likeRepository.save(likeToSave);
        } else
            return null;
    }
}
