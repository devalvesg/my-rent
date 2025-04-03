package com.devalvesg.my_rent.Infrastructure.Repositories.Contract;

import com.devalvesg.my_rent.Domain.Entities.LessorEntity;
import com.devalvesg.my_rent.Domain.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILessorRepository extends JpaRepository<LessorEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
