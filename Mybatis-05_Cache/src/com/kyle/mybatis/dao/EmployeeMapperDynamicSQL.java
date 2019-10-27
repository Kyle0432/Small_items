package com.kyle.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kyle.mybatis.helloworld.Employee;

public interface EmployeeMapperDynamicSQL {

	//Я�����ĸ��ֶβ�ѯ�����ʹ�������ֶε�ֵ  
	public List<Employee> getEmpsByConditionIf(Employee employee);

	public List<Employee> getEmpsByConditionTrim(Employee employee);
	
	public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void updateEmp(Employee employee);

    //��ѯԱ��id�ڸ���������,���ﴫ�ݵ��Ƕ�����������ддע��ָ������
    //�����ִ��쳣��
	//org.apache.ibatis.binding.BindingException: 
	//Parameter 'id' not found.
    public List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);

    public void addEmps(@Param("emps") List<Employee> emps);

    public List<Employee> getEmpsTestInnerParameter(Employee employee);
}
