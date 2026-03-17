package dev.midnightcoder.midnightshift.albums.service;

import dev.midnightcoder.midnightshift.albums.domain.Album;
import dev.midnightcoder.midnightshift.albums.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-17
 */
@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    public List<Album> gteAllAlbumsForUser(Long userId, Integer page, Integer size) {
        var pageable = Pageable.ofSize(size).withPage(page);
        return albumRepository.findByUserId(userId, pageable);
    }
}
