package com.tutego.lamebookstoreapp.repository;

import com.tutego.lamebookstoreapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitleContainsIgnoreCase(String title);

    void deleteById(Long id);
}
