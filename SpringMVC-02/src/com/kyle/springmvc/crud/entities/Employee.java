package com.kyle.springmvc.crud.entities;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Employee {

	private Integer id;
	//该标签是通过JSR 303合法性检验的标准框架,所以要加入相应的jar包
	//然后JSR 303 通过在 Bean 属性上标注类似于 @NotNull、@Max 
	//等标准的注解指定校验规则，并通过标准的验证接口对 Bean进行验证
	//当然在 Spring MVC 中，可直接通过【注解驱动】的方式进行数据校验
	//LocalValidatorFactoryBean，即可将其注入到需要数据校
	//验的 Bean 中。<mvc:annotation-driven/> 会默认装配好一个
	//LocalValidatorFactoryBean，通过在处理方法的入参上标
	//注 @valid 注解即可让 Spring MVC 在完成数据绑定后执行数据校验的工作
	@NotNull  //此注解表示元素必须不为空
	private String lastName;
	@Email   //该注解表示元素要是一个email邮箱地址
	private String email;
	//1 male , 0 female
	private Integer gender;
	
	private Department department;
	//该注解表示校验该日期只能是过去不能是将来的
	@Past
	//该注解支持对日期,日历类型的属性进行注解.
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	//该注解支持对数字类型的属性进行注解,
	//然后patten属性里面指定解析/格式化字段数据的模式
	//如果要起作用还要注意在springmvc.xml文件里面
	//配置<mvc:annotation-driven/>【注解驱动】,这样才起效果
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
