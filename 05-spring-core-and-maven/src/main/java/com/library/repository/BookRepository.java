package com.library.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {

    private final List<String> books = Arrays.asList(
            "Clean Code",
            "Effective Java",
            "Head First Design Patterns"
    );

    public List<String> getAllBooks() {
        System.out.println("BookRepository: fetching books from data store...");
        return books;
    }

    public String findBookByTitle(String title) {
        return books.stream()
                .filter(b -> b.equalsIgnoreCase(title))
                .findFirst()
                .orElse("Book not found: " + title);
    }
}