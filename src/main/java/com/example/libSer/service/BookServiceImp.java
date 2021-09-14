package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.repos.BookRepo;
import com.example.libSer.repos.UserRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {

    private final BookRepo bookRepo;

    public BookServiceImp(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book addBook(String bookName, String author, Integer totalBooksCount) {
        if (!bookRepo.existsByBookName(bookName)) {
            Book book = new Book(bookName, author, totalBooksCount);
            bookRepo.save(book);
            return book;
        }
        return null;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = bookRepo.findAll();
        return books;
    }

    @Override
    public Book getBookById(long id) {
        return bookRepo.findById(id);
    }

    @Override
    public Book getBookByBookName(String bookName) {
        return bookRepo.getByBookName(bookName);
    }

    @Override
    public Boolean editBook(long id, String bookName, String author, Integer totalBooksCount) {
        if (bookRepo.existsById(id)) {
            Book book = bookRepo.findById(id);
            book.setBookName(bookName);
            book.setAuthor(author);
            book.setBooksCount(totalBooksCount);
            bookRepo.save(book);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBook(long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
