package com.kyle.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.mybatis.dao.EmployeeMapper;
import com.kyle.mybatis.helloworld.Employee;

@Service
public class EmployeeService {
    
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> getEmps(){
		return employeeMapper.getEmps();
	}
}
