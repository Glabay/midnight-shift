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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Long userId;
    private String name;
    private String username;
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address", referencedColumnName = "userId", nullable = false)
    private Address address;
    private String phone;
    private String website;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company", referencedColumnName = "userId", nullable = false)
    private Company company;
}
