package dev.midnightcoder.midnightshift.photos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-18
 */
@Getter
@Setter
@Entity
@Table(name = "photos")
public class Photo {
    @Id
    private Long id;
    private Long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;
}
