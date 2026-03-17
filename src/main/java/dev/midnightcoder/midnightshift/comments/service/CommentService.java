package dev.midnightcoder.midnightshift.comments.service;

import dev.midnightcoder.midnightshift.comments.domain.Comment;
import dev.midnightcoder.midnightshift.comments.repository.CommentRepository;
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
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getCommentsByPostId(Long postId, Integer pageId, Integer size) {
        var pageable = Pageable.ofSize(size).withPage(pageId);
        return commentRepository.findByPostId(postId, pageable);
    }
}
