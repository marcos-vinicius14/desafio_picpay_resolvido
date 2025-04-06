package com.desafio.picpay.module.user.service;

import com.desafio.picpay.module.user.dto.UserCreateDTO;
import com.desafio.picpay.module.user.dto.UserResponseDTO;
import com.desafio.picpay.module.user.exception.EmailAlreadyExistsException;
import com.desafio.picpay.module.user.mapper.UserMapper;
import com.desafio.picpay.module.user.model.UserModel;
import com.desafio.picpay.module.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserResponseDTO createUser(UserCreateDTO dto) {
        if (userRepository.existsUserEntityByEmail(dto.email())) {
            throw new EmailAlreadyExistsException();
        }

        UserModel user = UserMapper.toCreateDtoToModel(dto);
        userRepository.save(UserMapper.toEntity(user));

        return UserMapper.toDTO(user);
    }

    @Override
    public void updateUser(UserCreateDTO dto) {

    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public Optional<UserResponseDTO> findUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseDTO> findUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseDTO> findUserByDocumentNumber(String documentNumber) {
        return Optional.empty();
    }
}
