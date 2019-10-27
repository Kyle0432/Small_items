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
	 * ����mybatis�����򹤳�  ��������������
	 */
	@Test
	public void testMbg() throws Exception{
		   List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;  //�˴�һ��Ҫ�þ���·��M�����Ҳ����ļ�
		   File configFile = new File("D:/WorkSpace/Mybatis-07_MBG/mbg.xml");
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
	}
	
	/*
	 * �򵥰�Ĵ���������
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
	 * ���Ӱ�Ĵ���������
	 */
	@Test
	public void testMybatis3() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
	    //xxxExample���Ƿ�װ��ѯ������
		//1,��ѯ����
		//List<Employee> emps = mapper.selectByExample(null);
		//2,��ѯԱ����������k��ĸ��,��Ա���Ա���1��
		//���еĴ�������ѯ���ǵ���selectByExample����
		//��װԱ����ѯ������example
		EmployeeExample example = new EmployeeExample();
		//����һ��Criteria,���Criteria����ƴװ��ѯ����
		Criteria criteria = example.createCriteria();
		//�˴��Ķ���and������  
		criteria.andLastNameLike("%c%");
		criteria.andGenderEqualTo("1");
		
		//���������Ҫ or�� ��ô��Ҫ���´���һ��Criteria
		Criteria criteria2 =  example.createCriteria();
		criteria2.andEmailLike("k");
		//Ȼ����´����ķŽ�example��װ������ok��
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
