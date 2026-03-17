package dev.midnightcoder.midnightshift.posts.service;

import dev.midnightcoder.midnightshift.posts.domain.Post;
import dev.midnightcoder.midnightshift.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByUserId(Long userId, Integer pageId, Integer size) {
        var pageable = Pageable.ofSize(size).withPage(pageId);
        return postRepository.findByUserId(userId, pageable);
    }

    public Long getPostCountForUser(Long userId) {
        return postRepository.countPostByUserId(userId);
    }

    public List<Post> getHomePagePosts(Integer pageId, Integer size) {
        var pageable = Pageable.ofSize(size).withPage(pageId);
        var pagedResults = postRepository.findAll(pageable);
        return pagedResults.toList();
    }
}
