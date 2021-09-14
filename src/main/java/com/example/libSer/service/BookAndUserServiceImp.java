package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;
import com.example.libSer.repos.BookRepo;
import com.example.libSer.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class BookAndUserServiceImp implements BookAndUserService {

    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public BookAndUserServiceImp(BookRepo bookRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Boolean setBookToUser(User user, Book book) {
        if (userRepo.existsById(user.getId()) && bookRepo.existsById(book.getId())) {
            user.getBook().add(book);
            book.setBooksCount(book.getTotalBooksCount() - 1);
            bookRepo.save(book);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeBookFromUser(User user, Book book) {
        if (userRepo.existsById(user.getId()) && bookRepo.existsById(book.getId())) {
            user.getBook().remove(book);
            book.getUser().remove(user);
            book.setBooksCount(book.getTotalBooksCount() + 1);
            bookRepo.save(book);
            userRepo.save(user);
            return true;
        }
        return false;
    }
}
