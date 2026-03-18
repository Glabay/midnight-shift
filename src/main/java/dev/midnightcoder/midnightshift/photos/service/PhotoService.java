package dev.midnightcoder.midnightshift.photos.service;

import dev.midnightcoder.midnightshift.photos.domain.Photo;
import dev.midnightcoder.midnightshift.photos.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-18
 */
@Service
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;

    public List<Photo> getAllPhotosForAlbum(
        Long albumId,
        Integer page,
        Integer size
    ) {
        var pageable = Pageable.ofSize(size).withPage(page);
        return photoRepository.findByAlbumId(albumId, pageable);
    }
}
