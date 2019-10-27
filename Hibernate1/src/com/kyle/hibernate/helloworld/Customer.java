package com.kyle.hibernate.helloworld;

public class Customer {
  
	private Integer id;
	private String name;
	private Integer age;
	private Integer sex;
	private String city;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	public Customer(Integer id, String name, Integer age, Integer sex,
			String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.city = city;
	}
	
	
	
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age
				+ ", sex=" + sex + ", city=" + city + "]";
	}
	
	
}
