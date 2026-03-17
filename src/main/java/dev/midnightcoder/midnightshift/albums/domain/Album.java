package dev.midnightcoder.midnightshift.albums.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-17
 */
@Getter
@Setter
@Entity
@Table(name = "albums")
public class Album {
    @Id
    private Long id;
    private Long userId;
    private String title;
}
