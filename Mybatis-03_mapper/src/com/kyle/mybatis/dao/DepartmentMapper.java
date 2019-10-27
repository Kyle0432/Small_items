package com.kyle.mybatis.dao;

import com.kyle.mybatis.helloworld.Department;

public interface DepartmentMapper {

	public Department getDeptById(Integer id);
	
	public Department getDeptByIdPlus(Integer id);
	
	public Department getDeptByIdStep(Integer id);
}
