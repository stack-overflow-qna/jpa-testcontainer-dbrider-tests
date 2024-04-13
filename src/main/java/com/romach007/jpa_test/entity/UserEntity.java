package com.romach007.jpa_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "`user`")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    UUID id;
    String name;
}
