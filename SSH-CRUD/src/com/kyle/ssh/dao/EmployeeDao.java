package com.kyle.ssh.dao;

import java.util.List;

import org.hibernate.Query;

import com.kyle.ssh.entities.Employee;


public class EmployeeDao extends BaseDao{
    
	//删除  通过id进行删除对象
	public void delete(Integer id){
		String hql = "DELETE FROM Employee e WHERE e.id = ?"; 
		getSession().createQuery(hql).setInteger(0, id).uniqueResult();
	}
	
	//查询Employee类型的集合
	//注意:LEFT OUTER JOIN FETCH e.department
	//表示:通过Employee来连接department,就可以来引用department了
	public List<Employee> getAll(){
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}
	
	//保存所传来的employee对象,可用在当需要添加时,或者在修改时.
	public void saveOrUpdate(Employee employee){
		getSession().saveOrUpdate(employee);
	}
	
	//通过lastName获取Employee对象
	public Employee getEmployeeByLastName(String lastName){
		String hql = "FROM Employee e WHERE e.lastName = ?";
		Query query = getSession().createQuery(hql).setString(0, lastName);
		//查对象也是用uniqueResult()方法
		Employee employee = (Employee) query.uniqueResult();
		System.out.println(employee.getDepartment().getClass().getName());
		return employee;
	}
	
	//通过id获取Employee对象
	public Employee get(Integer id){
		//String hql = "FROM Employee e WHERE e.id = ?";
		//return (Employee) getSession().createQuery(hql).setInteger(0, id).uniqueResult();
		
		return (Employee) getSession().get(Employee.class,id);
	}
}
