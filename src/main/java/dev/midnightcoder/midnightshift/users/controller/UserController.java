package dev.midnightcoder.midnightshift.users.controller;

import dev.midnightcoder.midnightshift.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/{id}/username", produces = "text/plain")
    public String getUsernameById(@PathVariable Long id) {
        var username = userService.getUsernameById(id);
        return "<span>@%s</span>".formatted(username);
    }
}
