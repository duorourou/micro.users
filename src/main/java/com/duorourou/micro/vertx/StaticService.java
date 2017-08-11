package com.duorourou.micro.vertx;

import com.duorourou.micro.controller.UserRoleController;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StaticService extends AbstractVerticle {

    @Value(value = "${server.port}")
    private int port = 8888;
    @Autowired
    UserRoleController userRoleController;

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);

        router.get("/user-roles")
                .blockingHandler(this::listUserRoles);

        // Serve the static pages
        router.route().handler(StaticHandler.create());

        vertx.createHttpServer().requestHandler(router::accept).listen();
    }

    private List<String> listUserRoles(RoutingContext routingContext) {
        return userRoleController.listRoles();
    }

}
