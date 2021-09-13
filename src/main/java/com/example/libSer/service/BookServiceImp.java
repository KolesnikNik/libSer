package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;
import com.example.libSer.repos.BookRepo;
import com.example.libSer.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService{

    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    public BookServiceImp(BookRepo bookRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Boolean addBook(String bookName, String author, Integer totalBooksCount) {
        if(!bookRepo.existsByBookName(bookName)) {
            Book book = new Book(bookName, author, totalBooksCount);
            bookRepo.save(book);
            return true;
        }
        return false;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepo.getAll();
        return books;
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepo.getById(id);
    }

    @Override
    public Book getBookByBookName(String bookName) {
        return bookRepo.getByBookName(bookName);
    }

    @Override
    public Boolean editBook(Long id, String bookName, String author, Integer totalBooksCount) {
        if(bookRepo.existsById(id)) {
            Book book = bookRepo.getById(id);
            book.setBookName(bookName);
            book.setAuthor(author);
            book.setTotalBooksCount(totalBooksCount);
            bookRepo.save(book);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBook(Long id) {
        if(bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
