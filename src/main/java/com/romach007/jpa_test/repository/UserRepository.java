package com.romach007.jpa_test.repository;

import com.romach007.jpa_test.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
    Optional<UserEntity> findUserById(UUID id);
}
