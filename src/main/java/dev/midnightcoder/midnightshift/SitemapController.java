package dev.midnightcoder.midnightshift;

import dev.midnightcoder.midnightshift.albums.service.AlbumService;
import dev.midnightcoder.midnightshift.photos.service.PhotoService;
import dev.midnightcoder.midnightshift.posts.service.PostService;
import dev.midnightcoder.midnightshift.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
@Controller
@RequiredArgsConstructor
public class SitemapController {
    private final PostService postService;
    private final UserService userService;
    private final AlbumService albumService;
    private final PhotoService photoService;

    @GetMapping
    public String sitemap(@RequestParam(
                              required = false,
                              defaultValue = "0"
                          ) Integer pageId,
                          @RequestParam(
                              required = false,
                              defaultValue = "25"
                          ) Integer size,
                          Model model) {
        var posts = postService.getHomePagePosts(pageId, size);
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/user/{userId}")
    public String user(@PathVariable Long userId,
                       @RequestParam(
                           required = false,
                           defaultValue = "0"
                       ) Integer pageId,
                       @RequestParam(
                           required = false,
                           defaultValue = "16"
                       ) Integer size,
                       Model model) {
        var cachedUser = userService.getUserById(userId);
        var userPosts = postService.getPostsByUserId(userId, pageId, size);
        var postCount = postService.getPostCountForUser(userId);
        var albums = albumService.getAllAlbumsForUser(userId, 0, 5);

        model.addAttribute("user", cachedUser);
        model.addAttribute("albums", albums);
        model.addAttribute("posts", userPosts);
        model.addAttribute("postCount", postCount);
        return "user-view";
    }

    @GetMapping("/album/{albumId}/photos")
    public String photoAlbum(@PathVariable Long albumId,
                       @RequestParam(
                           required = false,
                           defaultValue = "0"
                       ) Integer pageId,
                       @RequestParam(
                           required = false,
                           defaultValue = "16"
                       ) Integer size,
                       Model model) {
        var album = albumService.getAlbumById(albumId);
        var photos = photoService.getAllPhotosForAlbum(albumId, pageId, size);
        model.addAttribute("album", album);
        model.addAttribute("photos", photos);
        return "album-photo-view";
    }
}
