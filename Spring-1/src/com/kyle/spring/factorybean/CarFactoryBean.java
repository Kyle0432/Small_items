package com.kyle.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;
 //�Զ����FactoryBean��Ҫʵ��FactoryBean�ӿ�
public class CarFactoryBean implements FactoryBean<Car>{
    private String brand;
    
    public void setBrand(String brand) {
		this.brand = brand;
	}
	//����bean�Ķ���
	@Override
	public Car getObject() throws Exception {
		return new Car(brand,30000);
	}
    //����bean������
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
