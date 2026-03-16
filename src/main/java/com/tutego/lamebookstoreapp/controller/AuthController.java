package com.tutego.lamebookstoreapp.controller;

import com.tutego.lamebookstoreapp.dto.UserRegistrationRequestDto;
import com.tutego.lamebookstoreapp.dto.UserResponseDto;
import com.tutego.lamebookstoreapp.exception.RegistrationException;
import com.tutego.lamebookstoreapp.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserServiceImpl userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(
            @Valid @RequestBody UserRegistrationRequestDto request
    ) throws RegistrationException {
        return userService.register(request);

    }

}
