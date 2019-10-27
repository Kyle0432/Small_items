package com.kyle.crud.test;


import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kyle.crud.bean.Employee;
import com.kyle.crud.dao.DepartmentMapper;
import com.kyle.crud.dao.EmployeeMapper;


/**
 * 测试dao层的工作
 * @author Think
 * 推荐spring的项目就可以使用spring单元测试,可以自动注入我们所需要的组件
 * 步骤:
 * ①导入SpringTest模块
 * ②@ContextConfiguration指定spring配置文件的位置
 * ③@RunWith表示启动哪个的单元测试  这里是spring提供的 所有要使用spring的单元测试
 * ④直接autowire要使用的的组件即可	
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	/*
	 * 测试departmentMapper
	 */
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	//这个session是一个批量的sqlsession
	@Autowired  
	SqlSession sqlSession;
	
    @Test
	public void testCRUD(){
    	//测试是否已经注入了
		System.out.println(departmentMapper);
		
		//1,插入几个部门
//		departmentMapper.insertSelective(new Department(null,"开发部"));
//		departmentMapper.insertSelective(new Department(null,"测试部"));
		//2,生成员工数据,测试员工插入
//		employeeMapper.insertSelective(new Employee(null,"jreey","M","jreey@qq.com",1));
		//3,批量插入多个员工
		EmployeeMapper  mapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 10000; i++) {
			//随机自动生成id
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@qq.com", 2));
		}
//		System.out.println("批量完成!");
		
		//4,修改操作
//	    employeeMapper.updateByPrimaryKeySelective(new Employee(1,"Tom","F","Tom@163.com",2));
	   
		//5,批量删除操作
//		 EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		 for (int i = 0; i <50; i++) {
//			mapper.deleteByPrimaryKey(i);
//		}
    }
}
