package com.desafio.picpay.module.user.service;

import com.desafio.picpay.module.user.dto.UserCreateDTO;
import com.desafio.picpay.module.user.dto.UserResponseDTO;
import com.desafio.picpay.module.user.dto.UserUpdateDTO;
import com.desafio.picpay.module.user.entity.UserEntity;
import com.desafio.picpay.module.user.exception.EmailAlreadyExistsException;
import com.desafio.picpay.module.user.mapper.UserMapper;
import com.desafio.picpay.module.user.model.UserModel;
import com.desafio.picpay.module.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserResponseDTO createUser(UserCreateDTO createDTO) {
        if (userRepository.existsUserEntityByEmail(createDTO.email())) {
            throw new EmailAlreadyExistsException();
        }

        UserModel user = UserMapper.toCreateDtoToModel(createDTO);
        userRepository.save(UserMapper.toEntity(user));

        return UserMapper.toDTO(user);
    }

    @Override
    public UserResponseDTO updateUserOrThrowsResponseStatusException(UserUpdateDTO updateDTO) {
        UserEntity userToUpdate = userRepository.findUserEntityByEmail(updateDTO.email())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!userToUpdate.getEmail().equals(updateDTO.email())) {
            if (userRepository.existsUserEntityByEmail(updateDTO.email())) {
                throw new EmailAlreadyExistsException();
            }
        }

        userToUpdate.setUserName(updateDTO.userName());
        userToUpdate.setEmail(updateDTO.email());
        userToUpdate.setPassword(updateDTO.password());

        UserEntity userUpdated = userRepository.save(userToUpdate);
        return UserMapper.toDTO(UserMapper.toDomainModel(userUpdated));

    }

    @Override
    public void deleteUser(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id user not found or no exists");
        }

        userRepository.deleteById(id);

    }

    @Override
    public Optional<UserResponseDTO> findUserByIdOrThrowsResponseStatusException(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        UserModel model = UserMapper.toDomainModel(entity);
        return Optional.of(UserMapper.toDTO(model));

    }

    @Override
    public Optional<UserResponseDTO> findUserByEmailOrThrowsResponseStatusException(String email) {
        UserEntity entity = userRepository.findUserEntityByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        UserModel userModel = UserMapper.toDomainModel(entity);
        return Optional.of(UserMapper.toDTO(userModel));

    }

    @Override
    public Optional<UserResponseDTO> findUserByDocumentNumberOrThrowsResponseStatusException(String documentNumber) {
        UserEntity userEntityByIdentifier = userRepository.findUserEntityByIdentifier(documentNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        UserModel model = UserMapper.toDomainModel(userEntityByIdentifier);
        return Optional.of(UserMapper.toDTO(model));
    }
}
