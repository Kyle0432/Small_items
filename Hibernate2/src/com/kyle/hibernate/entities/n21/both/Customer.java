package com.kyle.hibernate.entities.n21.both;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	private Integer customerId;
	private String customerName;
	/*
	 * 1,声明集合类型时,需要使用接口类型,因为hibernate在获取
	 * 集合类型时,返回的是Hibernate内置的集合类型,而不是JavaSE一个标准的
	 * 集合实现
	 * 2,需要把集合进行初始化,可以防止发生空指针异常
	 */
	private Set<Order> orders = new HashSet<Order>();
	

	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
