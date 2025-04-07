package com.desafio.picpay.module.user.service;

import com.desafio.picpay.module.user.dto.UserCreateDTO;
import com.desafio.picpay.module.user.dto.UserResponseDTO;
import com.desafio.picpay.module.user.dto.UserUpdateDTO;

import java.util.Optional;

public interface UserServiceInterface {
    UserResponseDTO createUser(UserCreateDTO createDTO);
    UserResponseDTO updateUser(UserUpdateDTO updateDTO);
    void deleteUser(Long id);
    Optional<UserResponseDTO> findUserById(Long id);
    Optional<UserResponseDTO> findUserByEmail(String email);
    Optional<UserResponseDTO> findUserByDocumentNumber(String documentNumber);
}
