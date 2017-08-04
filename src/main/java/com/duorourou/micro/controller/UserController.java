package com.duorourou.micro.controller;

import com.duorourou.micro.domain.User;
import com.duorourou.micro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/users", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable(name = "userId") String userId) {
        return userService.getUser(userId);
    }
}

