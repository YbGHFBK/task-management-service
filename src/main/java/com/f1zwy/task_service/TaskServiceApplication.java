package com.f1zwy.task_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootApplication
public class TaskServiceApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TaskServiceApplication.class, args);
		System.out.println("Beans loaded: " + ctx.getBean(AuthenticationManager.class));
	}
}
