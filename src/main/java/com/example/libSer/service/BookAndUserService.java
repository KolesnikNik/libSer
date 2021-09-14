package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface BookAndUserService {
    /**
     * Добавляет книгу пользователю
     *
     * @param user - пользователь, которого назначают владельцем
     * @param book - книга добавляемая пользователю
     * @return - true если книга была добавлена, иначе false
     */
    Boolean setBookToUser(User user, Book book);

    /**
     * Удаляет книги упользователя
     *
     * @param user - пользователь, у которого удаляют книгу
     * @param book - книга удаляемая у пользователя
     * @return - true если книга была удалена, иначе false
     */
    Boolean removeBookFromUser(User user, Book book);

}
