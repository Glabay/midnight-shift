package dev.midnightcoder.midnightshift.users.repository;

import dev.midnightcoder.midnightshift.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUserId(Long userId);
}