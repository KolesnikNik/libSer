package com.example.libSer.service;

import com.example.libSer.domain.Books;
import com.example.libSer.domain.Users;
import com.example.libSer.repos.BooksRepo;
import com.example.libSer.repos.UsersRepo;
import org.springframework.stereotype.Component;

@Component
public class BookAndUserServiceImp implements BookAndUserService{

    private final BooksRepo booksRepo;
    private final UsersRepo usersRepo;

    public BookAndUserServiceImp(BooksRepo booksRepo, UsersRepo usersRepo) {
        this.booksRepo = booksRepo;
        this.usersRepo = usersRepo;
    }

    @Override
    public Boolean setUsersForBooks(Users user, Books book) {
        if(usersRepo.existsById(user.getId()) && booksRepo.existsById(book.getId())){
            user.addBookForUser(book);
            book.addUserForBook(user);
            booksRepo.save(book);
            usersRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeUsersFromBooks(Users user, Books book) {
        if(usersRepo.existsById(user.getId()) && booksRepo.existsById(book.getId())){
            book.removeUserFromBook(user);
            user.removeBookFromUser(book);
            booksRepo.save(book);
            usersRepo.save(user);
            return true;
        }
        return false;
    }
}
