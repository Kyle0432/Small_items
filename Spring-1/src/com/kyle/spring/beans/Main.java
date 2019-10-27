package com.kyle.spring.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//创建HelloWorld的一个对象
		//HelloWorld helloWorld = new HelloWorld();
		//为name属性赋值
		//helloWorld.setName("Kyle");
		//调用hello方法
		//helloWorld.hello();
/*------------------以下是用的spring-------------------------------------*/		
		
		//1,创建Spring 的IOC容器对象,括号里的写配置bean的xml文件
		//ApplicationContext 代表IOC容器
		//ClassPathXmlApplicationContext是ApplicationContext接口的实现类,该实现类从类路径下来加载的
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2,方法一:从IOC容器中通过id获取Bean实例,括号里是bean配置文件里所标识的id
		//HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		//方法二:通过类型来获取Bean实例,缺点若在IOC容器中配置了两个bean,并且都是HelloWorld类型的那就无法确定返回哪一个
		//所以该方法适合在一个类型的bean中使用M多个相同类型的bean就无法确定了
		//HelloWorld helloWorld =ctx.getBean(HelloWorld.class);
		//调用hello方法
		//helloWorld.hello();
		
		Car car = (Car) ctx.getBean("car"); 
		System.out.println(car);
		
		car = (Car) ctx.getBean("car2");
		System.out.println(car);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
