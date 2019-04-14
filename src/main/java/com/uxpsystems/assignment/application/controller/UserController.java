package com.uxpsystems.assignment.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.application.entities.Status;
import com.uxpsystems.assignment.application.entities.User;
import com.uxpsystems.assignment.application.persistence.UserRepository;
import com.uxpsystems.assignment.application.service.UserService;

@RestController
@RequestMapping("/assignment")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository repository;
	
	@RequestMapping("/save")
    public String process(){
        repository.save(new User(11111L,"Jack","jjjj",Status.ACTIVATED));
        repository.save(new User(22222L,"Adam","aaaa",Status.ACTIVATED));
        repository.save(new User(33333L,"Kim","kkkk",Status.ACTIVATED));
        repository.save(new User(44444L,"David","dddd",Status.ACTIVATED));
        repository.save(new User(55555L,"Peter","pppp",Status.DEACTIVATED));
        return "Done";
    }
	
	@GetMapping("/users")
    public List getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(Long.parseLong(id));
    }

    @PostMapping("/users")
    public void addBook(@RequestBody User user) {
    	userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User user) {
    	userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
    	userService.deleteUser(Long.parseLong(id));
    }
}
