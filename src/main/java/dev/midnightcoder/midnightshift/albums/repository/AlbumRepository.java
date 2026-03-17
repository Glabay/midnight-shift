package dev.midnightcoder.midnightshift.albums.repository;

import dev.midnightcoder.midnightshift.albums.domain.Album;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByUserId(Long userId, Pageable pageable);
}