package com.kyle.spring.beans;

public class HelloWorld {

	private String name;
	//��ʾ���޲ι�����  �Է��вι���������
/*	public HelloWorld(){
		System.out.println("HelloWorld's Constructor...");
	}*/
	
	public void setName2(String name) {
		this.name = name;
	}
	
	public void hello(){
		System.out.println("hello"+name);
	}
	
/*	public HelloWorld(String user){
		System.out.println("Hello:"+user);
	}*/
}
