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
    public Boolean setBookToUser(long userId, long bookId) {

        if (userRepo.existsById(userId) && bookRepo.existsById(bookId)) {
            User user = userRepo.findUserById(userId);
            Book book = bookRepo.findBookById(bookId);
            user.getBook().add(book);
            book.setBooksCount(book.getBooksCount() - 1);
            bookRepo.save(book);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeBookFromUser(long userId, long bookId) {
        if (userRepo.existsById(userId) && bookRepo.existsById(bookId)) {
            User user = userRepo.findUserById(userId);
            Book book = bookRepo.findBookById(bookId);
            user.getBook().remove(book);
            book.getUser().remove(user);
            book.setBooksCount(book.getBooksCount() + 1);
            bookRepo.save(book);
            userRepo.save(user);
            return true;
        }
        return false;
    }
}
