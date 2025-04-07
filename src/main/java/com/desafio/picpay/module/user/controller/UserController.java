package com.desafio.picpay.module.user.controller;

import com.desafio.picpay.module.user.dto.UserCreateDTO;
import com.desafio.picpay.module.user.dto.UserResponseDTO;
import com.desafio.picpay.module.user.dto.UserUpdateDTO;
import com.desafio.picpay.module.user.service.UserServiceInterface;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserServiceInterface service;

    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDTO> findUserByEmail(@PathVariable @Email String email) {
        Optional<UserResponseDTO> user = service.findUserByEmail(email);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable  @Positive Long id) {
        Optional<UserResponseDTO> user = service.findUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{document}")
    public ResponseEntity<UserResponseDTO> findUserByDocument(@PathVariable String document) {
        Optional<UserResponseDTO> user = service.findUserByDocumentNumber(document);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {

        if (userCreateDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        UserResponseDTO userToCreate = service.createUser(userCreateDTO);

        return new ResponseEntity<>(userToCreate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable @Positive Long id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        UserResponseDTO userUpdated = service.updateUser(userUpdateDTO);

        return new ResponseEntity<>(userUpdated, HttpStatus.NO_CONTENT);
    }

}
