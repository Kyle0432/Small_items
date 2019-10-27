package com.kyle.spring.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kyle.spring.autowire.Address;
import com.kyle.spring.autowire.Person;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-autowire.xml");
		
		Address addrees = (Address) ctx.getBean("address");
		System.out.println(addrees);
		
		Address addrees2 = (Address) ctx.getBean("address2");
		System.out.println(addrees2);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
