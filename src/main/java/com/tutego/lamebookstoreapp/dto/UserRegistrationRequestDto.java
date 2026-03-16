package com.tutego.lamebookstoreapp.dto;

import com.tutego.lamebookstoreapp.annotations.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.jspecify.annotations.Nullable;

@FieldMatch
@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationRequestDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 8, max = 30)
    private String password;

    @NotBlank
    @Length(min = 8, max = 30)
    private String repeatPassword;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Nullable
    private String shippingAddress;
}
