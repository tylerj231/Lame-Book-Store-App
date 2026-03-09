package com.tutego.lamebookstoreapp.controller;

import com.tutego.lamebookstoreapp.dto.BookDto;
import com.tutego.lamebookstoreapp.dto.CreateBookRequestDto;
import com.tutego.lamebookstoreapp.dto.mappers.BookMapper;
import com.tutego.lamebookstoreapp.service.impl.BookServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookServiceImpl bookService;
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookServiceImpl bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public BookDto createBook(@RequestBody CreateBookRequestDto bookRequestDto) {
        return bookService.save(bookRequestDto);
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }
}
