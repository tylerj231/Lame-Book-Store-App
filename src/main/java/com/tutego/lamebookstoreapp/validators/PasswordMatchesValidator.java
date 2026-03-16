package com.tutego.lamebookstoreapp.validators;

import com.tutego.lamebookstoreapp.annotations.FieldMatch;
import com.tutego.lamebookstoreapp.dto.UserRegistrationRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<FieldMatch, UserRegistrationRequestDto> {

    @Override
    public boolean isValid(
            UserRegistrationRequestDto dto,
            ConstraintValidatorContext constraintValidatorContext
    ) {
        return dto.getPassword() != null && dto.getPassword().equals(dto.getRepeatPassword());
    }
}
