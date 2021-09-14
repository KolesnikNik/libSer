package com.example.libSer.service;

import com.example.libSer.domain.User;
import com.example.libSer.repos.BookRepo;
import com.example.libSer.repos.UserRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImp implements UserService{

    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    public UserServiceImp(BookRepo bookRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.getById(id);
    }

    @Override
    public Boolean createUser(String userName, String password) {
        if(!userRepo.existsByUserName(userName)){
            User user = new User(userName, password);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(Long id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
