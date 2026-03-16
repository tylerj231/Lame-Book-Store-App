package com.tutego.lamebookstoreapp.controller;

import com.tutego.lamebookstoreapp.dto.BookDto;
import com.tutego.lamebookstoreapp.dto.BookSearchParameters;
import com.tutego.lamebookstoreapp.dto.CreateBookRequestDto;
import com.tutego.lamebookstoreapp.dto.mappers.BookMapper;
import com.tutego.lamebookstoreapp.service.impl.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Management", description = "Endpoints for managing books")
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookServiceImpl bookService;
    private final BookMapper bookMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create a new book",
            description = "Creates a new book record in the database"
    )
    public BookDto createBook(@RequestBody @Valid CreateBookRequestDto bookRequestDto) {
        return bookService.save(bookRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Update an existing book or create a new one",
            description = "Updates an existing book if one exists or creates a new one"
    )
    public BookDto updateBook(@RequestBody @Valid CreateBookRequestDto bookRequestDto) {
        return bookService.update(bookRequestDto);
    }

    @GetMapping
    @Operation(
            summary = "Retrieves all books",
            description = "Get books with default pagination. Sort & order ability is present"
    )
    public List<BookDto> getAll(Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get book by id",
            description = "Retrieves book by its id"
    )
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/search")
    @Operation(
            summary = "Filter books by specific criteria",
            description = "Filter books by: price, title, description, isbn, author."
    )
    public List<BookDto> search(BookSearchParameters searchParams) {
        return bookService.search(searchParams);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete book by id",
            description = "Delete a specific book by its id"
    )
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}
