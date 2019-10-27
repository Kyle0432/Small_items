package com.kyle.springmvc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyle.springmvc.crud.dao.EmployeeDao;
import com.kyle.springmvc.crud.entities.Employee;

@Controller
public class SpringMVCTest {

	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/testConversionServiceConverer")
	public String  testConverter(@RequestParam("employee") Employee employee){
		System.out.println("save"+employee);
		employeeDao.save(employee);
		return  "redirect/emps";
	}
}
