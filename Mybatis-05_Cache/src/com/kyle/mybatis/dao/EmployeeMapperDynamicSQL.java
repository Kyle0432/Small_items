package com.kyle.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kyle.mybatis.helloworld.Employee;

public interface EmployeeMapperDynamicSQL {

	//携带了哪个字段查询条件就带上这个字段的值  
	public List<Employee> getEmpsByConditionIf(Employee employee);

	public List<Employee> getEmpsByConditionTrim(Employee employee);
	
	public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void updateEmp(Employee employee);

    //查询员工id在给定集合中,这里传递的是多个参数如果不写写注解指定参数
    //则会出现此异常：
	//org.apache.ibatis.binding.BindingException: 
	//Parameter 'id' not found.
    public List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);

    public void addEmps(@Param("emps") List<Employee> emps);

    public List<Employee> getEmpsTestInnerParameter(Employee employee);
}
