package dev.midnightcoder.midnightshift.albums.controller;

import dev.midnightcoder.midnightshift.albums.domain.Album;
import dev.midnightcoder.midnightshift.albums.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-17
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/albums")
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping("/{userId}")
    public List<Album> getAllAlbumsForUser(@PathVariable Long userId,
                                           @RequestParam(
                                               required = false,
                                               defaultValue = "0"
                                           ) Integer page,
                                           @RequestParam(
                                               required = false,
                                               defaultValue = "5"
                                           ) Integer size) {
        return albumService.gteAllAlbumsForUser(userId, page, size);
    }
}
