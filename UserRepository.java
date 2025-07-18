package com.example.demo3A.repository;

import com.example.demo3A.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByPassword(String password);
    
    boolean existsByUsername(String username);

    User save(User user);
}
