package dev.midnightcoder.midnightshift.posts.repository;

import dev.midnightcoder.midnightshift.posts.domain.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
    List<Post> findByUserId(Long userId, Pageable pageable);

    Long countPostByUserId(Long userId);
}