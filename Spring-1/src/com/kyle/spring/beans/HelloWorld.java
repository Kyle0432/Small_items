package com.kyle.spring.beans;

public class HelloWorld {

	private String name;
	//显示的无参构造器  以防有参构造器覆盖
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
