package com.uca.parcialfinalncapas.service.impl;

import com.uca.parcialfinalncapas.dto.request.UserCreateRequest;
import com.uca.parcialfinalncapas.dto.request.UserUpdateRequest;
import com.uca.parcialfinalncapas.dto.response.UserResponse;
import com.uca.parcialfinalncapas.entities.User;
import com.uca.parcialfinalncapas.exceptions.UserNotFoundException;
import com.uca.parcialfinalncapas.repository.UserRepository;
import com.uca.parcialfinalncapas.service.UserService;
import com.uca.parcialfinalncapas.utils.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse findByCorreo(String correo) {
        User u = userRepository.findByCorreo(correo)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con correo: " + correo));
        return UserMapper.toDTO(u);
    }

    @Override
    public UserResponse save(UserCreateRequest req) {
        if (userRepository.findByCorreo(req.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un usuario con el correo: " + req.getCorreo());
        }

        User toSave = UserMapper.toEntityCreate(req);
        toSave.setPassword(passwordEncoder.encode(req.getPassword()));

        User saved = userRepository.save(toSave);
        return UserMapper.toDTO(saved);
    }

    @Override
    public UserResponse update(UserUpdateRequest req) {
        User existing = userRepository.findById(req.getId())
                .orElseThrow(() -> new UserNotFoundException("No se encontró un usuario con el ID: " + req.getId()));

        existing.setNombre(req.getNombre());
        existing.setNombreRol(req.getNombreRol());

        if (req.getPassword() != null && !req.getPassword().isBlank()) {
            existing.setPassword(passwordEncoder.encode(req.getPassword()));
        }

        User updated = userRepository.save(existing);
        return UserMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("No se encontró un usuario con el ID: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }
}
