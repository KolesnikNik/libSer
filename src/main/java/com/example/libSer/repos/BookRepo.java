package com.example.libSer.repos;

import com.example.libSer.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Boolean existsByBookName(String bookName);

    Book getBookByBookName(String bookName);

    Book findBookById(long id);
}
