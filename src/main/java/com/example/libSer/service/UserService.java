package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;

import java.util.List;

public interface UserService {
    /**
     * Возвращает список, имеющихеся книг
     * @return список книг
     */
    List<User> getAllUsers();

    /**
     * Возвращает пользователя по id
     * @param id - id пользователя
     * @return ользователя
     */
    User getUserById(Long id);

    /**
     * Добавляет новuj пользователя
     * @param userName - имя пользователя
     * @param password - пароль пользователя
     */
    Boolean createUser(String userName, String password);

    /**
     * Удаляет пользователя
     * @param id - id пользователя
     */
    Boolean deleteUser(Long id);

    /**
     * Привязывает книгу к пользователю
     * @param user - пользователь, которого назначают владельцем
     * @param book - книга добавляемая пользователю
     * @return - true если книга была удалена, иначе false
     */
    Boolean addBookForUser(User user, Book book);

    /**
     * Удаляет книгу у пользователю
     * @param user - пользователь, у которого удаляют книгу
     * @param book - книга удаляемая у пользователя
     * @return - true если книга была удалена, иначе false
     */
    Boolean removeBookFromUser(User user, Book book);

}
