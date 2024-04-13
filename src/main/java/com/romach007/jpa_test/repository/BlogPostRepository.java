package com.romach007.jpa_test.repository;

import com.romach007.jpa_test.entity.BlogPostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface BlogPostRepository extends CrudRepository<BlogPostEntity, UUID> {
    Optional<BlogPostEntity> findBlogPostById(UUID uuid);
}
