package com.example.quesapptwo.controllers;

import com.example.quesapptwo.entities.Comment;
import com.example.quesapptwo.services.CommentService;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.web.bind.annotation.*;
import request.CommentCreateRequest;
import request.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComment(
            @RequestParam Optional<Long> userId,
            @RequestParam Optional<Long> postId
    ) {

        return commentService.getCommentAllWithParam(userId, postId);

    }

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable Long commentId) {
        return commentService.getOneCommentById(commentId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest request) {
        return commentService.createOneComment(request);
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request) {
        return commentService.updateOneCommentById(commentId, request);

    }

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId) {
        commentService.deleteOneCommentById(commentId);
    }


}
