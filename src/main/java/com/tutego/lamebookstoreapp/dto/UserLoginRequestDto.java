package com.tutego.lamebookstoreapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLoginRequestDto(
        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 8, max = 30)
        String password
) {
}
