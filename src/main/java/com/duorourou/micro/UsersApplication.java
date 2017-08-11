package com.duorourou.micro;

import com.duorourou.micro.vertx.StaticService;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
public class UsersApplication {

	@Autowired
	private StaticService staticService;

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@PostConstruct
	public void deployVerticle() {
		Vertx.vertx().deployVerticle(staticService);
	}
}
