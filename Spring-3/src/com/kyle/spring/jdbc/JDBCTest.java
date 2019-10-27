package com.kyle.spring.jdbc;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate  namedParameterJdbcTemplate ;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		
	}
	/**
	 * ʹ�þ�������ʱ, ����ʹ�� update(String sql, SqlParameterSource paramSource) �������и��²���
	 * 1. SQL ����еĲ��������������һ��!
	 * 2. ʹ�� SqlParameterSource �� BeanPropertySqlParameterSource ʵ������Ϊ����. 
	 */
	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql = "SELECT INTO employee(last_name,email,dept_id) VALUES(:lastName,:email,:deptId)";
		Employee employee = new Employee();
		employee.setLastName("XYZ");
		employee.setEmail("xyz@kyle.com");
		employee.setDeptId(11);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
		namedParameterJdbcTemplate.update(sql,paramSource);
	}
	
	/**
	 * ����Ϊ����������. 
	 * 1. �ô�: ���ж������, ������ȥ��Ӧλ��, ֱ�Ӷ�Ӧ������, ����ά��
	 * 2. ȱ��: ��Ϊ�鷳. 
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "INSERT INTO employee(last_name,email,dept_id) VALUES (:ln,:email,:deptid)";
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("ln", "FF");
		paramMap.put("email", "ff@Kyle.com");
		paramMap.put("deptid", 11);
		namedParameterJdbcTemplate.update(sql,paramMap);
	}
	/*
	 * ��ȡ�����е�ֵ, ����ͳ�Ʋ�ѯ
	 * ʹ�� queryForObject(String sql, Class<Long> requiredType) 
	 */
	@Test
	public void testQueryObject2(){
		String sql = "SELECT count(id) FROM employee";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	/*
	 * ����ʵ����ļ���
	 * ע����õĲ���queryForList����
	 */
	@Test
	public void testQueryForList(){
		String sql = "SELECT id last_name lastName,email FROM employee WHERE id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper,1);
		System.out.println(employees);
	}
	
	/**
	 * �����ݿ��л�ȡһ����¼, ʵ�ʵõ���Ӧ��һ������
	 * ע�ⲻ�ǵ��� queryForObject(String sql, Class<Employee> requiredType, Object... args) ����!
	 * ����Ҫ���� queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
	 * 1. ���е� RowMapper ָ�����ȥӳ����������, ���õ�ʵ����Ϊ BeanPropertyRowMapper
	 * 2. ʹ�� SQL ���еı�����������������������ӳ��. ���� last_name lastName
	 * 3. ��֧�ּ�������. JdbcTemplate ������һ�� JDBC ��С����, ������ ORM ���
	 */
	@Test
	public void testQueryForObject(){
		String sql = "SELECT id last_name lastName,email,dept_id as\"department.id\"FROM employee WHERE id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,1);
		System.out.println(employee);
	}
	
	/*
	 * ִ����������:������ INSERT UPDATE DELEDE
	 * ���һ�������� Object[]��List����:��Ϊ�޸�һ����¼��Ҫһ��Object������,��ô��������Ҫ���Object��������
	 * 
	 */
	@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO employee(last_name,email,dept_id) VALUES(?,?,?)";
		//�������鼯�����͵�ԭ����һ����¼��������ֶ�������������,��������������¼,����ͻ���뼯����ȥ
		List<Object[]> batchArgs = new ArrayList<Object[]>(); 
		
		batchArgs.add(new Object[]{"AA","aa@kyle.com",1});
		batchArgs.add(new Object[]{"BB","bb@kyle.com",2});
		batchArgs.add(new Object[]{"CC","cc@kyle.com",3});
		
		jdbcTemplate.batchUpdate(sql,batchArgs);
	}
	
	/*
	 * ִ��INSERT UPDATE DELEDT
	 */
	@Test
	public void testUpdate(){
		String sql = "UPDATE employee SET last_name = ? WHERE id = ?";
		jdbcTemplate.update(sql,"jack",2);
		
	}
	
	@Test
	public void testDataSource() throws SQLException{
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
		
	}
	
}
