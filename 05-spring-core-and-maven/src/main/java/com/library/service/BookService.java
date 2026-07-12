package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter method used by Spring for Dependency Injection (Exercise 2)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("BookService: listing all books");
        bookRepository.getAllBooks().forEach(b -> System.out.println("  - " + b));
    }

    public void searchBook(String title) {
        System.out.println("BookService: search result -> "
                + bookRepository.findBookByTitle(title));
    }
}