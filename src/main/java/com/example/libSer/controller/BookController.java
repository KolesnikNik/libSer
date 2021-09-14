package com.example.libSer.controller;

import com.example.libSer.domain.Book;
import com.example.libSer.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestParam String bookName,
                                  @RequestParam String author,
                                  @RequestParam Integer totalBooksCount) {
        Book book = bookService.addBook(bookName, author, totalBooksCount);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }


}
