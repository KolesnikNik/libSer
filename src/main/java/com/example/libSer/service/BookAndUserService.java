package com.example.libSer.service;

import com.example.libSer.domain.Book;
import com.example.libSer.domain.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface BookAndUserService {
    /**
     * Добавляет книгу пользователю
     *
     * @param userId - ID пользователь, которого назначают владельцем
     * @param bookId - ID книга добавляемая пользователю
     * @return - true если книга была добавлена, иначе false
     */
    @Transactional
    Boolean setBookToUser(long userId, long bookId);

    /**
     * Удаляет книги упользователя
     *
     * @param userId - ID пользователь, у которого удаляют книгу
     * @param bookId - ID книга удаляемая у пользователя
     * @return - true если книга была удалена, иначе false
     */
    @Transactional
    Boolean removeBookFromUser(long userId, long bookId);

}
