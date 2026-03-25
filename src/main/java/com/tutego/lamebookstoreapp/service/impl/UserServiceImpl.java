package com.tutego.lamebookstoreapp.service.impl;

import com.tutego.lamebookstoreapp.dto.UserRegistrationRequestDto;
import com.tutego.lamebookstoreapp.dto.UserResponseDto;
import com.tutego.lamebookstoreapp.dto.mappers.UserMapper;
import com.tutego.lamebookstoreapp.exception.RegistrationException;
import com.tutego.lamebookstoreapp.model.User;
import com.tutego.lamebookstoreapp.repository.UserRepository;
import com.tutego.lamebookstoreapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto register(
            UserRegistrationRequestDto request
    ) throws RegistrationException {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RegistrationException(
                    "user with email %s already exists".formatted(request.getEmail())
            );
        }
        User user = userMapper.toModel(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }
}
