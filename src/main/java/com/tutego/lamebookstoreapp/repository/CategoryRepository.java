package com.tutego.lamebookstoreapp.repository;

import com.tutego.lamebookstoreapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
