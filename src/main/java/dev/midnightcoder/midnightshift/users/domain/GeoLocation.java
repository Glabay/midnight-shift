package dev.midnightcoder.midnightshift.users.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
@Getter
@Setter
@Entity
@Table(name = "geo_locations")
public class GeoLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long userId;
    private String lat;
    private String lng;

}
