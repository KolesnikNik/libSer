package com.example.libSer.controller;

import com.example.libSer.domain.User;
import com.example.libSer.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestParam String userName,
                                           @RequestParam String password) {
        User user = userService.createUser(userName, password);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public Boolean deleteUser(@PathVariable long userId) {
        return userService.deleteUser(userId);
    }

}
