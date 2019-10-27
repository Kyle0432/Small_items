package com.kyle.spring.factory;

import java.util.HashMap;
import java.util.Map;

/*
 * ��̬��������,ֱ�ӵ���ĳһ����ľ�̬�����Ϳ��Է���Bean��ʵ��
 */
public class StaticFactory {

	private static Map<String,Car> cars = new HashMap<String, Car>();
			
	//�ھ�̬��������ʼ��cars
	static{
		cars.put("audi", new Car("audi",300000));
		cars.put("ford", new Car("ford",500000));
	}
	
	public static Car getCar(String name){
		return cars.get(name);
	}
	
	
}
