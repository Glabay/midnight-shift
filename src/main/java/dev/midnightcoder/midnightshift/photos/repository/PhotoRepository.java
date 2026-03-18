package dev.midnightcoder.midnightshift.photos.repository;

import dev.midnightcoder.midnightshift.photos.domain.Photo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findByAlbumId(Long albumId, Pageable pageable);
}