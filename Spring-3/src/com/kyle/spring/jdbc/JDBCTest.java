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
	 * 使用具名参数时, 可以使用 update(String sql, SqlParameterSource paramSource) 方法进行更新操作
	 * 1. SQL 语句中的参数名和类的属性一致!
	 * 2. 使用 SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为参数. 
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
	 * 可以为参数起名字. 
	 * 1. 好处: 若有多个参数, 则不用再去对应位置, 直接对应参数名, 便于维护
	 * 2. 缺点: 较为麻烦. 
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
	 * 获取单个列的值, 或做统计查询
	 * 使用 queryForObject(String sql, Class<Long> requiredType) 
	 */
	@Test
	public void testQueryObject2(){
		String sql = "SELECT count(id) FROM employee";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	/*
	 * 查找实体类的集合
	 * 注意调用的不是queryForList方法
	 */
	@Test
	public void testQueryForList(){
		String sql = "SELECT id last_name lastName,email FROM employee WHERE id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper,1);
		System.out.println(employees);
	}
	
	/**
	 * 从数据库中获取一条记录, 实际得到对应的一个对象
	 * 注意不是调用 queryForObject(String sql, Class<Employee> requiredType, Object... args) 方法!
	 * 而需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
	 * 1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
	 * 2. 使用 SQL 中列的别名完成列名和类的属性名的映射. 例如 last_name lastName
	 * 3. 不支持级联属性. JdbcTemplate 到底是一个 JDBC 的小工具, 而不是 ORM 框架
	 */
	@Test
	public void testQueryForObject(){
		String sql = "SELECT id last_name lastName,email,dept_id as\"department.id\"FROM employee WHERE id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,1);
		System.out.println(employee);
	}
	
	/*
	 * 执行批量更新:批量的 INSERT UPDATE DELEDE
	 * 最后一个参数是 Object[]的List类型:因为修改一条记录需要一个Object的数组,那么多条就需要多个Object的数组了
	 * 
	 */
	@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO employee(last_name,email,dept_id) VALUES(?,?,?)";
		//返回数组集合类型的原因是一条记录会插入多个字段这里会放入数组,再最后会插入多条记录,这里就会放入集合中去
		List<Object[]> batchArgs = new ArrayList<Object[]>(); 
		
		batchArgs.add(new Object[]{"AA","aa@kyle.com",1});
		batchArgs.add(new Object[]{"BB","bb@kyle.com",2});
		batchArgs.add(new Object[]{"CC","cc@kyle.com",3});
		
		jdbcTemplate.batchUpdate(sql,batchArgs);
	}
	
	/*
	 * 执行INSERT UPDATE DELEDT
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
