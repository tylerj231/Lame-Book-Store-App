package com.tutego.lamebookstoreapp.repository;

import com.tutego.lamebookstoreapp.dto.BookSearchParameters;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build(BookSearchParameters searchParameters);
}
