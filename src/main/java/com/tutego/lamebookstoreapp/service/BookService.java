package com.tutego.lamebookstoreapp.service;

import com.tutego.lamebookstoreapp.dto.BookDto;
import com.tutego.lamebookstoreapp.dto.BookSearchParameters;
import com.tutego.lamebookstoreapp.dto.CreateBookRequestDto;
import com.tutego.lamebookstoreapp.dto.UpdateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto bookRequestDto);

    void updateById(UpdateBookRequestDto bookUpdateDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    BookDto findByTitle(String title);

    void deleteById(Long id);

    List<BookDto> search(BookSearchParameters params);

}
