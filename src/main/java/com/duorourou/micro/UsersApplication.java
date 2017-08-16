package com.duorourou.micro;

import com.duorourou.micro.vertx.VertxServer;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@Slf4j
public class UsersApplication {

    @Autowired
    private VertxServer vertxServer;

    @PostConstruct
    public void deployVerticle() {
        Vertx.vertx().deployVerticle(vertxServer);
    }

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }
}
