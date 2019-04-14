package com.uxpsystems.assignment.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.application.entities.User;
import com.uxpsystems.assignment.application.persistence.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List getAllUsers() {
        List users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(Long id) {
        return (User) userRepository.findById(id).orElseGet(User::new);
    }

    public void addUser(User user) {
    	userRepository.save(user);
    }

    public void updateUser(String id, User user) {
    	userRepository.save(user);
    }

    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }

}
