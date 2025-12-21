package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;

    //Constructor
    public UserServiceImpl(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    //Methods
    @Override
    public User register(User user) 
    {
        if (userRepository.existsByEmail(user.getEmail())) 
        {
            throw new IllegalArgumentException("Email already exists");
        }
        if (user.getRole() == null) 
        {
            user.setRole(User.Role.ANALYST);
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) 
    {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}