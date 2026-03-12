package com.tutego.lamebookstoreapp.dto;

public record BookSearchParameters(
        String [] titles,
        String [] authors,
        String [] description,
        String [] isbns,
        String [] prices
) {

}
