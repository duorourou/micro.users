package com.duorourou.micro.controller;

import com.duorourou.micro.domain.User;
import com.duorourou.micro.service.UserService;
import com.google.gson.Gson;
import io.vertx.ext.web.RoutingContext;
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
        if("abc".equals(userId)) {
            throw new RuntimeException("unknown user id 'abc'.");
        }
        return userService.getUser(userId);
    }

    @ResponseBody
    public void getUser(RoutingContext routingContext) {
        String userId = routingContext.request().getParam("id");
        if("abc".equals(userId)) {
            throw new RuntimeException("unknown user id 'abc'.");
        }
        routingContext.response().setStatusCode(200).end(new Gson().toJson(userService.getUser(userId)));
    }
}
