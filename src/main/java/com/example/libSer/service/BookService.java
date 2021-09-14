package com.example.libSer.service;

import com.example.libSer.domain.Books;

import java.util.List;


public interface BookService {
    /**
     * Добавляет новую книгу
     * @param bookName - название книги
     * @param author - имя автора книги
     * @param totalBooksCount - количество книг
     */
    Boolean addBooks(String bookName, String author, Integer totalBooksCount);

    /**
     * Возвращает список, имеющихеся книг
     * @return список книг
     */
    List<Books> getAllBooks();

    /**
     * Возвращает книгу по её ID
     * @param id - ID книги
     * @return книга по ID
     */
    Books getBooksById(Long id);

    /**
     * Возвращает книгу по её названию.
     * @param bookName - название книги
     * @return книга по названию
     */
    Books getBooksByBookName(String bookName);

    /**
     * Обновляет книги по ее ID
     * @param id - id книги, которую нужно обновить
     * @param bookName - новое имя книги
     * @param author - новый автор книги
     * @param totalBooksCount - новое значение кол-ва книг
     * @return - true если данные были обновлены, иначе false
     */
    Boolean editBooks(Long id, String bookName, String author, Integer totalBooksCount);

    /**
     * Удаляет книгу по заданным ID
     * @param id - id книги, которого нужно удалить
     * @return - true если книга была удалена, иначе false
     */
    Boolean deleteBooks(Long id);

}
