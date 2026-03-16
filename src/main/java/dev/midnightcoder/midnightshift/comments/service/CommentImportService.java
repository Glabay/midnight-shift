package dev.midnightcoder.midnightshift.comments.service;

import dev.midnightcoder.midnightshift.comments.domain.Comment;
import dev.midnightcoder.midnightshift.comments.dto.CommentResponse;
import dev.midnightcoder.midnightshift.comments.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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
public class CommentImportService {
    private final RestClient restClient;
    private final CommentRepository commentRepository;

    public void importComments() {
        var response = restClient.get()
            .uri("/comments")
            .retrieve()
            .body(new ParameterizedTypeReference<List<CommentResponse>>() {});
        if (response == null || response.isEmpty()) {
            return;
        }

        var comments = response.stream()
            .map(comment -> {
                var model = new Comment();
                    model.setId(comment.id());
                    model.setPostId(comment.postId());
                    model.setName(comment.name());
                    model.setEmail(comment.email());
                    model.setBody(comment.body());
                return model;
            })
            .toList();

        commentRepository.saveAll(comments);
    }
}
