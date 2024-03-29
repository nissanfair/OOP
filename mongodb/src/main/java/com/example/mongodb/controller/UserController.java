package com.example.mongodb.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.model.User;
import com.example.mongodb.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        // if (existinguser!= null){
        // boolean check = false;
        String userid  = user.getId();
        
        try {
            User existinguser = service.getUserByUserId(userid);
            return null;
        } catch (NoSuchElementException e) {
            return service.addUser(user);

        } 
        
    }

    @GetMapping
    public List<User> getUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) throws Exception{
        return service.getUserByUserId(userId);
    }

    @GetMapping("/accessRights/{accessRights}")
    public List<User> findUserByAccessRights(@PathVariable String accessRights) {
        return service.getUserByAccessRights(accessRights);
    }

    @PutMapping
    public User modifyUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public String deleteVendor(@PathVariable String userId) {
        return service.deleteUser(userId);
    }
}
