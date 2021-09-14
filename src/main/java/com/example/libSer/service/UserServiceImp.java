package com.example.libSer.service;

import com.example.libSer.domain.Users;
import com.example.libSer.repos.BooksRepo;
import com.example.libSer.repos.UsersRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImp implements UserService{

    private final BooksRepo booksRepo;
    private final UsersRepo usersRepo;
    public UserServiceImp(BooksRepo booksRepo, UsersRepo usersRepo) {
        this.booksRepo = booksRepo;
        this.usersRepo = usersRepo;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = usersRepo.findAll();
        return users;
    }

    @Override
    public Users getUsersById(Long id) {
        return usersRepo.getById(id);
    }

    @Override
    public Boolean createUsers(String userName, String password) {
        if(!usersRepo.existsByUserName(userName)){
            Users user = new Users(userName, password);
            usersRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUsers(Long id) {
        if(usersRepo.existsById(id)){
            usersRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
