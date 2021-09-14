package com.example.libSer.service;

import com.example.libSer.domain.User;
import com.example.libSer.repos.BookRepo;
import com.example.libSer.repos.UserRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public User getUserById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public User createUser(String userName, String password) {
        User user = null;
        if(!userRepo.existsByUserName(userName)){
            user = new User(userName, password);
            userRepo.save(user);
        }
        return user;
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
