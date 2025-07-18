package com.example.demo3A.service;

import com.example.demo3A.entity.User;
import com.example.demo3A.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(String username, String password) {
    	String hashedPassword = passwordEncoder.encode(password);
    	User user = new User();
    	user.setUsername(username);
    	user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByPassword(String password) {
        return userRepository.findByPassword(password);
    }
    public boolean authenticate(String username, String password) {
    	User user = userRepository.findByUsername(username);
    	if(user==null) return false;
    	return passwordEncoder.matches(password, user.getPassword());
    }

	public void save(User newUser) {
		// TODO Auto-generated method stub
		
	}
	
}



