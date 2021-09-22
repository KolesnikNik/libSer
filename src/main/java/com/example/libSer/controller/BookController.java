package com.example.libSer.controller;

import com.example.libSer.domain.Book;
import com.example.libSer.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
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

    @DeleteMapping("/{bookId}")
    public Boolean deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }

    @PatchMapping("/editBook")
    public ResponseEntity<Book> editBook(@RequestParam int bookId,
                                         @RequestParam String bookName,
                                         @RequestParam String author,
                                         @RequestParam Integer totalBooksCount,
                                         @RequestParam Integer booksCount) {
        Book book = null;
        if (bookService.editBook(bookId, bookName, author, totalBooksCount, booksCount))
            book = bookService.getBookById(bookId);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable long bookId) {
        return bookService.getBookById(bookId);
    }


    @GetMapping("/bookName/{name}")
    public Book getBookByBookName(@PathVariable(name = "name") String name) {
        return bookService.getBookByBookName(name);
    }


}
