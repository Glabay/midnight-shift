package dev.midnightcoder.midnightshift.posts.service;

import dev.midnightcoder.midnightshift.posts.domain.Post;
import dev.midnightcoder.midnightshift.posts.dto.PostResponse;
import dev.midnightcoder.midnightshift.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
@Service
@RequiredArgsConstructor
public class PostImportService {
    private final RestClient restClient;
    private final PostRepository postRepository;

    public void importPosts() {
        var response = restClient.get()
            .uri("/posts")
            .retrieve()
            .body(new ParameterizedTypeReference<List<PostResponse>>() {});
        if (response == null || response.isEmpty()) {
            return;
        }

        var posts = response.stream()
            .map(post -> {
                var model = new Post();
                    model.setId(post.id());
                    model.setUserId(post.userId());
                    model.setTitle(post.title());
                    model.setBody(post.body());
                return model;
            })
            .toList();
        postRepository.saveAll(posts);
    }
}
