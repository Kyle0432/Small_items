package com.kyle.mybatis.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kyle.mybatis.dao.DepartmentMapper;
import com.kyle.mybatis.dao.EmployeeMapper;
import com.kyle.mybatis.dao.EmployeeMapperPlus;
import com.kyle.mybatis.helloworld.Department;
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

	/*
	 * ����ע��� ����
	 */
	@Test
	public void test02() throws IOException{
		//1,��ȡsqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//2,��ȡsqlSession����
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try{
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		Employee employee = mapper.getEmpById(1);
		System.out.println(mapper.getClass());
		System.out.println(employee);
		}finally{
			openSession.close();
		}
	}
	
	/*
	 * ������ɾ��
	 * 1,mybatis������ɾ��ֱ�Ӷ����������ͷ���ֵ
	 * 
	 * Integer Long Boolean void
	 * 2,������Ҫ�ֶ��ύ����
	 * sqlSessionFactory.openSession(); ===>�ֶ��ύ
	 * sqlSessionFactory.openSession(true); ===>�Զ��ύ
	 *  
	 */
	@Test
	public void test03() throws IOException{
		
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		//1,��ȡ����SqlSession�����Զ��ύ����
		SqlSession openSession =  sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
			
//			��Ӳ���
	        Employee employee = new Employee(null, "kyle", "kyle@qq.com","1");
			mapper.addEmp(employee);
			System.out.println(employee.getId());
//			���²���
//			Employee employee = new Employee(2, "caven", "caven@qq.com","1");
//			mapper.updateEmp(employee);
			
//			ɾ������
//			mapper.deleteById(2);
			
			//2,�ֶ��ύ���ݲ�����Ч
			openSession.commit();
		}finally{
         openSession.close();
		}
	} 
	
	@Test
	public void test04() throws IOException{
		
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		
		SqlSession openSession =  sqlSessionFactory.openSession(true);
		
		try {
			EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
			
//			�������ѯ:Employee employee = mapper.getEmployeeByIdAndLastName(1, "kyle");
			
//			������ŵ�map�����������ͨ��Ԥ����ռλ����:
//			<String,Object> map = new HashMap<String,Object>();
//			map.put("id", 1);
//			map.put("lastName", "kyle");
//			map.put("tableName", "employee");
//			Employee employee = mapper.getEmpByMap(map);
			
//			ģ����ѯ
//			List<Employee> emps = mapper.getEmpsByLastNameLike("%K%");
//			//ѭ��������ģ����ѯ����������
//			for(Employee employees:emps){
//				System.out.println(employees);
//			}

//			����һ����¼��map:key���Ǳ���,ֵ���Ƕ�Ӧ��ֵ
//			Map<String,Object> map = mapper.getEmpByIdReturnMap(1);
//			System.out.println(map);
			
			Map<Integer,Employee> maps =  mapper.getEmpByLastNameLikeReturnMap("%k%");
			System.out.println(maps);
		}finally{
         openSession.close();
		}
	}
	
	
	@Test
	public void test05() throws IOException{
		
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		SqlSession openSession =  sqlSessionFactory.openSession(true);
		
		try {
			EmployeeMapperPlus mapper =  openSession.getMapper(EmployeeMapperPlus.class);
//			Employee emp = mapper.getEmpById(3);
//            System.out.println(emp);
			
//			Employee emp = mapper.getEmpAndDept(3);
//			System.out.println(emp);
//			System.out.println(emp.getDept());
			
			//һ�Զ����
			Employee employee = mapper.getEmpByIdStep(3);
			System.out.println(employee);
			System.out.println(employee.getDept());
		}finally{
         openSession.close();
		}
	} 
	
	@Test
	public void test06() throws IOException{
		
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		SqlSession openSession =  sqlSessionFactory.openSession(true);
		
		try {
			DepartmentMapper mapper =  openSession.getMapper(DepartmentMapper.class);

//		    Department dept = mapper.getDeptByIdPlus(2);
//		    System.out.println(dept);
//		    System.out.println(dept.getEmps());
			
			Department dept = mapper.getDeptByIdStep(2);
			System.out.println(dept.getDepartmentName());
//			System.out.println(dept.getEmps());
		}finally{
         openSession.close();
		}
	} 
}
