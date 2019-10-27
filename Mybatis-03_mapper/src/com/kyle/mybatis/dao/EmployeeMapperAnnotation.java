package com.kyle.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.kyle.mybatis.helloworld.Employee;

public interface EmployeeMapperAnnotation {
	//��ʱ�Ͳ�����ȥдһ��xml�����ļ���
    @Select("select * from employee where id = #{id}")
	public Employee getEmpById(Integer id);
}
