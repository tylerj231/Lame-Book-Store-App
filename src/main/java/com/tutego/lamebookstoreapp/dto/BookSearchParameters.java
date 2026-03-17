package com.tutego.lamebookstoreapp.dto;

import java.util.List;

public record BookSearchParameters(
        List<String> titles,
        List<String> authors,
        List<String> description,
        List<String> isbns,
        List<String> prices
) {

}
