package com.tutego.lamebookstoreapp.service;

import com.tutego.lamebookstoreapp.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();

}
