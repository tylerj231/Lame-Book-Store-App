package com.tutego.lamebookstoreapp.service.impl;

import com.tutego.lamebookstoreapp.dto.CategoryDto;
import com.tutego.lamebookstoreapp.dto.CreateCategoryDto;
import com.tutego.lamebookstoreapp.dto.UpdateCategoryDto;
import com.tutego.lamebookstoreapp.dto.mappers.CategoryMapper;
import com.tutego.lamebookstoreapp.exception.EntityNotFoundException;
import com.tutego.lamebookstoreapp.model.Category;
import com.tutego.lamebookstoreapp.repository.CategoryRepository;
import com.tutego.lamebookstoreapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<CategoryDto> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(categoryMapper::toDto);
    }

    @Override
    public CategoryDto getById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Could not find category with id: " + id)
        );
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto save(CreateCategoryDto categoryRequestDto) {
        Category category = categoryRepository.save(categoryMapper.toEntity(categoryRequestDto));
        return categoryMapper.toDto(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto updateCategoryDto) {
        return categoryMapper.toDto(
                categoryRepository.save(categoryMapper.toEntity(updateCategoryDto))
        );
    }
}
