package com.romach007.jpa_test.blog_post.repository;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.romach007.jpa_test.entity.BlogPostEntity;
import com.romach007.jpa_test.repository.BlogPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DBRider
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BlogPostRepositoryTest {
    @ServiceConnection
    @Container
    static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:16.1");

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Test
    @DataSet("datasets/blogPosts.yml")
    public void shouldFindBlogPostById() {
        // Given
        BlogPostEntity expectedBlogPost = new BlogPostEntity();
        expectedBlogPost.setId(UUID.fromString("2eff530f-5f91-402d-89c7-c4f3099c9833"));
        expectedBlogPost.setContent("Test content");

        // When
        BlogPostEntity actualBlogPost = blogPostRepository.findBlogPostById(UUID.fromString("2eff530f-5f91-402d-89c7-c4f3099c9833")).orElse(null);

        // Then
        assertEquals(expectedBlogPost, actualBlogPost);
    }
}
