package dev.midnightcoder.midnightshift.users.domain;

import dev.midnightcoder.midnightshift.users.dto.UserResponse;
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
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long userId;
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geo", referencedColumnName = "userId")
    private GeoLocation geo;
}
