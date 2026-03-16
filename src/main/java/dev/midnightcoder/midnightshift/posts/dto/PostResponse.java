package dev.midnightcoder.midnightshift.posts.dto;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
public record PostResponse(
    Long id,
    Long userId,
    String title,
    String body
) {}
