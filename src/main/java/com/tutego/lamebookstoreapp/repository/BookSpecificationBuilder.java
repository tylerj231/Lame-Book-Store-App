package com.tutego.lamebookstoreapp.repository;

import com.tutego.lamebookstoreapp.dto.BookSearchParameters;
import com.tutego.lamebookstoreapp.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {

    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters searchParameters) {
        Specification<Book> spec = Specification.unrestricted();
        if (searchParameters.titles() != null && !searchParameters.titles().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("title")
                    .getSpecification(searchParameters.titles()));
        }

        if (searchParameters.authors() != null && !searchParameters.authors().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("author")
                    .getSpecification(searchParameters.authors()));
        }

        if (searchParameters.isbns() != null && !searchParameters.isbns().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("isbn")
                    .getSpecification(searchParameters.isbns()));
        }

        if (searchParameters.prices() != null && !searchParameters.prices().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("price")
                    .getSpecification(searchParameters.prices()));
        }

        if (searchParameters.description() != null && !searchParameters.description().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("description")
                    .getSpecification(searchParameters.description()));
        }

        return spec;
    }
}
