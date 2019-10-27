package com.kyle.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorld {

	@Autowired
	private UserService userService;
	
	
	public HelloWorld(){
		System.out.println("HelloWorld Contructor ...");
	}
	
	public String hello(){
		System.out.println("success");
		System.out.println(userService);
		return"success";
	}
}
