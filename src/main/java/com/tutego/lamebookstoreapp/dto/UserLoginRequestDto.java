package com.tutego.lamebookstoreapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserLoginRequestDto(
        @NotEmpty
        @Email
        String email,

        @NotEmpty
        @Size(min = 8, max = 30)
        String password
) {
}
