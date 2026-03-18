package dev.midnightcoder.midnightshift.photos.controller;

import dev.midnightcoder.midnightshift.photos.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-18
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/photos")
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping("/album/{albumId}")
    public String getPhoto(@PathVariable Long albumId,
                           @RequestParam(
                               required = false,
                               defaultValue = "0"
                           ) Integer page,
                           @RequestParam(
                               required = false,
                               defaultValue = "16"
                           ) Integer size,
                           Model model) {
        var photos = photoService.getAllPhotosForAlbum(albumId, page, size);
        model.addAttribute("photos", photos);
        return "fragments/photos :: photos";
    }
}
