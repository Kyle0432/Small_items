package com.kyle.spring.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {

	/*
	 * ʵ����������:ʵ�������ķ���,������Ҫ�������������ٵ��ù�����ʵ������������bean��ʵ��
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
