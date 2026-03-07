package com.tutego.lamebookstoreapp;

import com.tutego.lamebookstoreapp.model.Book;
import com.tutego.lamebookstoreapp.service.BookService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LameBookStoreAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LameBookStoreAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BookService bookService) {
        return args -> {

            Book book1 = new Book();
            book1.setTitle("The Pragmatic Programmer");
            book1.setAuthor("Andrew Hunt");
            book1.setIsbn("978-0201616224");
            book1.setPrice(new BigDecimal("45.99"));
            book1.setDescription("A classic programming book");
            book1.setCoverImage("pragmatic.jpg");

            Book book2 = new Book();
            book2.setTitle("Clean Code");
            book2.setAuthor("Robert C. Martin");
            book2.setIsbn("978-0132350884");
            book2.setPrice(new BigDecimal("39.99"));
            book2.setDescription("A handbook of agile software craftsmanship");
            book2.setCoverImage("cleancode.jpg");

            bookService.save(book1);
            bookService.save(book2);
            System.out.println("✅ Books saved successfully!");

            List<Book> books = bookService.findAll();
            System.out.println("✅ All books in DB:");
            books.forEach(book ->
                    System.out.println("  -> [" + book.getId() + "] "
                            + book.getTitle() + " by " + book.getAuthor()
                            + " | $" + book.getPrice())
            );
        };
    }
}
