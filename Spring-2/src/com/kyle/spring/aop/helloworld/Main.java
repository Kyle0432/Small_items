package com.kyle.spring.aop.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	  public static void main(String[] args) {
		
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		  
		  AtithmeticCalculator atithmeticCalculator = (AtithmeticCalculator) ctx.getBean("atithmeticCalculator");
		  
		  int add = atithmeticCalculator.add(3, 6);
		  System.out.println("result"+add);
		  
		  int div = atithmeticCalculator.div(990, 10);
		  System.out.println("result"+div);
		  
		  
	}
	
}
