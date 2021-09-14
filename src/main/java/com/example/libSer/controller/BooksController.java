package com.example.libSer.controller;

import com.example.libSer.domain.Book;
import com.example.libSer.service.BooksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    private final BooksService booksService;
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/")
    public List<Book> getAllBooks(){
        return booksService.getAllBook();
    }

        @PostMapping ("/addBook")
    public ResponseEntity addBook(@RequestParam String bookName,
                                  @RequestParam String author,
                                  @RequestParam Integer totalBooksCount){
        booksService.addBook(bookName, author, totalBooksCount);
        Book book = new Book(bookName, author, totalBooksCount);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
