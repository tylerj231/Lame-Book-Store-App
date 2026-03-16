package com.tutego.lamebookstoreapp.service;

import com.tutego.lamebookstoreapp.dto.UserRegistrationRequestDto;
import com.tutego.lamebookstoreapp.dto.UserResponseDto;
import com.tutego.lamebookstoreapp.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto request) throws RegistrationException;
}
