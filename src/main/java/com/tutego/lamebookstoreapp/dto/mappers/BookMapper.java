package com.tutego.lamebookstoreapp.dto.mappers;

import com.tutego.lamebookstoreapp.dto.BookDto;
import com.tutego.lamebookstoreapp.dto.CreateBookRequestDto;
import com.tutego.lamebookstoreapp.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    Book toBook(BookDto bookDto);

    Book toBook(CreateBookRequestDto bookRequestDto);

    @Mapping(target = "id", ignore = true)
    BookDto toDto(Book book);

    @Mapping(target = "id", ignore = true)
    BookDto toDto(CreateBookRequestDto bookRequestDto);

}
