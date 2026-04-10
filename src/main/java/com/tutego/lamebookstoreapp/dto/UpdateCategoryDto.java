package com.tutego.lamebookstoreapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryDto {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

}
