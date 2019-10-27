package com.kyle.mybatis.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kyle.mybatis.dao.DepartmentMapper;
import com.kyle.mybatis.dao.EmployeeMapper;
import com.kyle.mybatis.dao.EmployeeMapperDynamicSQL;
import com.kyle.mybatis.dao.EmployeeMapperPlus;
import com.kyle.mybatis.helloworld.Department;
import com.kyle.mybatis.helloworld.Employee;

public class MybatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/*
	 * 两级缓存
	 *   一级缓存:(本地缓存)sqlSession级别的缓存,一级缓存是一直开启,无法关闭
	 *      与数据库同一次会话期间查询到的数据会放到本地缓存中
	 *      以后如果需要获取相同的数据.直接从缓存中拿,没有必要再去查询数据库
	 *   
	 *     一级缓存失效情况:(没有使用到当前一级缓存的情况,效果就是,还需要再向数据库发出查询)
	 *         ①sqlSessison不同
	 *         ②sqlSession相同,查询条件不同
	 *         ③如果sqlSession相同,两次查询之间执行了增删改操作(这次增删改就会对数据有影响)
	 *         ④sqlSession相同,手动清除了一级缓存 (缓存清空)
	 *   二级缓存:(全局缓存),基于namespace级别的缓存,一个namespace对应一个二级缓存,
	 *         工作机制:
	 *         1,一个会话,查询一条数据,这个数据就会被放在当前会话的一级缓存中
	 *         2,如果会话关闭;一级缓存中的数据会被保存到二级缓存中,新的会话查询信息,就可以参照二级缓存
	 *         3,sqlSession === EmployeeMapper ==> Employee
	 *                          DepartmentMapper ===> Department
	 *                       不同namespace查出的数据会放在自己对应的缓存中(map)
	 *      使用:
	 *         1,开启全局二级缓存配置,<setting name="cacheEnabled" value="true"/>
	 *         2,去mapper.xml中配置使用二级缓存,<cache></cache>
	 *         3,我们的pojo需要实现序列化接口
	 *
	 *
	 *      和缓存有关的设置/属性
	 *         1,cacheEnabled = true ; false;关闭缓存(二级缓存关闭)(一级缓存一直开着)
	 *         2,每个select标签都有useCache = "true";
	 *                    false:不使用缓存(一级缓存依然使用,二级缓存不使用)
	 *         3,【每个增删改标签的:flushCache = "true": (一级二级都会清除)】
	 *                    增删改执行完成以后就会清除缓存
	 *                    测试:flushCache = "true",一级缓存就清空了,二级缓存也会被清空
	 *                    在(select)查询标签:默认flushCache = "false",
	 *                         如果flushCache = true;每次查询之后都会清空缓存,缓存是没有被使用
	 *         4,sqlSession.clearCache();只是清除当前session的一级缓存
	 *         5,localCacheScope:本地缓存作用域:(一级缓存SESSION);当前会话的所有数据保存在会话的缓存中
	 *                            STATEMENT：可以禁用一级缓存;
	 *   
	 *   第三方缓存整合;
	 *        1,导入第三方缓存包即可
	 *        2,导入与第三方缓存整合的适配包,官方有
	 *        3,mapper.xml中使用自定义缓存
	 *   <cache type="org.mybatis.caches.ehcache.EncacheCache"></cache>
	 */
	
	@Test
	public void testSecondLevelCache() throws IOException{
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		SqlSession openSession1 =  sqlSessionFactory.openSession();
		SqlSession openSession2 =  sqlSessionFactory.openSession();
		try {
			//1,
			EmployeeMapper mapper1 = openSession1.getMapper(EmployeeMapper.class);
			EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
		
		    Employee emp01 = mapper1.getEmpById(1);
		    System.out.println(emp01);
		    //第一个会话用完关闭会话
		    openSession1.close();
		   
		    Employee emp02 = mapper2.getEmpById(1);
		    System.out.println(emp02);
		    //第二个会话用完关闭会话
		    openSession2.close();
		    /*
		     * 此时如果不开启二级缓存的话就会发送两条sql,如果在mapper.xml开启了二级缓存就只发送一条sql
		     * 因为第一次的openSession一旦关闭就会把该数据放到二级缓存中,然后第二次执行时就回来引用二级缓存里面的数据
		     * 注意:查出的数据都会默认存放在一级缓存中
		     *    只有会话提交或者关闭后,一级缓存中的数据才会转移到二级缓存中
		     */
		    
		}finally{

		}
	}
	@Test
	public void testSecondLevelCache2() throws IOException{
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		SqlSession openSession1 =  sqlSessionFactory.openSession();
		SqlSession openSession2 =  sqlSessionFactory.openSession();
		try {
			//1,
			DepartmentMapper mapper1 = openSession1.getMapper(DepartmentMapper.class);
			DepartmentMapper mapper2 = openSession2.getMapper(DepartmentMapper.class);
		
		    Department emp01 = mapper1.getDeptById(1);
		    System.out.println(emp01);
		    //第一个会话用完关闭会话
		    openSession1.close();
		   
		    Department emp02 = mapper2.getDeptById(1);
		    System.out.println(emp02);
		    //第二个会话用完关闭会话
		    openSession2.close();
		    /*
		     * 此时如果不开启二级缓存的话就会发送两条sql,如果在mapper.xml开启了二级缓存就只发送一条sql
		     * 因为第一次的openSession一旦关闭就会把该数据放到二级缓存中,然后第二次执行时就回来引用二级缓存里面的数据
		     * 注意:查出的数据都会默认存放在一级缓存中
		     *    只有会话提交或者关闭后,一级缓存中的数据才会转移到二级缓存中
		     */
		    
		}finally{

		}
	}
	
	
	@Test
	public void testFirstLevelCache() throws IOException{
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		SqlSession openSession =  sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		    Employee emp03 = mapper.getEmpById(1);
		    System.out.println(emp03);
		
		    //1,第二个新的Sqlsession(sqlSession不同),所以一级缓存就失效了 就会发送新的sql
//		    SqlSession openSession2 =  sqlSessionFactory.openSession();
//		    EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
//		    Employee emp2 = mapper2.getEmpById(1);
//		    System.out.println(emp2);
//		    openSession2.close();
		    
		    //2,sqlSession相同,查询条件不同,会发新的sql
//		    Employee emp3 =mapper.getEmpById(3);
//		    System.out.println(emp3);
		    
		    //4,清除缓存,下面的语句还会发发送新的sql,因为缓存里面没有数据了
		    openSession.clearCache();
		    
		    
		    //3,如果sqlSession相同,两次查询之间执行了增删改操作
		    mapper.addEmp(new Employee(null,"jum","jum@qq.com","1"));
		    System.out.println("数据添加成功");
		    Employee emp3 =mapper.getEmpById(3);
		    System.out.println(emp3);
		    
		   //XXX 第二次查询并没有发送另外sql语句,而且只发送一条sql
		    //因为第二次的数据和第一次的相同,所以在缓存中拿数据,而不去数据库拿了
//		    Employee emp1 =mapper.getEmpById(1);
//		    System.out.println(emp1);
//		    System.out.println(emp1 == emp03);//结果为true
		}finally{
          openSession.close();
		}
	}
	
}
