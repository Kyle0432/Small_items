package com.kyle.mybatis.dao;


import java.util.List;

import com.kyle.mybatis.helloworld.Employee;

public interface EmployeeMapper {
	
	public List<Employee> getEmps();
}
