package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        // Exercise 1: load the Spring IoC container from applicationContext.xml
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Exercise 2: BookRepository was injected into BookService by Spring
        BookService bookService = context.getBean("bookService", BookService.class);

        bookService.displayBooks();
        bookService.searchBook("Effective Java");
        bookService.searchBook("Unknown Title");

        context.close();
    }
}