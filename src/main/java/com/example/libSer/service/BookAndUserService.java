package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;


public interface BookAndUserService {
    /**
     * Добавляет владельца книги
     * @param user - пользователь, которого назначают владельцем
     * @param book - книга добавляемая пользователю
     * @return - true если книга была удалена, иначе false
     */
    Boolean setUserForBook(User user, Book book);

    /**
     * Удаляет владельца у книги
     * @param user - пользователь, у которого удаляют книгу
     * @param book - книга удаляемая у пользователя
     * @return - true если книга была
     * удалена, иначе false
     */
    Boolean removeUserFromBook(User user, Book book);

}
