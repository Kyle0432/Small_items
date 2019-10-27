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
	 * ͨ��������з�ҳ����
	 */
	@Test
	public void test01() throws IOException{
		//1,��ȡsqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//2,��ȡsqlSession����
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try{
           EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
           Page<Object> page = PageHelper.startPage(1, 3);
           List<Employee> emps = mapper.getEmps();
           //����ͨ��pageInfo��װemps,֮�������и���ϸ�ķ���(����:��һҳ,��һҳ,�ȵ�)
           PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps,2);//(emps,3)��ʾ������ʾ3ҳ
		   for (Employee employee : emps) {
			System.out.println(employee);
		}
/*		   System.out.println("��ǰҳ��:"+page.getPageNum());
		   System.out.println("�ܼ�¼��:"+page.getTotal());
		   System.out.println("ÿҳ�ļ�¼��:"+page.getPageSize());
		   System.out.println("��ҳ��:"+page.getPages()); */
		   
		   //ͨ��pageInfo����ȡ��ϸ��һЩ��ҳ�ķ���
		   System.out.println("��ǰҳ��:"+pageInfo.getPageNum());
		   System.out.println("�ܼ�¼��:"+pageInfo.getTotal());
		   System.out.println("ÿҳ�ļ�¼��:"+pageInfo.getPageSize());
		   System.out.println("��ҳ��:"+pageInfo.getPages());
		   
		   System.out.println("�Ƿ��һҳ:"+pageInfo.isIsFirstPage());
		   System.out.println("�Ƿ�Ϊβҳ:"+pageInfo.isIsLastPage());
		   System.out.println("��һҳ:"+pageInfo.isHasNextPage());
		   System.out.println("��һҳ:"+pageInfo.isHasPreviousPage());
		   
		   System.out.println("-----------------------------------");
		   System.out.println("������ʾ��ҳ��:");
		   
		   int[] nums = pageInfo.getNavigatepageNums();
		   for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		}finally{
			openSession.close();
		}
	}
	
	/*
	 * ͨ�����������������
	 * 
	 */
	public void testBatch() throws IOException{
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		//��ʱ���õ�Sqlsession�Ϳ���ִ������������sqlSession
		SqlSession openSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		long start  = System.currentTimeMillis();
		try {
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 10000; i++) {
			mapper.addEmp(new Employee("A", "B", "1"));
		}
		openSession.commit();
		long end = System.currentTimeMillis();
		//����:Parameter:4508����
		//������:10200����
		System.out.println("ִ��ʱ��:"+(end-start));
		}finally{
		openSession.close();
		}
		
	}
}
