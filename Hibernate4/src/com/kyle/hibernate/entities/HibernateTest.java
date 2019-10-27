package com.kyle.hibernate.entities;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kyle.hibernate.hibernate.HibernateUtils;

public class HibernateTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
        Configuration configuration = new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
		.applySettings(configuration.getProperties()).buildServiceRegistry(); 
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		session = sessionFactory.openSession();
		
		transaction = session.beginTransaction();
	}
	
	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	/*@Test
	public void testManageSession(){
		
		//获取 Session
		//开启事务
		Session session = HibernateUtils.getInstance().getSession();
		System.out.println("-->" + session.hashCode());
		Transaction transaction = session.beginTransaction();
		
		DepartmentDao departmentDao = new DepartmentDao();
		
		Department dept = new Department();
		dept.setName("ATGUIGU");
		
		departmentDao.save(dept);
		departmentDao.save(dept);
		departmentDao.save(dept);
		
		//若 Session 是由 thread 来管理的, 则在提交或回滚事务时, 已经关闭 Session 了. 
		transaction.commit();
		System.out.println(session.isOpen()); 
	}*/
	
	@Test
	public void testQueryIterate(){
		Department dept = (Department) session.get(Department.class, 70);
		System.out.println(dept.getName());
		System.out.println(dept.getEmps().size()); 
		
		Query query = session.createQuery("FROM Employee e WHERE e.dept.id = 80");
//		List<Employee> emps = query.list();
//		System.out.println(emps.size()); 
		
		Iterator<Employee> empIt = query.iterate();
		while(empIt.hasNext()){
			System.out.println(empIt.next().getName()); 
		}
	}
	
	@Test
	public void testUpdateTimeStampCache(){
		Query query = session.createQuery("FROM Employee");
		query.setCacheable(true);
		
		List<Employee> emps = query.list();
		System.out.println(emps.size());
		
		Employee employee = (Employee) session.get(Employee.class, 100);
		employee.setSalary(30000);
		
		emps = query.list();
		System.out.println(emps.size());
	}
	
	@Test
	public void testQueryCache(){
		Query query = session.createQuery("FROM Employee");
		query.setCacheable(true);
		
		List<Employee> emps = query.list();
		System.out.println(emps.size());
		
		emps = query.list();
		System.out.println(emps.size());
		
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setCacheable(true);
	}
	
	@Test
	public void testCollectionSecondLevelCache(){
		Department dept = (Department) session.get(Department.class, 80);
		System.out.println(dept.getName());
		System.out.println(dept.getEmps().size()); 
		
		transaction.commit();
		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Department dept2 = (Department) session.get(Department.class, 80);
		System.out.println(dept2.getName());
		System.out.println(dept2.getEmps().size()); 
	}
	
	@Test
	public void testHibernateSecondLevelCache(){
		Employee employee = (Employee) session.get(Employee.class, 100);
		System.out.println(employee.getName()); 
		
		transaction.commit();
		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Employee employee2 = (Employee) session.get(Employee.class, 100);
		System.out.println(employee2.getName()); 
	}
	
	@Test
	public void testHQLUpdate(){
		//同时也可以执行update操作
		String hql = "DELETE FROM Department d WHERE d.id = ";
		session.createQuery(hql).setInteger("id", 66).executeUpdate();
		
	}
	
	@Test
	public void testNativeSQL(){
		//通过HQL执行插入操作
		String sql = "INSERT INTO departments VALYES(?,?)";
		Query query = session.createSQLQuery(sql);
		query.setInteger(0, 222)
		     .setString(1, "Kyle")
		     .executeUpdate();
	}  
	
	@Test
	public void testQBC4(){
		Criteria criteria = session.createCriteria(Employee.class);
		
		//1,添加排序
		criteria.addOrder(Order.asc("salary"));
		criteria.addOrder(Order.desc("email"));
		
		//2,添加翻页方法
		int pageSize = 5;
		int pageNo = 4;
		criteria.setFirstResult((pageNo - 1) * pageSize)
		        .setMaxResults(pageSize).list();   
	}
	
	@Test
	public void testQBC3(){
		Criteria criteria = session.createCriteria(Employee.class);
		//统计查询:使用Projection来表示:可以由Projecttions的静态方法得到
		criteria.setProjection(Projections.max("salary"));
		System.out.println(criteria.uniqueResult());
	}
	
	@Test
	public void testQBC2(){
		Criteria criteria = session.createCriteria(Employee.class);
		//1,AND:使用Conjunction表示
		//Conjunction本身就是一个Criteria对象
		//且其中还可以添加Criteruon对象
		Conjunction conjunction  = Restrictions.conjunction();
		conjunction.add(Restrictions.like("name", "a",MatchMode.ANYWHERE));
		Department dept = new Department();
		dept.setId(20);
		conjunction.add(Restrictions.eq("dept", dept));
		System.out.println(conjunction);
		
		//2,OR
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.ge("salary", 5000F));
		disjunction.add(Restrictions.isNull("email"));
		
		criteria.add(disjunction);
		criteria.add(conjunction);
		criteria.list();
	}
	
	@Test
	public void testQBC(){
		//1,创建一个Criteria对象
		Criteria criteria = session.createCriteria(Employee.class);
		
		//2,添加查询条件:在QBC中查询条件使用Criteria来表示
		//Criteria可以通过Restrictions的静态方法得到
		criteria.add(Restrictions.eqProperty("email", "KYLE"));//设置属性值
		criteria.add(Restrictions.gt("salary", 2000F));//gt表示大于
		
		//执行查询结果调用uniqueResult方法
		Employee employee = (Employee) criteria.uniqueResult();
		System.out.println(employee);
	}
	
	
	@Test
	public void testLeftJoinFetch(){
		//DISTINCT表示过滤重复元素
		String hql = "SELECT DISTINCT d FROM Department d"
				+ " LEFT JOIN FETCH d.emps";
		Query query = session.createQuery(hql);
		
		List<Department> depts = query.list();
		
		for(Department dept: depts){
			System.out.println(dept.getName() + "-" + dept.getEmps().size());
		}
	}
	@Test
	public void testGroupBy(){
		
		String hql = "SELECT min(e.salary),max(e.salary) "
				+ "FROM Employee e Group By e.dept"
				+ " HAVING min(salary) > :minSal";
		Query query = session.createQuery(hql);
		
		List<Object[]> result = query.setFloat("minSAL", 8000).list();
		
		for(Object[] objs:result){
			
			System.out.println(Arrays.asList(objs));
		}
		
	}
	
	@Test
	public void testFieldQuery2(){
		//直接把需要的属性放到对象里面去,并且在Employee里要设置含参构造器
		String hql = "SELECT new Employee(e.email,e.salary,e.dept) "
				+ "FROM Employee e WHERE e.dept = :dept";
		Query query = session.createQuery(hql);
		
		Department dept = new Department();
		dept.setId(11);
		List<Employee> result = query.setEntity("dept", dept).list();
		
		for(Employee emp:result){
           System.out.println(emp.getId()+","+emp.getEmail()+","+emp.getSalary()+","+emp.getDept());			
		}
	}
	
	
	@Test
	public void testFieldQuery(){
		//表示只查询需要的e.email,e.salary,e.dept三个字段
		//而此时一个字段有会对应多个值所以每个字段都会有很多对应的值
		//此时每个字段的值会以数组的形式存在
		String hql = "SELECT e.email,e.salary,e.dept "
				+ "FROM Employee e WHERE e.dept = :dept";
		Query query = session.createQuery(hql);
		
		Department dept = new Department();
		dept.setId(33);
		List<Object []> result = query.setEntity("dept", dept)
		                              .list();
		for(Object[] objs:result){
			
			System.out.println(Arrays.asList(objs));
		}
	}
	
	@Test
	public void testNamedQuery(){
		//getNamedQuery方法还需要在hbm文件里面进行相应的配置
		//表示HQL语句写在hbm文件里面
		Query query = session.getNamedQuery("salaryEmps");
		List<Employee> emps = query.setFloat("minSal", 5000)
				                   .setFloat("maxSal", 10000)
				                   .list();
		System.out.println(emps);
	}
	
	@Test
	public void testPageQuery(){
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		
		int pageNo = 22;
		int pageSize = 5;
		
		//此时这里用到setFirstResult,和setMaxResults的好处
		//是不管底层数据库是什么都会支持 ,MySQL Oracle等等 都支持
		//如果用limit去限制 那该方法只对MySQL数据库有用而Oracle
		//对limit无效只有rownum对Oracle有用
		List<Employee> emps = 
		query.setFirstResult((pageNo - 1) *pageSize)
		     .setMaxResults(pageSize).list();
		
		System.out.println(emps);
	}
	
	@Test
	public void testHQLNamedParameter(){
		
		//1,创建Query对象
		//基于命名的参数
		String hql = "FROM Employee e WHERE"
				+ " e.salary > :sal AND"
				+ " e.email LIKE :email";
		Query query = session.createQuery(hql);
		
		//2,绑定参数
		query.setFloat("sal", 7000)
		     .setString("email", "%A%");
		
		//3,执行查询
		List<Employee> emps = query.list();
		System.out.println(emps.size());
	}        
	@Test
	public void testHQL(){
		//1,创建Query 对象
		//基于位置的参数 
		
		//注意HQL这里的直接FROM而省略SELECT
		//表示查询Employee表的所有字段就可以不写SELSECT
		//相当于咋SQL里面的查询所有字段可以用*来表示.
		//这里的e相当于Employee 的一个对象 可以引用Employee里的属性
		String hql = "FROM Employee e WHERE e.salary > ?"
				+ " AND e.email LIKE ? AND e.dept = ? "
				+ "ORDER BY e.salary";
		Query query = session.createQuery(hql);
		
		//2,绑定参数
		//Query对象调用setXxx方法支持方法链的编程风格
		//这里绑定参数也可以是对象,对象就是用setEntity
		//但是之前要对dept进行初始化操作对象的ID这样就是
		//通过ID来调取该ID的一些记录
		Department dept = new Department();
		dept.setId(3);
		query.setFloat(0, 20000)
		     .setString(1, "%A%")
		     .setEntity(2, dept);
		//3,执行查询
		//查询时要调用list()方法,因为此时query是一个对象
		//调用list()方法,相当把查出来的多条记录放到list集合里.
		List<Employee> emps = query.list();
		System.out.println(emps.size());
	}
	
}
