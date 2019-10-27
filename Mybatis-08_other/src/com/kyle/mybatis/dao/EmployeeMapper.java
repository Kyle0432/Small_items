package com.kyle.mybatis.dao;

import java.util.List;

import com.kyle.mybatis.helloworld.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Integer id);

	public List<Employee> getEmps();
	
	public Long addEmp(Employee employee);
}
