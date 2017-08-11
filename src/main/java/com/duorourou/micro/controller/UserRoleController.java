package com.duorourou.micro.controller;

import com.github.aesteve.vertx.nubes.annotations.Controller;
import com.github.aesteve.vertx.nubes.annotations.mixins.ContentType;
import com.github.aesteve.vertx.nubes.annotations.routing.http.GET;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Component
@Controller("/user-roles")
@ContentType("application/json")
public class UserRoleController {

    @GET("/my")
    @ResponseBody
    public List<String> listRoles() {
        return Arrays.asList("Manager", "Administrator");
    }
}
