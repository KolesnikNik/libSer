package com.example.libSer.service;

import com.example.libSer.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    /**
     * Добавляет новую книгу
     * @param bookName - название книги
     * @param author - имя автора книги
     * @param totalBooksCount - количество книг
     */
    Book addBook(String bookName, String author, Integer totalBooksCount);

    /**
     * Возвращает список, имеющихеся книг
     * @return список книг
     */
    List<Book> getAllBook();

    /**
     * Возвращает книгу по её ID
     * @param id - ID книги
     * @return книга по ID
     */
    Book getBookById(long id);

    /**
     * Возвращает книгу по её названию.
     * @param bookName - название книги
     * @return книга по названию
     */
    Book getBookByBookName(String bookName);

    /**
     * Обновляет книги по ее ID
     * @param id - id книги, которую нужно обновить
     * @param bookName - новое имя книги
     * @param author - новый автор книги
     * @param totalBooksCount - новое значение кол-ва книг
     * @return - true если данные были обновлены, иначе false
     */
    Boolean editBook(long id, String bookName, String author, Integer totalBooksCount);

    /**
     * Удаляет книгу по заданным ID
     * @param id - id книги, которого нужно удалить
     * @return - true если книга была удалена, иначе false
     */
    Boolean deleteBook(long id);

}
