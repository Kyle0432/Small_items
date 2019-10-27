package com.kyle.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kyle.spring.annotation.controller.UserController;
import com.kyle.spring.annotation.repository.UserRepository;
import com.kyle.spring.annotation.service.UserService;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
		
		/*testObject to = (testObject) ctx.getBean("testObject");
		System.out.println(to);*/
		
		UserController userController = (UserController) ctx.getBean("userController");
		System.out.println(userController);
		userController.execute();
		
		/*UserService userService = (UserService) ctx.getBean("userService");
		System.out.println(userService);*/
		
		/*UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
		System.out.println(userRepository);*/
	}
	
}
