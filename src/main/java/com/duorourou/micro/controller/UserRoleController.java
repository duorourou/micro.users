package com.duorourou.micro.controller;

import com.google.gson.Gson;
import io.vertx.ext.web.RoutingContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user-roles")
public class UserRoleController {

    @GetMapping("/my")
    public List<String> listRoles() {
        return Arrays.asList("Manager", "Administrator");
    }

    @GetMapping("/my")
    public void listRoles(RoutingContext routingContext) {
        routingContext.response().setStatusCode(200)
                .end(new Gson().toJson(Arrays.asList("Manager", "Administrator")));
    }
}
