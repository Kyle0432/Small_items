package com.kyle.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.crud.bean.Employee;
import com.kyle.crud.bean.EmployeeExample;
import com.kyle.crud.bean.EmployeeExample.Criteria;
import com.kyle.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	/*
	 * ��ѯ����Ա��
	 */
	public List<Employee> getAll() { //�˴���ʾ��ѯ���в�������
		return employeeMapper.selectByExampleWithDept(null);
	}
	/*
	 * Ա�����淽��
	 */
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}
	/*
	 * �����û����Ƿ����
	 */
	public boolean checkUser(String empName) {
		EmployeeExample employeeExample = new EmployeeExample();
		//������ѯ����
		Criteria criteria = employeeExample.createCriteria();
		//�������ͬ����ô�����count���Ǵ���0������ǵ���0
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(employeeExample);
		//�������0��Ϊtrue,�ͱ�ʾ��ǰ���ݿ�û��������¼���û���,�ͱ�ʾ����
		//�������0��Ϊfalse,���൱�����ݿ�������ڸ��û���,�򲻿���
		return count == 0;
	}
		/*
		 * ͨ��Ա����id��ѯԱ��
		 */
		public Employee getEmp(Integer id) {
			Employee employee = employeeMapper.selectByPrimaryKey(id);
			return employee;
		}
		/*
		 * �����޸�Ա����Ϣ
		 */
		public void updateEmp(Employee employee) {
			employeeMapper.updateByPrimaryKeySelective(employee);
		}
		/*
		 * ɾ��Ա����Ϣ
		 */
		public void deleteEmp(Integer id) {
			employeeMapper.deleteByPrimaryKey(id);
		}
		/*
		 * ��������ɾ��
		 */
		public void deleteBatch(List<Integer> del_ids) {
          EmployeeExample example = new EmployeeExample();
		  Criteria criteria = example.createCriteria();
		 //criteria.andEmpIdIn(del_ids)��ʾ��del_ids��������
		  criteria.andEmpIdIn(del_ids);
		  employeeMapper.deleteByExample(example);
		}
	


}
