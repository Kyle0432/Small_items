package com.kyle.spring.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//����HelloWorld��һ������
		//HelloWorld helloWorld = new HelloWorld();
		//Ϊname���Ը�ֵ
		//helloWorld.setName("Kyle");
		//����hello����
		//helloWorld.hello();
/*------------------�������õ�spring-------------------------------------*/		
		
		//1,����Spring ��IOC��������,�������д����bean��xml�ļ�
		//ApplicationContext ����IOC����
		//ClassPathXmlApplicationContext��ApplicationContext�ӿڵ�ʵ����,��ʵ�������·���������ص�
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2,����һ:��IOC������ͨ��id��ȡBeanʵ��,��������bean�����ļ�������ʶ��id
		//HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		//������:ͨ����������ȡBeanʵ��,ȱ������IOC����������������bean,���Ҷ���HelloWorld���͵��Ǿ��޷�ȷ��������һ��
		//���Ը÷����ʺ���һ�����͵�bean��ʹ��M�����ͬ���͵�bean���޷�ȷ����
		//HelloWorld helloWorld =ctx.getBean(HelloWorld.class);
		//����hello����
		//helloWorld.hello();
		
		Car car = (Car) ctx.getBean("car"); 
		System.out.println(car);
		
		car = (Car) ctx.getBean("car2");
		System.out.println(car);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
