package com.desafio.picpay.module.user.service;

import com.desafio.picpay.module.user.dto.UserCreateDTO;
import com.desafio.picpay.module.user.dto.UserResponseDTO;
import com.desafio.picpay.module.user.dto.UserUpdateDTO;

import java.util.Optional;

public interface UserServiceInterface {
    UserResponseDTO createUser(UserCreateDTO createDTO);
    UserResponseDTO updateUserOrUserNotFoundException(UserUpdateDTO updateDTO);
    void deleteUser(Long id);
    Optional<UserResponseDTO> findUserByIdOrThrowsUserNotFoundException(Long id);
    Optional<UserResponseDTO> findUserByEmailOrThrowsUserNotFoundException(String email);
    Optional<UserResponseDTO> findUserByDocumentNumberOrThrowsUserNotFoundException(String documentNumber);
}
