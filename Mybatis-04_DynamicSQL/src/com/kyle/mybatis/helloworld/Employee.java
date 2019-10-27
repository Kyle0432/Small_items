package com.kyle.mybatis.helloworld;

import org.apache.ibatis.type.Alias;

//此注解表示指定别名,防止批量起别名时,有两个相同的类然后默认别名也是一样
//然后指定的别名在映射文件中要对应
@Alias("emp")
public class Employee {

	private Integer id;
	//这里的lastName和数据表字段last_name不对应
	//而在javabean就不好去改了,可以在映射文件中SQL语句取个别名
	private String lastName;
	private String email;
	private String gender;
	private Department dept;
	
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String lastName, String email, String gender) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender + "]";
	}
	public Employee(Integer id, String lastName, String email, String gender,
			Department dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dept = dept;
	}
	
}
