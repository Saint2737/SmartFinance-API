package com.example.demo3.service;

import com.example.demo3.entity.User;
import com.example.demo3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByPassword(String password) {
        return userRepository.findByPassword(password);
    }
    public boolean authenticate(String username, String password) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    }



