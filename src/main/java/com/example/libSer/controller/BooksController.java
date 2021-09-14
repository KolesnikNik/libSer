package com.example.libSer.controller;

import com.example.libSer.domain.Books;
import com.example.libSer.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BooksController {
    private final BookService bookService;
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }
    @GetMapping("/main")
    public List<Books> getAllBooks(){
        return bookService.getAllBooks();
    }
    @RequestMapping("/addbook")
    public void addBook(String bookName, String author, Integer totalBooksCount){
        bookService.addBooks(bookName, author, totalBooksCount);
    }
}
