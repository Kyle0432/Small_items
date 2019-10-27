package com.kyle.spring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kyle.spring.annotation.service.UserService;

@Controller
public class UserController {
	@Autowired
    private UserService userService;
	
	public void execute(){
		System.out.println("UserController ...");
		userService.add();
	}
}
