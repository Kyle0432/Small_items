package com.kyle.mybatis.mybatis.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.kyle.mybatis.bean.Employee;
import com.kyle.mybatis.bean.EmployeeExample;
import com.kyle.mybatis.bean.EmployeeExample.Criteria;
import com.kyle.mybatis.dao.EmployeeMapper;

public class MybatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/*
	 * 运行mybatis的逆向工程  代码生成器操作
	 */
	@Test
	public void testMbg() throws Exception{
		   List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;  //此处一定要用绝对路径M否则找不到文件
		   File configFile = new File("D:/WorkSpace/Mybatis-07_MBG/mbg.xml");
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
	}
	
	/*
	 * 简单版的代码生成器
	 */
	@Test
	public void testMybatis3Simple() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		List<Employee> list = mapper.selectByExample(null);	
		for(Employee employees:list){
			System.out.println(employees);
		}
		}finally{
			openSession.close();
		}
	}
	
	/*
	 * 复杂版的代码生成器
	 */
	@Test
	public void testMybatis3() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
	    //xxxExample就是封装查询条件的
		//1,查询所有
		//List<Employee> emps = mapper.selectByExample(null);
		//2,查询员工名字中有k字母的,和员工性别是1的
		//所有的带条件查询都是调用selectByExample方法
		//封装员工查询条件的example
		EmployeeExample example = new EmployeeExample();
		//创建一个Criteria,这个Criteria就是拼装查询条件
		Criteria criteria = example.createCriteria();
		//此处的都是and的条件  
		criteria.andLastNameLike("%c%");
		criteria.andGenderEqualTo("1");
		
		//如果条件需要 or的 那么需要重新创建一个Criteria
		Criteria criteria2 =  example.createCriteria();
		criteria2.andEmailLike("k");
		//然后把新创建的放进example封装条件就ok了
		example.or(criteria2);
		
		List<Employee> emps2 = mapper.selectByExample(example);
		
		for (Employee employee : emps2) {
			System.out.println(employee.getLastName());
		}
		
		}finally{
			openSession.close();
		}
	}
}
