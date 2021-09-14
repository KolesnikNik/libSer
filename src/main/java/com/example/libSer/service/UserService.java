package com.example.libSer.service;

import com.example.libSer.domain.Users;

import java.util.List;

public interface UserService {
    /**
     * Возвращает список, имеющихеся книг
     * @return список книг
     */
    List<Users> getAllUsers();

    /**
     * Возвращает пользователя по id
     * @param id - id пользователя
     * @return ользователя
     */
    Users getUsersById(Long id);

    /**
     * Добавляет новuj пользователя
     * @param userName - имя пользователя
     * @param password - пароль пользователя
     */
    Boolean createUsers(String userName, String password);

    /**
     * Удаляет пользователя
     * @param id - id пользователя
     */
    Boolean deleteUsers(Long id);

}
