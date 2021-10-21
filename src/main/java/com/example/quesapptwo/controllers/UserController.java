package com.example.quesapptwo.controllers;

import com.example.quesapptwo.entities.User;

import org.springframework.web.bind.annotation.*;
import com.example.quesapptwo.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {

        return userService.saveOneUser(newUser);

    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        return userService.getOneByUserId(userId);
    }

    @PutMapping("/{userId}")//guncelleme
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {

        return userService.updateOneUser(userId, newUser);

    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {
        userService.deleteById(userId);
    }


}
