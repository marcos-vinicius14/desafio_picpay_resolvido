package com.desafio.picpay.module.user.service;

import com.desafio.picpay.module.user.dto.UserCreateDTO;
import com.desafio.picpay.module.user.dto.UserResponseDTO;

import java.util.Optional;

public interface UserServiceInterface {
    UserResponseDTO createUser(UserCreateDTO dto);
    void updateUser(UserCreateDTO dto);
    void deleteUser(Long id);
    Optional<UserResponseDTO> findUserById(Long id);
    Optional<UserResponseDTO> findUserByEmail(String email);
    Optional<UserResponseDTO> findUserByDocumentNumber(String documentNumber);
}
