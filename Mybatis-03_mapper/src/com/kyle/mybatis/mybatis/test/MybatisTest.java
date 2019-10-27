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

	/*
	 * 基于注解的 测试
	 */
	@Test
	public void test02() throws IOException{
		//1,获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//2,获取sqlSession对象
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
	 * 测试增删改
	 * 1,mybatis允许增删改直接定义以下类型返回值
	 * 
	 * Integer Long Boolean void
	 * 2,我们需要手动提交数据
	 * sqlSessionFactory.openSession(); ===>手动提交
	 * sqlSessionFactory.openSession(true); ===>自动提交
	 *  
	 */
	@Test
	public void test03() throws IOException{
		
		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactory();
		//1,获取到的SqlSession不会自动提交数据
		SqlSession openSession =  sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper =  openSession.getMapper(EmployeeMapper.class);
			
//			添加操作
	        Employee employee = new Employee(null, "kyle", "kyle@qq.com","1");
			mapper.addEmp(employee);
			System.out.println(employee.getId());
//			更新操作
//			Employee employee = new Employee(2, "caven", "caven@qq.com","1");
//			mapper.updateEmp(employee);
			
//			删除操作
//			mapper.deleteById(2);
			
			//2,手动提交数据才能生效
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
			
//			多参数查询:Employee employee = mapper.getEmployeeByIdAndLastName(1, "kyle");
			
//			多参数放到map集合中与表名通过预处理占位操作:
//			<String,Object> map = new HashMap<String,Object>();
//			map.put("id", 1);
//			map.put("lastName", "kyle");
//			map.put("tableName", "employee");
//			Employee employee = mapper.getEmpByMap(map);
			
//			模糊查询
//			List<Employee> emps = mapper.getEmpsByLastNameLike("%K%");
//			//循环遍历出模糊查询出来的数据
//			for(Employee employees:emps){
//				System.out.println(employees);
//			}

//			返回一条记录的map:key就是别名,值就是对应的值
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
			
			//一对多操作
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
