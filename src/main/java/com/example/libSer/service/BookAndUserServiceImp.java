package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;
import com.example.libSer.repos.BookRepo;
import com.example.libSer.repos.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class BookAndUserServiceImp implements BookAndUserService{

    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public BookAndUserServiceImp(BookRepo bookRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Boolean setUserForBook(User user, Book book) {
        if(userRepo.existsById(user.getId()) && bookRepo.existsById(book.getId())){
            user.addBookForUser(book);
            book.addUserForBook(user);
            bookRepo.save(book);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeUserFromBook(User user, Book book) {
        if(userRepo.existsById(user.getId()) && bookRepo.existsById(book.getId())){
            book.removeUserFromBook(user);
            user.removeBookFromUser(book);
            bookRepo.save(book);
            userRepo.save(user);
            return true;
        }
        return false;
    }
}
