package com.example.libSer.repos;

import com.example.libSer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> getAll();
    User getById(Long id);
    Boolean existsByUserName(String userName);
    User getByUsername(String name);
    User save(User user);
    void deleteById(Long id);
}
