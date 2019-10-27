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
	 * 1���ӿ�ʽ���
	 * 	ԭ����		Dao		====>  DaoImpl
	 * 	mybatis��	Mapper	====>  xxMapper.xml
	 * 
	 * 2��SqlSession��������ݿ��һ�λỰ���������رգ�
	 * 3��SqlSession��connectionһ�������Ƿ��̰߳�ȫ��ÿ��ʹ�ö�Ӧ��ȥ��ȡ�µĶ���
	 * 4��mapper�ӿ�û��ʵ���࣬����mybatis��Ϊ����ӿ�����һ���������
	 * 		�����ӿں�xml���а󶨣�
	 * 		EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
	 * 5��������Ҫ�������ļ���
	 * 		mybatis��ȫ�������ļ����������ݿ����ӳ���Ϣ�������������Ϣ��...ϵͳ���л�����Ϣ
	 * 		sqlӳ���ļ���������ÿһ��sql����ӳ����Ϣ��
	 * 					��sql��ȡ������	
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
	 * 1,����xml�����ļ�(ȫ�������ļ�)����һ��SqlSessionFactory����
	 *  ������ԴһЩ���л�������Ϣ
	 * 2,sqlӳ���ļ�,������ÿһ��sql,�Լ�sql�ķ�װ�����.
	 * 3,��sqlӳ���ļ�ע����ȫ�������ļ���
	 * 4,д����:
	 *     �ٸ���ȫ�������ļ��õ�SqlSessionFactory:
	 *     ��ʹ��sqlSessionFactory��ȡ��SqlSession����ʹ��������ɾ�Ĳ�
	 *     ������sqlSession����ʹ�������ݿ�һ�λỰ,����͹ر���Դ
	 *     ��ʹ��sql��Ψһ��ʶ������Mybatisִ���ĸ�sql,sql���Ǳ�����sqlӳ���ļ��е�
	 */ 
	
	@Test
	public void test() throws IOException {
	
	  //2,��ȡsqlSessionʵ��,��ֱ��ִ���Ѿ�ӳ���sql���
	  //��һ������:sql��Ψһ��ʶΪ�˲�������ͻ����ȫ����+id(Ϊ�����ļ��е�id)
	  //�ڶ�����:Ϊ�����Ĳ���ֵ
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
      	SqlSession openSession = sqlSessionFactory.openSession();
		try {
      		//��ʱ�����൱��ͨ�����Ĳ���ֵȥ��ѯ,Ȼ����Employee������
      		Employee employee = openSession.selectOne("com.kyle.mybatis.helloworld.Employee.selectEmp",1);
      		System.out.println(employee);
		}finally{
			//�ر���Դ
			openSession.close();
		}
	
	}
	/*
	 * �Ƽ�ʹ�ýӿ�ʽ���
	 */
	@Test
	public void test01() throws IOException{
		//1,��ȡsqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//2,��ȡsqlSession����
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try{
		//3,��ȡ�ӿڵ�ʵ�������
		//ֻҪ�ѽӿں�mybatis��ӳ���ļ���
		//Mybatis�ͻ�Ϊ�ӿ��Զ��Ĵ���һ���������(mapper)
		//Ȼ��������ִ����ɾ�Ĳ�
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		//mapper�ܵ���getEmpById������ʾ�ӿ��Ѿ���ʵ����
		Employee employee = mapper.getEmpById(1);
		//����ʾMybatis�ͻ�Ϊ�ӿ��Զ��Ĵ���һ���������(mapper)
		System.out.println(mapper.getClass());
		System.out.println(employee);
		}finally{
			openSession.close();
		}
	}

}
