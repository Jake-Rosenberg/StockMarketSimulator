package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("users/{id}")
    public User getUserById(@PathVariable int id) {
        return userDao.getUserById(id);
    }

    @GetMapping("users")
    public User[] findAll() {
        List<User> users = userDao.findAll();
        return users.toArray(new User[users.size()]);
    }

}
