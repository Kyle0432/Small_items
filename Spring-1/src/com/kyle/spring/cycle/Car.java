package com.kyle.spring.cycle;

public class Car {

	public Car(){
		System.out.println("Car's Constructor...");
	}
	private String brand;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	private void init2() {
        System.out.println("init....");
	}
	
	private void destory() {
        System.out.println("destory....");
	}
}
