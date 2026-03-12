package com.tutego.lamebookstoreapp.service.impl;

import com.tutego.lamebookstoreapp.dto.BookDto;
import com.tutego.lamebookstoreapp.dto.BookSearchParameters;
import com.tutego.lamebookstoreapp.dto.CreateBookRequestDto;
import com.tutego.lamebookstoreapp.dto.UpdateBookRequestDto;
import com.tutego.lamebookstoreapp.dto.mappers.BookMapper;
import com.tutego.lamebookstoreapp.exceptions.EntityNotFoundException;
import com.tutego.lamebookstoreapp.model.Book;
import com.tutego.lamebookstoreapp.repository.BookRepository;
import com.tutego.lamebookstoreapp.repository.BookSpecificationBuilder;
import com.tutego.lamebookstoreapp.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto bookRequestDto) {
        Book book = bookMapper.toBook(bookRequestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public void updateById(UpdateBookRequestDto updateBookRequestDto) {
        Book book = bookMapper.toBook(updateBookRequestDto);
        bookRepository.save(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) throws EntityNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find a book by following id: " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto findByTitle(String title) {
        return bookMapper.toDto(bookRepository.findByTitleContainsIgnoreCase(title));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDto> search(BookSearchParameters params) {
        Specification<Book> bookSpecification = bookSpecificationBuilder.build(params);
        return bookRepository.findAll(bookSpecification).stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
