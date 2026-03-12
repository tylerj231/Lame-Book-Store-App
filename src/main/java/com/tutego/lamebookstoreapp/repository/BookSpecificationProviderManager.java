package com.tutego.lamebookstoreapp.repository;

import com.tutego.lamebookstoreapp.model.Book;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {

    private final List<SpecificationProvider<Book>> bookSpecificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return bookSpecificationProviders.stream()
                .filter(provider -> provider.getKey().equals(key))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException(
                        "Can't find specification provider with the following key: " + key
                        )
                );
    }
}

