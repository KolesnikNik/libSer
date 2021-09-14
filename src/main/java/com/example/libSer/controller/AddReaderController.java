package com.example.libSer.controller;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;
import com.example.libSer.service.BookAndUserService;
import com.example.libSer.service.BookService;
import com.example.libSer.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AddReaderController {

    private final UserService userService;
    private final BookService bookService;
    private final BookAndUserService bookAndUserService;

    public AddReaderController(UserService userService, BookService bookService, BookAndUserService bookAndUserService) {
        this.userService = userService;
        this.bookService = bookService;
        this.bookAndUserService = bookAndUserService;
    }

    @PostMapping("/addUserOrBook")
    public Boolean addBookToUser(@RequestParam int userId, @RequestParam int bookId) {
        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);
        return bookAndUserService.setBookToUser(user, book);
    }

    @PostMapping("/removeUserOrBook")
    public Boolean removeBookFromUser(@RequestParam int userId, @RequestParam int bookId) {
        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);
        return bookAndUserService.removeBookFromUser(user, book);
    }
}
