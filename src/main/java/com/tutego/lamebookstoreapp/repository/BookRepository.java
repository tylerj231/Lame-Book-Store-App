package com.tutego.lamebookstoreapp.repository;

import com.tutego.lamebookstoreapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
