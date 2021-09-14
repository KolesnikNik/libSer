package com.example.libSer.controller;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;
import com.example.libSer.service.BookAndUserService;
import com.example.libSer.service.BookService;
import com.example.libSer.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    private final BookService bookService;
    private final BookAndUserService bookAndUserService;
    private final UserService userService;
    public BooksController(BookService bookService, BookAndUserService bookAndUserService, UserService userService) {
        this.bookService = bookService;
        this.bookAndUserService = bookAndUserService;
        this.userService = userService;
    }

    @GetMapping("/")
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
    @PostMapping("/addUser")
    public ResponseEntity createUser(@RequestParam String userName,
                                  @RequestParam String password) {
        User user = userService.createUser(userName, password);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/addUserToBook")
    public void addUserToBook(@RequestParam int userId, @RequestParam int bookId){
        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);
        bookAndUserService.setUserForBook(user, book);
        //return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
