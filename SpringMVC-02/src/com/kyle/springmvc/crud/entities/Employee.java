package com.kyle.springmvc.crud.entities;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Employee {

	private Integer id;
	//�ñ�ǩ��ͨ��JSR 303�Ϸ��Լ���ı�׼���,����Ҫ������Ӧ��jar��
	//Ȼ��JSR 303 ͨ���� Bean �����ϱ�ע������ @NotNull��@Max 
	//�ȱ�׼��ע��ָ��У����򣬲�ͨ����׼����֤�ӿڶ� Bean������֤
	//��Ȼ�� Spring MVC �У���ֱ��ͨ����ע���������ķ�ʽ��������У��
	//LocalValidatorFactoryBean�����ɽ���ע�뵽��Ҫ����У
	//��� Bean �С�<mvc:annotation-driven/> ��Ĭ��װ���һ��
	//LocalValidatorFactoryBean��ͨ���ڴ�����������ϱ�
	//ע @valid ע�⼴���� Spring MVC ��������ݰ󶨺�ִ������У��Ĺ���
	@NotNull  //��ע���ʾԪ�ر��벻Ϊ��
	private String lastName;
	@Email   //��ע���ʾԪ��Ҫ��һ��email�����ַ
	private String email;
	//1 male , 0 female
	private Integer gender;
	
	private Department department;
	//��ע���ʾУ�������ֻ���ǹ�ȥ�����ǽ�����
	@Past
	//��ע��֧�ֶ�����,�������͵����Խ���ע��.
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	//��ע��֧�ֶ��������͵����Խ���ע��,
	//Ȼ��patten��������ָ������/��ʽ���ֶ����ݵ�ģʽ
	//���Ҫ�����û�Ҫע����springmvc.xml�ļ�����
	//����<mvc:annotation-driven/>��ע��������,��������Ч��
	@NumberFormat(pattern="#,###,###,#")
	private Float salary;

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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender + ", department=" + department
				+ ", birth=" + birth + ", salary=" + salary + "]";
	}

	public Employee(Integer id, String lastName, String email, Integer gender,
			Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Employee() {
		super();
	}
	
	
}
