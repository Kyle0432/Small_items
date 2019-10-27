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
	 * 查询所有员工
	 */
	public List<Employee> getAll() { //此处表示查询所有不带条件
		return employeeMapper.selectByExampleWithDept(null);
	}
	/*
	 * 员工保存方法
	 */
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}
	/*
	 * 检验用户名是否可用
	 */
	public boolean checkUser(String empName) {
		EmployeeExample employeeExample = new EmployeeExample();
		//创建查询条件
		Criteria criteria = employeeExample.createCriteria();
		//如果有相同的那么下面的count就是大于0否则就是等于0
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(employeeExample);
		//如果等于0就为true,就表示当前数据库没有这条记录的用户名,就表示可用
		//否则大于0就为false,就相当于数据库里面存在该用户名,则不可用
		return count == 0;
	}
		/*
		 * 通过员工的id查询员工
		 */
		public Employee getEmp(Integer id) {
			Employee employee = employeeMapper.selectByPrimaryKey(id);
			return employee;
		}
		/*
		 * 更新修改员工信息
		 */
		public void updateEmp(Employee employee) {
			employeeMapper.updateByPrimaryKeySelective(employee);
		}
		/*
		 * 删除员工信息
		 */
		public void deleteEmp(Integer id) {
			employeeMapper.deleteByPrimaryKey(id);
		}
		/*
		 * 进行批量删除
		 */
		public void deleteBatch(List<Integer> del_ids) {
          EmployeeExample example = new EmployeeExample();
		  Criteria criteria = example.createCriteria();
		 //criteria.andEmpIdIn(del_ids)表示在del_ids集合里面
		  criteria.andEmpIdIn(del_ids);
		  employeeMapper.deleteByExample(example);
		}
	


}
