package com.romach007.jpa_test.blog_post.repository;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.romach007.jpa_test.entity.UserEntity;
import com.romach007.jpa_test.repository.UserRepository;
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
//@DBUnit(caseSensitiveTableNames = true, escapePattern = "\"")
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @ServiceConnection
    @Container
    static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:16.1");

    @Autowired
    private UserRepository userRepository;

    @Test
    @DataSet("datasets/users.yml")
    public void shouldFindUserById() {
        // Given
        UserEntity expectedUser = new UserEntity();
        expectedUser.setId(UUID.fromString("2eff530f-5f91-402d-89c7-c4f3099c9833"));
        expectedUser.setName("User");

        // When
        UserEntity actualUser = userRepository.findUserById(UUID.fromString("2eff530f-5f91-402d-89c7-c4f3099c9833")).orElse(null);

        // Then
        assertEquals(expectedUser, actualUser);
    }
}
