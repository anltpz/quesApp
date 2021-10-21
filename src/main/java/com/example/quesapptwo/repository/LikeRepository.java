package com.example.quesapptwo.repository;

import com.example.quesapptwo.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUserIdAndPostId(Long postId, Long likeId);

    List<Like> findByPostId(Long postId);

    List<Like> findByUserId(Long userId);
}