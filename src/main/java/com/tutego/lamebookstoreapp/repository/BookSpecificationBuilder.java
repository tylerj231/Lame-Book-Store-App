package com.tutego.lamebookstoreapp.repository;

import com.tutego.lamebookstoreapp.dto.BookSearchParameters;
import com.tutego.lamebookstoreapp.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private static final String AUTHOR = "author";
    private static final String TITLE = "title";
    private static final String PRICE = "price";
    private static final String ISBN = "isbn";
    private static final String DESCRIPTION = "description";

    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters searchParameters) {
        Specification<Book> spec = Specification.unrestricted();
        if (searchParameters.titles() != null && !searchParameters.titles().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(TITLE)
                    .getSpecification(searchParameters.titles()));
        }

        if (searchParameters.authors() != null && !searchParameters.authors().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(AUTHOR)
                    .getSpecification(searchParameters.authors()));
        }

        if (searchParameters.isbns() != null && !searchParameters.isbns().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(ISBN)
                    .getSpecification(searchParameters.isbns()));
        }

        if (searchParameters.prices() != null && !searchParameters.prices().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(PRICE)
                    .getSpecification(searchParameters.prices()));
        }

        if (searchParameters.description() != null && !searchParameters.description().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider(DESCRIPTION)
                    .getSpecification(searchParameters.description()));
        }

        return spec;
    }
}
