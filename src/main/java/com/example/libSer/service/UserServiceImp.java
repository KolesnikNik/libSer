package com.example.libSer.service;

import com.example.libSer.domain.User;
import com.example.libSer.repos.BookRepo;
import com.example.libSer.repos.UserRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepo.existsById(id) ? userRepo.findById(id) : null;
    }

    @Override
    public User createUser(String userName, String password) {

        return !(userRepo.existsByUserName(userName)) ?
                userRepo.save(new User(userName, password)) : null;
    }

    @Override
    public Boolean deleteUser(long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
