package com.kyle.ssh.service;

import java.util.List;

import com.kyle.ssh.dao.EmployeeDao;
import com.kyle.ssh.entities.Employee;

public class EmployeeService {

	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
	
	public void delete(Integer id){
		employeeDao.delete(id);
	}
	
	public List<Employee> getAll(){
		List<Employee> employees = employeeDao.getAll();
		//
//		employees.clear();
		return employees;
	}
	
	public Employee get(Integer id){
		return employeeDao.get(id);
	}
	
	
	public boolean lastNamelsValid(String lastName){
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}
}
