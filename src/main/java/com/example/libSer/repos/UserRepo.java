package com.example.libSer.repos;

import com.example.libSer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findById(long id);
    Boolean existsByUserName(String userName);
}
