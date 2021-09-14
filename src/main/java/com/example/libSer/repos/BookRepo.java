package com.example.libSer.repos;

import com.example.libSer.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Book findById(long id);

    Boolean existsByBookName(String userName);

    Book getByBookName(String name);
}
