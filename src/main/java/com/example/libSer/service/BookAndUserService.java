package com.example.libSer.service;

import com.example.libSer.domain.Books;
import com.example.libSer.domain.Users;


public interface BookAndUserService {
    /**
     * Добавляет владельца книги
     * @param user - пользователь, которого назначают владельцем
     * @param book - книга добавляемая пользователю
     * @return - true если книга была удалена, иначе false
     */
    Boolean setUsersForBooks(Users user, Books book);

    /**
     * Удаляет владельца у книги
     * @param user - пользователь, у которого удаляют книгу
     * @param book - книга удаляемая у пользователя
     * @return - true если книга была удалена, иначе false
     */
    Boolean removeUsersFromBooks(Users user, Books book);

}
