package com.example.libSer.service;

import com.example.libSer.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /**
     * Возвращает список, имеющихеся книг
     *
     * @return список книг
     */
    List<User> getAllUser();

    /**
     * Возвращает пользователя по id
     *
     * @param id - id пользователя
     * @return ользователя
     */
    User getUserById(long id);

    /**
     * Добавляет новuj пользователя
     *
     * @param userName - имя пользователя
     * @param password - пароль пользователя
     */
    User createUser(String userName, String password);

    /**
     * Удаляет пользователя
     *
     * @param id - id пользователя
     */
    Boolean deleteUser(Long id);

}
