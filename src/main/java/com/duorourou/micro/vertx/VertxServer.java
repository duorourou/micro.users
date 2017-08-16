package com.duorourou.micro.vertx;

import com.duorourou.micro.controller.UserController;
import com.duorourou.micro.controller.UserRoleController;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VertxServer extends AbstractVerticle {

    @Value("${server.port:8080}")
    int port = 8080;

    @Autowired
    private UserController userController;
    @Autowired
    private UserRoleController userRoleController;

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);

        router.route("/users/:id").handler(userController::getUser);
        router.route("/user-roles/my").handler(userRoleController::listRoles);

        vertx.createHttpServer().requestHandler(router::accept).listen(port);
    }
}
