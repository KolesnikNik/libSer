package com.example.libSer.controller;

import com.example.libSer.service.BookAndUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddReaderController {

    private final BookAndUserService bookAndUserService;

    public AddReaderController(BookAndUserService bookAndUserService) {
        this.bookAndUserService = bookAndUserService;
    }

    @PostMapping("/addUserOrBook")
    public Boolean addBookToUser(@RequestParam long userId, @RequestParam long bookId) {
        return bookAndUserService.setBookToUser(userId, bookId);
    }

    @PostMapping("/removeUserOrBook")
    public Boolean removeBookFromUser(@RequestParam long userId, @RequestParam long bookId) {
        return bookAndUserService.removeBookFromUser(userId, bookId);
    }
}
