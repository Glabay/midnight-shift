package dev.midnightcoder.midnightshift.albums.service;

import dev.midnightcoder.midnightshift.albums.domain.Album;
import dev.midnightcoder.midnightshift.albums.dto.AlbumResponse;
import dev.midnightcoder.midnightshift.albums.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-17
 */
@Service
@RequiredArgsConstructor
public class AlbumImportService {
    private final RestClient restClient;
    private final AlbumRepository albumRepository;

    public void importAlbums() {
        var response = restClient.get()
            .uri("/albums")
            .retrieve()
            .body(new ParameterizedTypeReference<List<AlbumResponse>>() {});
        if (response == null || response.isEmpty()) {
            return;
        }
        var albums = response.stream()
            .map(albumResponse -> {
                var album = new Album();
                    album.setId(albumResponse.id());
                    album.setUserId(albumResponse.userId());
                    album.setTitle(albumResponse.title());
                return album;
            })
            .toList();

        albumRepository.saveAll(albums);
    }

}
