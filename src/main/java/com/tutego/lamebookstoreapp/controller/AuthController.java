package com.tutego.lamebookstoreapp.controller;

import com.tutego.lamebookstoreapp.dto.UserLoginRequestDto;
import com.tutego.lamebookstoreapp.dto.UserLoginResponseDto;
import com.tutego.lamebookstoreapp.dto.UserRegistrationRequestDto;
import com.tutego.lamebookstoreapp.dto.UserResponseDto;
import com.tutego.lamebookstoreapp.exception.RegistrationException;
import com.tutego.lamebookstoreapp.security.AuthenticationService;
import com.tutego.lamebookstoreapp.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication Service", description = "Authentication service for users")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserServiceImpl userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Register a new user",
            description = "Endpoint to register a new user"
    )
    public UserResponseDto register(
            @Valid @RequestBody UserRegistrationRequestDto request
    ) throws RegistrationException {
        return userService.register(request);

    }

    @PostMapping("/login")
    @Operation(
            summary = "Login into system",
            description = "Endpoint for the existing user to login"
    )
    public UserLoginResponseDto login(@Valid @RequestBody UserLoginRequestDto loginRequestDto) {
        return authenticationService.authenticate(loginRequestDto);
    }

}
