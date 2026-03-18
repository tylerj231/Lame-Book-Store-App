package com.tutego.lamebookstoreapp.dto.mappers;

import com.tutego.lamebookstoreapp.dto.UserRegistrationRequestDto;
import com.tutego.lamebookstoreapp.dto.UserResponseDto;
import com.tutego.lamebookstoreapp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toModel(UserRegistrationRequestDto registerUserRequestDto);

    UserResponseDto toDto(User user);
}
