package com.codebattery.service;

import com.codebattery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebattery.domain.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(Long id) {
    	return userRepository.findById(id).get();
    }
    
}
