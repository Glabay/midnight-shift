package dev.midnightcoder.midnightshift.posts.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
@Getter
@Setter
@Entity
@Table
public class Post {
    @Id
    private Long id;
    private Long userId;
    private String title;
    private String body;
}
