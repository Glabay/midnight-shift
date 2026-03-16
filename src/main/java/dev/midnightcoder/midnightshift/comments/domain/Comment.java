package dev.midnightcoder.midnightshift.comments.domain;

import jakarta.persistence.Column;
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
public class Comment {
    @Id
    private Long id;
    private Long postId;
    private String name;
    private String email;

    @Column(length = 500)
    private String body;
}
