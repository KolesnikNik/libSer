package com.example.libSer.controller;

import com.example.libSer.domain.User;
import com.example.libSer.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public List<User> getAllBooks() {
        return userService.getAllUser();
    }

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestParam String userName,
                                     @RequestParam String password) {
        User user = userService.createUser(userName, password);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity getUser(@RequestParam int userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
