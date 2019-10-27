package com.kyle.mybatis.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kyle.mybatis.dao.EmployeeMapper;
import com.kyle.mybatis.helloworld.Employee;

public class MybatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/*
	 * 通过插件进行分页操作
	 */
	@Test
	public void test01() throws IOException{
		//1,获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//2,获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try{
           EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
           Page<Object> page = PageHelper.startPage(1, 3);
           List<Employee> emps = mapper.getEmps();
           //可以通过pageInfo包装emps,之后里面有更详细的方法(例如:下一页,上一页,等等)
           PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps,2);//(emps,3)表示连续显示3页
		   for (Employee employee : emps) {
			System.out.println(employee);
		}
/*		   System.out.println("当前页码:"+page.getPageNum());
		   System.out.println("总记录数:"+page.getTotal());
		   System.out.println("每页的记录数:"+page.getPageSize());
		   System.out.println("总页码:"+page.getPages()); */
		   
		   //通过pageInfo来获取详细的一些分页的方法
		   System.out.println("当前页码:"+pageInfo.getPageNum());
		   System.out.println("总记录数:"+pageInfo.getTotal());
		   System.out.println("每页的记录数:"+pageInfo.getPageSize());
		   System.out.println("总页码:"+pageInfo.getPages());
		   
		   System.out.println("是否第一页:"+pageInfo.isIsFirstPage());
		   System.out.println("是否为尾页:"+pageInfo.isIsLastPage());
		   System.out.println("下一页:"+pageInfo.isHasNextPage());
		   System.out.println("上一页:"+pageInfo.isHasPreviousPage());
		   
		   System.out.println("-----------------------------------");
		   System.out.println("连续显示的页码:");
		   
		   int[] nums = pageInfo.getNavigatepageNums();
		   for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		}finally{
			openSession.close();
		}
	}
	
	/*
	 * 通过插件进行批量操作
	 * 
	 */
	public void testBatch() throws IOException{
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		//此时的拿到Sqlsession就可以执行批量操作的sqlSession
		SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		long start  = System.currentTimeMillis();
		try {
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 10000; i++) {
			mapper.addEmp(new Employee("A", "B", "1"));
		}
		openSession.commit();
		long end = System.currentTimeMillis();
		//批量:Parameter:4508毫秒
		//非批量:10200毫秒
		System.out.println("执行时间:"+(end-start));
		}finally{
		openSession.close();
		}
		
	}
}
