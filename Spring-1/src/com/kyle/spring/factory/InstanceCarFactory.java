package com.kyle.spring.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {

	/*
	 * 实例工厂方法:实例工厂的方法,即先需要创建工厂本身再调用工厂的实例方法来返回bean的实例
	 * 
	 */
	private Map<String,Car> cars = null;
	
	public InstanceCarFactory(){
		 cars = new HashMap<String, Car>();
		 cars.put("audi", new Car("audi",599990));
		 cars.put("ford", new Car("ford",600000));
	}
	
	public Car getCar(String brand){
		return cars.get(brand);
	}
}
