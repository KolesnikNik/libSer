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
    public ResponseEntity<Book> addBook(@RequestParam String bookName,
                                        @RequestParam String author,
                                        @RequestParam Integer totalBooksCount) {
        Book book = bookService.addBook(bookName, author, totalBooksCount);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping("/deleteBook")
    public Boolean deleteBook(@RequestParam int bookId) {
        return bookService.deleteBook(bookId);
    }

    @PostMapping("/editBook")
    public Boolean editBook(@RequestParam int id,
                            @RequestParam String bookName,
                            @RequestParam String author,
                            @RequestParam Integer totalBooksCount,
                            @RequestParam Integer booksCount) {

        return bookService.editBook(id, bookName, author, totalBooksCount, booksCount);
    }

    @PostMapping("/book")
    public ResponseEntity<Book> getBookById(@RequestParam int bookId) {
        Book book = bookService.getBookById(bookId);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    /*
    @PostMapping("/book")
    public ResponseEntity<Book> getBookByBookName(@RequestParam String bookName) {
        Book book = bookService.getBookByBookName(bookName);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    */


}
