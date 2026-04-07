package com.tutego.lamebookstoreapp.service;

import com.tutego.lamebookstoreapp.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<CategoryDto> findAll(Pageable pageable);

    CategoryDto getById(Long id);

    CategoryDto save(CategoryDto categoryRequestDto);

    CategoryDto update(CategoryDto categoryDto);

    void deleteById(Long id);
}
