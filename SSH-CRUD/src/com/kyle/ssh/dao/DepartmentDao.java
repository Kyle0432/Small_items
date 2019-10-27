package com.kyle.ssh.dao;

import java.util.List;

import com.kyle.ssh.entities.Department;

public class DepartmentDao extends BaseDao{

	public List<Department> getAll(){
		      //注意这里是HQL查询 FROM后面的是 entites里的类
		      //类对应的数据表,对象对应的是记录,属性对应的是字段
		String hql = "FROM Department";
		return getSession().createQuery(hql).list();
	}
} 
