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
		
		//��ȡ Session
		//��������
		Session session = HibernateUtils.getInstance().getSession();
		System.out.println("-->" + session.hashCode());
		Transaction transaction = session.beginTransaction();
		
		DepartmentDao departmentDao = new DepartmentDao();
		
		Department dept = new Department();
		dept.setName("ATGUIGU");
		
		departmentDao.save(dept);
		departmentDao.save(dept);
		departmentDao.save(dept);
		
		//�� Session ���� thread �������, �����ύ��ع�����ʱ, �Ѿ��ر� Session ��. 
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
		//ͬʱҲ����ִ��update����
		String hql = "DELETE FROM Department d WHERE d.id = ";
		session.createQuery(hql).setInteger("id", 66).executeUpdate();
		
	}
	
	@Test
	public void testNativeSQL(){
		//ͨ��HQLִ�в������
		String sql = "INSERT INTO departments VALYES(?,?)";
		Query query = session.createSQLQuery(sql);
		query.setInteger(0, 222)
		     .setString(1, "Kyle")
		     .executeUpdate();
	}  
	
	@Test
	public void testQBC4(){
		Criteria criteria = session.createCriteria(Employee.class);
		
		//1,�������
		criteria.addOrder(Order.asc("salary"));
		criteria.addOrder(Order.desc("email"));
		
		//2,��ӷ�ҳ����
		int pageSize = 5;
		int pageNo = 4;
		criteria.setFirstResult((pageNo - 1) * pageSize)
		        .setMaxResults(pageSize).list();   
	}
	
	@Test
	public void testQBC3(){
		Criteria criteria = session.createCriteria(Employee.class);
		//ͳ�Ʋ�ѯ:ʹ��Projection����ʾ:������Projecttions�ľ�̬�����õ�
		criteria.setProjection(Projections.max("salary"));
		System.out.println(criteria.uniqueResult());
	}
	
	@Test
	public void testQBC2(){
		Criteria criteria = session.createCriteria(Employee.class);
		//1,AND:ʹ��Conjunction��ʾ
		//Conjunction�������һ��Criteria����
		//�����л��������Criteruon����
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
		//1,����һ��Criteria����
		Criteria criteria = session.createCriteria(Employee.class);
		
		//2,��Ӳ�ѯ����:��QBC�в�ѯ����ʹ��Criteria����ʾ
		//Criteria����ͨ��Restrictions�ľ�̬�����õ�
		criteria.add(Restrictions.eqProperty("email", "KYLE"));//��������ֵ
		criteria.add(Restrictions.gt("salary", 2000F));//gt��ʾ����
		
		//ִ�в�ѯ�������uniqueResult����
		Employee employee = (Employee) criteria.uniqueResult();
		System.out.println(employee);
	}
	
	
	@Test
	public void testLeftJoinFetch(){
		//DISTINCT��ʾ�����ظ�Ԫ��
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
		//ֱ�Ӱ���Ҫ�����Էŵ���������ȥ,������Employee��Ҫ���ú��ι�����
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
		//��ʾֻ��ѯ��Ҫ��e.email,e.salary,e.dept�����ֶ�
		//����ʱһ���ֶ��л��Ӧ���ֵ����ÿ���ֶζ����кܶ��Ӧ��ֵ
		//��ʱÿ���ֶε�ֵ�����������ʽ����
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
		//getNamedQuery��������Ҫ��hbm�ļ����������Ӧ������
		//��ʾHQL���д��hbm�ļ�����
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
		
		//��ʱ�����õ�setFirstResult,��setMaxResults�ĺô�
		//�ǲ��ܵײ����ݿ���ʲô����֧�� ,MySQL Oracle�ȵ� ��֧��
		//�����limitȥ���� �Ǹ÷���ֻ��MySQL���ݿ����ö�Oracle
		//��limit��Чֻ��rownum��Oracle����
		List<Employee> emps = 
		query.setFirstResult((pageNo - 1) *pageSize)
		     .setMaxResults(pageSize).list();
		
		System.out.println(emps);
	}
	
	@Test
	public void testHQLNamedParameter(){
		
		//1,����Query����
		//���������Ĳ���
		String hql = "FROM Employee e WHERE"
				+ " e.salary > :sal AND"
				+ " e.email LIKE :email";
		Query query = session.createQuery(hql);
		
		//2,�󶨲���
		query.setFloat("sal", 7000)
		     .setString("email", "%A%");
		
		//3,ִ�в�ѯ
		List<Employee> emps = query.list();
		System.out.println(emps.size());
	}        
	@Test
	public void testHQL(){
		//1,����Query ����
		//����λ�õĲ��� 
		
		//ע��HQL�����ֱ��FROM��ʡ��SELECT
		//��ʾ��ѯEmployee��������ֶξͿ��Բ�дSELSECT
		//�൱��զSQL����Ĳ�ѯ�����ֶο�����*����ʾ.
		//�����e�൱��Employee ��һ������ ��������Employee�������
		String hql = "FROM Employee e WHERE e.salary > ?"
				+ " AND e.email LIKE ? AND e.dept = ? "
				+ "ORDER BY e.salary";
		Query query = session.createQuery(hql);
		
		//2,�󶨲���
		//Query�������setXxx����֧�ַ������ı�̷��
		//����󶨲���Ҳ�����Ƕ���,���������setEntity
		//����֮ǰҪ��dept���г�ʼ�����������ID��������
		//ͨ��ID����ȡ��ID��һЩ��¼
		Department dept = new Department();
		dept.setId(3);
		query.setFloat(0, 20000)
		     .setString(1, "%A%")
		     .setEntity(2, dept);
		//3,ִ�в�ѯ
		//��ѯʱҪ����list()����,��Ϊ��ʱquery��һ������
		//����list()����,�൱�Ѳ�����Ķ�����¼�ŵ�list������.
		List<Employee> emps = query.list();
		System.out.println(emps.size());
	}
	
}
