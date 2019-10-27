package com.kyle.mybatis.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kyle.mybatis.dao.EmployeeMapper;
import com.kyle.mybatis.helloworld.Employee;

public class MybatisTest {

	/**
	 * 1、接口式编程
	 * 	原生：		Dao		====>  DaoImpl
	 * 	mybatis：	Mapper	====>  xxMapper.xml
	 * 
	 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
	 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
	 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
	 * 		（将接口和xml进行绑定）
	 * 		EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
	 * 5、两个重要的配置文件：
	 * 		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息
	 * 		sql映射文件：保存了每一个sql语句的映射信息：
	 * 					将sql抽取出来。	
	 * 
	 * 
	 * @author lfy
	 *
	 */
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	/*
	 * 1,根据xml配置文件(全局配置文件)创建一个SqlSessionFactory对象
	 *  有数据源一些运行环境的信息
	 * 2,sql映射文件,配置了每一个sql,以及sql的封装规则等.
	 * 3,将sql映射文件注册在全局配置文件中
	 * 4,写代码:
	 *     ①根据全局配置文件得到SqlSessionFactory:
	 *     ②使用sqlSessionFactory获取到SqlSession对象使用它来增删改查
	 *     ③用完sqlSession对象就代表和数据库一次会话,用完就关闭资源
	 *     ④使用sql的唯一标识来告诉Mybatis执行哪个sql,sql都是保存在sql映射文件中的
	 */ 
	
	@Test
	public void test() throws IOException {
	
	  //2,获取sqlSession实例,能直接执行已经映射的sql语句
	  //第一个参数:sql的唯一标识为了不发生冲突加上全类名+id(为配置文件中的id)
	  //第二参数:为所传的参数值
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
      	SqlSession openSession = sqlSessionFactory.openSession();
		try {
      		//此时就是相当于通过给的参数值去查询,然后用Employee来接收
      		Employee employee = openSession.selectOne("com.kyle.mybatis.helloworld.Employee.selectEmp",1);
      		System.out.println(employee);
		}finally{
			//关闭资源
			openSession.close();
		}
	
	}
	/*
	 * 推荐使用接口式编程
	 */
	@Test
	public void test01() throws IOException{
		//1,获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//2,获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try{
		//3,获取接口的实现类对象
		//只要把接口和mybatis的映射文件绑定
		//Mybatis就会为接口自动的创建一个代理对象(mapper)
		//然后代理对象执行增删改查
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		//mapper能调用getEmpById方法表示接口已经被实现了
		Employee employee = mapper.getEmpById(1);
		//可显示Mybatis就会为接口自动的创建一个代理对象(mapper)
		System.out.println(mapper.getClass());
		System.out.println(employee);
		}finally{
			openSession.close();
		}
	}

}
