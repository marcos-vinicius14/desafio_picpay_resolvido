package com.desafio.picpay.module.user.repository;

import com.desafio.picpay.module.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByIdentifier(String identifier);
    Optional<UserEntity> findUserEntityByEmail(String email);

    boolean existsUserEntityByEmail(String email);
}
