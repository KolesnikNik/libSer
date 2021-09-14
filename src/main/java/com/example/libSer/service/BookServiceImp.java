package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.repos.BookRepo;
import com.example.libSer.repos.UserRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImp implements BooksService {

    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    public BookServiceImp(BookRepo bookRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void addBook(String bookName, String author, Integer totalBooksCount) {

        if(!bookRepo.existsByBookName(bookName)) {
            Book book = new Book(bookName, author, totalBooksCount);
            bookRepo.save(book);
        }
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = bookRepo.findAll();
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
