package com.example.libSer.service;

import com.example.libSer.domain.Books;
import com.example.libSer.repos.BooksRepo;
import com.example.libSer.repos.UsersRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImp implements BookService{

    private final BooksRepo booksRepo;
    private final UsersRepo usersRepo;
    public BookServiceImp(BooksRepo booksRepo, UsersRepo usersRepo) {
        this.booksRepo = booksRepo;
        this.usersRepo = usersRepo;
    }

    @Override
    public Boolean addBooks(String bookName, String author, Integer totalBooksCount) {
        if(!booksRepo.existsByBookName(bookName)) {
            Books book = new Books(bookName, author, totalBooksCount);
            booksRepo.save(book);
            return true;
        }
        return false;
    }

    @Override
    public List<Books> getAllBooks() {
        List<Books> books = booksRepo.findAll();
        return books;
    }

    @Override
    public Books getBooksById(Long id) {
        return booksRepo.getById(id);
    }

    @Override
    public Books getBooksByBookName(String bookName) {
        return booksRepo.getByBookName(bookName);
    }

    @Override
    public Boolean editBooks(Long id, String bookName, String author, Integer totalBooksCount) {
        if(booksRepo.existsById(id)) {
            Books book = booksRepo.getById(id);
            book.setBookName(bookName);
            book.setAuthor(author);
            book.setTotalBooksCount(totalBooksCount);
            booksRepo.save(book);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBooks(Long id) {
        if(booksRepo.existsById(id)) {
            booksRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
