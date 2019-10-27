package com.kyle.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyle.springmvc.crud.entities.Department;
import com.kyle.springmvc.crud.entities.Employee;

@Repository
public class EmployeeDao {

	private static Map<Integer,Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	//static块表示在类加载时只执行一次,优化程序性能
	//因为下面方法会多次用到employees对象,所以每次使用都会初始化一次
	static{
		employees = new HashMap<Integer, Employee>();
		
		employees.put(1001, new Employee(1001,"E-AA","aa@163.com",1,new Department(101,"DD-AA")));
		employees.put(1002, new Employee(1002,"E-BB","bb@163.com",1,new Department(102,"DD-BB")));
		employees.put(1003, new Employee(1003,"E-CC","cc@163.com",0,new Department(103,"DD-CC")));
		employees.put(1004, new Employee(1004,"E-DD","dd@163.com",0,new Department(104,"DD-DD")));
		employees.put(1005, new Employee(1005,"E-EE","ee@163.com",1,new Department(105,"DD-EE")));
	}
	
	private static Integer initId = 1006;
			
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
