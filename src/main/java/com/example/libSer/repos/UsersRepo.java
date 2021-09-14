package com.example.libSer.repos;

import com.example.libSer.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Users getById(Long id);
    Boolean existsByUserName(String userName);
    Users save(Users user);
    void deleteById(Long id);
}
