package dev.midnightcoder.midnightshift.comments.controller;

import dev.midnightcoder.midnightshift.comments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/posts/{postId}")
    public String getCommentsByPostId(@PathVariable Long postId,
                                      Model model)
    {
        var comments = commentService.getCommentsByPostId(postId);
        model.addAttribute("comments", comments);
        return "fragments/comments :: comments";
    }
}
