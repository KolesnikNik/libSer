package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

}
