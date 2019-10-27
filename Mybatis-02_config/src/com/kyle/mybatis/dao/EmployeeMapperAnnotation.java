package com.kyle.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.kyle.mybatis.helloworld.Employee;

public interface EmployeeMapperAnnotation {
	//此时就不用再去写一个xml配置文件了
    @Select("select * from employee where id = #{id}")
	public Employee getEmpById(Integer id);
}
