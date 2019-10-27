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
	 * ��������
	 *   һ������:(���ػ���)sqlSession����Ļ���,һ��������һֱ����,�޷��ر�
	 *      �����ݿ�ͬһ�λỰ�ڼ��ѯ�������ݻ�ŵ����ػ�����
	 *      �Ժ������Ҫ��ȡ��ͬ������.ֱ�Ӵӻ�������,û�б�Ҫ��ȥ��ѯ���ݿ�
	 *   
	 *     һ������ʧЧ���:(û��ʹ�õ���ǰһ����������,Ч������,����Ҫ�������ݿⷢ����ѯ)
	 *         ��sqlSessison��ͬ
	 *         ��sqlSession��ͬ,��ѯ������ͬ
	 *         �����sqlSession��ͬ,���β�ѯ֮��ִ������ɾ�Ĳ���(�����ɾ�ľͻ��������Ӱ��)
	 *         ��sqlSession��ͬ,�ֶ������һ������ (�������)
	 *   ��������:(ȫ�ֻ���),����namespace����Ļ���,һ��namespace��Ӧһ����������,
	 *         ��������:
	 *         1,һ���Ự,��ѯһ������,������ݾͻᱻ���ڵ�ǰ�Ự��һ��������
	 *         2,����Ự�ر�;һ�������е����ݻᱻ���浽����������,�µĻỰ��ѯ��Ϣ,�Ϳ��Բ��ն�������
	 *         3,sqlSession === EmployeeMapper ==> Employee
	 *                          DepartmentMapper ===> Department
	 *                       ��ͬnamespace��������ݻ�����Լ���Ӧ�Ļ�����(map)
	 *      ʹ��:
	 *         1,����ȫ�ֶ�����������,<setting name="cacheEnabled" value="true"/>
	 *         2,ȥmapper.xml������ʹ�ö�������,<cache></cache>
	 *         3,���ǵ�pojo��Ҫʵ�����л��ӿ�
	 *
	 *
	 *      �ͻ����йص�����/����
	 *         1,cacheEnabled = true ; false;�رջ���(��������ر�)(һ������һֱ����)
	 *         2,ÿ��select��ǩ����useCache = "true";
	 *                    false:��ʹ�û���(һ��������Ȼʹ��,�������治ʹ��)
	 *         3,��ÿ����ɾ�ı�ǩ��:flushCache = "true": (һ�������������)��
	 *                    ��ɾ��ִ������Ժ�ͻ��������
	 *                    ����:flushCache = "true",һ������������,��������Ҳ�ᱻ���
	 *                    ��(select)��ѯ��ǩ:Ĭ��flushCache = "false",
	 *                         ���flushCache = true;ÿ�β�ѯ֮�󶼻���ջ���,������û�б�ʹ��
	 *         4,sqlSession.clearCache();ֻ�������ǰsession��һ������
	 *         5,localCacheScope:���ػ���������:(һ������SESSION);��ǰ�Ự���������ݱ����ڻỰ�Ļ�����
	 *                            STATEMENT�����Խ���һ������;
	 *   
	 *   ��������������;
	 *        1,������������������
	 *        2,������������������ϵ������,�ٷ���
	 *        3,mapper.xml��ʹ���Զ��建��
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
		    //��һ���Ự����رջỰ
		    openSession1.close();
		   
		    Employee emp02 = mapper2.getEmpById(1);
		    System.out.println(emp02);
		    //�ڶ����Ự����رջỰ
		    openSession2.close();
		    /*
		     * ��ʱ�����������������Ļ��ͻᷢ������sql,�����mapper.xml�����˶��������ֻ����һ��sql
		     * ��Ϊ��һ�ε�openSessionһ���رվͻ�Ѹ����ݷŵ�����������,Ȼ��ڶ���ִ��ʱ�ͻ������ö����������������
		     * ע��:��������ݶ���Ĭ�ϴ����һ��������
		     *    ֻ�лỰ�ύ���߹رպ�,һ�������е����ݲŻ�ת�Ƶ�����������
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
		    //��һ���Ự����رջỰ
		    openSession1.close();
		   
		    Department emp02 = mapper2.getDeptById(1);
		    System.out.println(emp02);
		    //�ڶ����Ự����رջỰ
		    openSession2.close();
		    /*
		     * ��ʱ�����������������Ļ��ͻᷢ������sql,�����mapper.xml�����˶��������ֻ����һ��sql
		     * ��Ϊ��һ�ε�openSessionһ���رվͻ�Ѹ����ݷŵ�����������,Ȼ��ڶ���ִ��ʱ�ͻ������ö����������������
		     * ע��:��������ݶ���Ĭ�ϴ����һ��������
		     *    ֻ�лỰ�ύ���߹رպ�,һ�������е����ݲŻ�ת�Ƶ�����������
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
		
		    //1,�ڶ����µ�Sqlsession(sqlSession��ͬ),����һ�������ʧЧ�� �ͻᷢ���µ�sql
//		    SqlSession openSession2 =  sqlSessionFactory.openSession();
//		    EmployeeMapper mapper2 = openSession2.getMapper(EmployeeMapper.class);
//		    Employee emp2 = mapper2.getEmpById(1);
//		    System.out.println(emp2);
//		    openSession2.close();
		    
		    //2,sqlSession��ͬ,��ѯ������ͬ,�ᷢ�µ�sql
//		    Employee emp3 =mapper.getEmpById(3);
//		    System.out.println(emp3);
		    
		    //4,�������,�������仹�ᷢ�����µ�sql,��Ϊ��������û��������
		    openSession.clearCache();
		    
		    
		    //3,���sqlSession��ͬ,���β�ѯ֮��ִ������ɾ�Ĳ���
		    mapper.addEmp(new Employee(null,"jum","jum@qq.com","1"));
		    System.out.println("������ӳɹ�");
		    Employee emp3 =mapper.getEmpById(3);
		    System.out.println(emp3);
		    
		   //XXX �ڶ��β�ѯ��û�з�������sql���,����ֻ����һ��sql
		    //��Ϊ�ڶ��ε����ݺ͵�һ�ε���ͬ,�����ڻ�����������,����ȥ���ݿ�����
//		    Employee emp1 =mapper.getEmpById(1);
//		    System.out.println(emp1);
//		    System.out.println(emp1 == emp03);//���Ϊtrue
		}finally{
          openSession.close();
		}
	}
	
}
