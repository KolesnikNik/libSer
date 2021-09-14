package com.example.libSer.repos;

import com.example.libSer.domain.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepo extends JpaRepository<Books, Long> {
    Books getById(Long id);
    Boolean existsByBookName(String userName);
    Books getByBookName(String name);
    Books save(Books book);
    void deleteById(Long id);
}
