package com.desafio.picpay.module.user.service;

import com.desafio.picpay.module.user.dto.UserCreateDTO;
import com.desafio.picpay.module.user.dto.UserResponseDTO;
import com.desafio.picpay.module.user.dto.UserUpdateDTO;

import java.util.Optional;

public interface UserServiceInterface {
    UserResponseDTO createUser(UserCreateDTO createDTO);
    UserResponseDTO updateUserOrThrowsResponseStatusException(UserUpdateDTO updateDTO);
    void deleteUser(Long id);
    Optional<UserResponseDTO> findUserByIdOrThrowsResponseStatusException(Long id);
    Optional<UserResponseDTO> findUserByEmailOrThrowsResponseStatusException(String email);
    Optional<UserResponseDTO> findUserByDocumentNumberOrThrowsResponseStatusException(String documentNumber);
}
