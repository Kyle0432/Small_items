package com.kyle.mybatis.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.MapKey;

import org.apache.ibatis.annotations.Param;

import com.kyle.mybatis.helloworld.Employee;

public interface EmployeeMapper {
	
	//多条记录封装一个map:Map<integer,Employee>:键是这条记录的主键,
	//因为每条记录都会有主键,所以可以做到多个主键对应value
	//值是记录封装后的javabean
	
	//该注解告诉mybatis封装这个map的时候使用哪个属性作为主键
	@org.apache.ibatis.annotations.MapKey("id")
	public Map<Integer,Employee> getEmpByLastNameLikeReturnMap(String lastName);
	
	//返回一条记录的map:key就是别名,值就是对应的值
	public Map<String,Object> getEmpByIdReturnMap(Integer id);
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String,Object> map);
	
    //在传入多个参数时加上param注解之后就可以直接写指定的参数在#{}里面了,无需要些param1和oarma2或者 0、1
	public Employee getEmployeeByIdAndLastName(@Param("id")Integer id, @Param("lastName")String lastName);
	
	public Employee getEmpById(Integer id);

	public void addEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public void deleteById(Integer id);
}
