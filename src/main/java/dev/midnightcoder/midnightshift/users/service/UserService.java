package dev.midnightcoder.midnightshift.users.service;

import dev.midnightcoder.midnightshift.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public String getUsernameById(Long id) {
        var response = userRepository.findByUserId(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return response.getUsername();
    }
}
