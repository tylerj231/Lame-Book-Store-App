package com.tutego.lamebookstoreapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCategoryDto {
    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
}
