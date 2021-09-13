package com.example.libSer.repos;

import com.example.libSer.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> getAll();
    Book getById(Long id);
    Boolean existsByBookName(String userName);
    Book getByBookName(String name);
    Book save(Book book);
    void deleteById(Long id);
}
