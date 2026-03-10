package com.assessment2.assessment2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assessment2.assessment2.entity.User;
import com.assessment2.assessment2.repository.UserRepository;

@Service
public class UserService {
	 @Autowired
	    private UserRepository userRepo;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public User saveUser(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepo.save(user);
	    }

}