package com.tutego.lamebookstoreapp.repository;

import com.tutego.lamebookstoreapp.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    void deleteById(Long id);

    List<Book> findAllByCategoriesId(Long categoryId);
}
