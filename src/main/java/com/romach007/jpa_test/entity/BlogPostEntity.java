package com.romach007.jpa_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "blog_post")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogPostEntity {
    @Id
    UUID id;
    String content;
}
