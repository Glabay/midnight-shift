package dev.midnightcoder.midnightshift;

import dev.midnightcoder.midnightshift.albums.service.AlbumImportService;
import dev.midnightcoder.midnightshift.comments.service.CommentImportService;
import dev.midnightcoder.midnightshift.photos.service.PhotoImportService;
import dev.midnightcoder.midnightshift.posts.service.PostImportService;
import dev.midnightcoder.midnightshift.users.service.UserImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostImportService postImportService,
                                        CommentImportService commentImportService,
                                        UserImportService userImportService,
                                        AlbumImportService albumImportService,
                                        PhotoImportService photoImportService) {
        return args -> {
            postImportService.importPosts();
            commentImportService.importComments();
            userImportService.importUsers();
            albumImportService.importAlbums();
            photoImportService.importPhotos();
        };
    }
}