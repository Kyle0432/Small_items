package com.kyle.spring.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kyle.spring.autowire.Address;
import com.kyle.spring.autowire.Person;
import com.kyle.spring.beans.collection.DataSource;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
		
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        
        System.out.println(dataSource.getConnection);
	}
}
