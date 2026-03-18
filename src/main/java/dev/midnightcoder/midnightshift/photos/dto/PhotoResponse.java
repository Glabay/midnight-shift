package dev.midnightcoder.midnightshift.photos.dto;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-18
 */
public record PhotoResponse(
    Long id,
    Long albumId,
    String title,
    String url,
    String thumbnailUrl
) {}
