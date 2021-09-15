package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.repos.BookRepo;
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
        return !(bookRepo.existsByBookName(bookName)) ?
            bookRepo.save(new Book(bookName, author, totalBooksCount)) : null;
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return bookRepo.existsById(id) ? bookRepo.findBookById(id) : null;
    }


    @Override
    public Book getBookByBookName(String bookName) {
        return bookRepo.existsByBookName(bookName) ?
                bookRepo.getBookByBookName(bookName) : null;
    }


    /**
     * Хорошо бы написать сюда билдер для иницилиализации нужных полей разом!!!
     */
    @Override
    public Boolean editBook(long id, String bookName, String author, int totalBooksCount, int setBooksCount) {
        if (bookRepo.existsById(id)) {
            Book book = bookRepo.findBookById(id);
            book.setBookName(bookName);
            book.setAuthor(author);
            book.setTotalBooksCount(totalBooksCount);
            book.setBooksCount(setBooksCount);
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
