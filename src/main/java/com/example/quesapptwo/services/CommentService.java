package com.example.quesapptwo.services;

import com.example.quesapptwo.entities.Comment;
import com.example.quesapptwo.entities.Post;
import com.example.quesapptwo.entities.User;
import com.example.quesapptwo.repository.CommentRepository;
import org.springframework.stereotype.Service;
import request.CommentCreateRequest;
import request.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }


    public List<Comment> getCommentAllWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());

        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else {
            return commentRepository.findAll();

        }
    }

    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest request) {

        User user = userService.getOneByUserId(request.getUserId());
        Post post = postService.getOnePostId(request.getPostId());

        if (user != null && post != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(request.getId());
            commentToSave.setText(request.getText());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            return commentRepository.save(commentToSave);

        } else
            return null;
    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest request) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(request.getText());
          return   commentRepository.save(commentToUpdate);
        }
        return null;

    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
