package dev.midnightcoder.midnightshift;

import dev.midnightcoder.midnightshift.posts.repository.PostRepository;
import dev.midnightcoder.midnightshift.posts.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping
    public String sitemap(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "index";
    }
}
