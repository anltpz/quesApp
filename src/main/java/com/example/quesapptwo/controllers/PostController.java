package com.example.quesapptwo.controllers;

import com.example.quesapptwo.entities.Post;
import com.example.quesapptwo.entities.User;
import org.springframework.web.bind.annotation.*;
import com.example.quesapptwo.services.PostService;
import request.PostCreateRequest;
import request.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId)//parametreleri parcalayıp alır
    {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}") // şlaşdan sonraki degeri alıyor
    public Post getOnePost(@PathVariable Long postId) {
        return postService.getOnePostId(postId);
    }

    //+
    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);

    }

    @PutMapping("/{postId}")//guncelleme
    public Post updateOneUser(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {

        return postService.updateOnePostById(postId, updatePost);

    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId) {
        postService.deleteOnePostById(postId);
    }

}
