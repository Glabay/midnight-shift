package dev.midnightcoder.midnightshift.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * @author Glabay | Glabay-Studios
 * @project midnight-shift
 * @social Discord: Glabay
 * @since 2026-03-15
 */
@Configuration
public class RestClientConfig {

    @Bean
    RestClient restClient() {
        return RestClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build();
    }
}
