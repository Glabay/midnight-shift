package dev.midnightcoder.midnightshift.photos.service;

import dev.midnightcoder.midnightshift.photos.domain.Photo;
import dev.midnightcoder.midnightshift.photos.dto.PhotoResponse;
import dev.midnightcoder.midnightshift.photos.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-18
 */
@Service
@RequiredArgsConstructor
public class PhotoImportService {
    private final RestClient restClient;
    private final PhotoRepository photoRepository;

    public void importPhotos() {
        var response = restClient.get()
            .uri("/photos")
            .retrieve()
            .body(new ParameterizedTypeReference<List<PhotoResponse>>() {});
        if (response == null || response.isEmpty()) {
            return;
        }
        var photos = response.stream()
            .map(photoResponse -> {
                var photo = new Photo();
                    photo.setId(photoResponse.id());
                    photo.setAlbumId(photoResponse.albumId());
                    photo.setTitle(photoResponse.title());
                    photo.setUrl(photoResponse.url());
                    photo.setThumbnailUrl(photoResponse.thumbnailUrl());
                return photo;
            })
            .toList();

        photoRepository.saveAll(photos);
    }
}
