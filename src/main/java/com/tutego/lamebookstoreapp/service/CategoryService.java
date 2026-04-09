package com.tutego.lamebookstoreapp.service;

import com.tutego.lamebookstoreapp.dto.CategoryDto;
import com.tutego.lamebookstoreapp.dto.CreateCategoryDto;
import com.tutego.lamebookstoreapp.dto.UpdateCategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<CategoryDto> findAll(Pageable pageable);

    CategoryDto getById(Long id);

    CategoryDto save(CreateCategoryDto categoryRequestDto);

    CategoryDto update(UpdateCategoryDto updateCategoryDto);

    void deleteById(Long id);
}
