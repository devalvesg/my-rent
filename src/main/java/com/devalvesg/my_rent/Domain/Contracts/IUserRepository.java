package com.devalvesg.my_rent.Domain.Contracts;

import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
