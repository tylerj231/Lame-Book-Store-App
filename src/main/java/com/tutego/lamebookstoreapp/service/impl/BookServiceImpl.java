package com.tutego.lamebookstoreapp.service.impl;

import com.tutego.lamebookstoreapp.dto.BookDto;
import com.tutego.lamebookstoreapp.dto.CreateBookRequestDto;
import com.tutego.lamebookstoreapp.dto.mappers.BookMapper;
import com.tutego.lamebookstoreapp.exceptions.EntityNotFoundException;
import com.tutego.lamebookstoreapp.model.Book;
import com.tutego.lamebookstoreapp.repository.BookRepository;
import com.tutego.lamebookstoreapp.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto save(CreateBookRequestDto bookRequestDto) {
        Book book = bookMapper.toBook(bookRequestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }

    @Override
    public BookDto findById(Long id) throws EntityNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find a book by following id: " + id));
        return bookMapper.toDto(book);
    }
}
