package dev.midnightcoder.midnightshift.comments.dto;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
public record CommentResponse(
    Long id,
    Long postId,
    String name,
    String email,
    String body
) {}
