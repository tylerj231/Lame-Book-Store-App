package com.tutego.lamebookstoreapp.dto.mappers;

import com.tutego.lamebookstoreapp.dto.CategoryDto;
import com.tutego.lamebookstoreapp.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDto);
}
