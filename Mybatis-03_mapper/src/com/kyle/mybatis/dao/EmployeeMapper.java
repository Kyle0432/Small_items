package com.kyle.mybatis.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.MapKey;

import org.apache.ibatis.annotations.Param;

import com.kyle.mybatis.helloworld.Employee;

public interface EmployeeMapper {
	
	//������¼��װһ��map:Map<integer,Employee>:����������¼������,
	//��Ϊÿ����¼����������,���Կ����������������Ӧvalue
	//ֵ�Ǽ�¼��װ���javabean
	
	//��ע�����mybatis��װ���map��ʱ��ʹ���ĸ�������Ϊ����
	@org.apache.ibatis.annotations.MapKey("id")
	public Map<Integer,Employee> getEmpByLastNameLikeReturnMap(String lastName);
	
	//����һ����¼��map:key���Ǳ���,ֵ���Ƕ�Ӧ��ֵ
	public Map<String,Object> getEmpByIdReturnMap(Integer id);
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String,Object> map);
	
    //�ڴ���������ʱ����paramע��֮��Ϳ���ֱ��дָ���Ĳ�����#{}������,����ҪЩparam1��oarma2���� 0��1
	public Employee getEmployeeByIdAndLastName(@Param("id")Integer id, @Param("lastName")String lastName);
	
	public Employee getEmpById(Integer id);

	public void addEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public void deleteById(Integer id);
}
