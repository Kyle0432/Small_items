package com.kyle.hibernate.entities.n21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kyle.hibernate.entities.News;
import com.kyle.hibernate.entities.Pay;
import com.kyle.hibernate.entities.Worker;

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
	
	//DELETE
	@Test
    public void testManyToOneDelete(){
    	//在不设定级联关系情况下,且1的这一端的对象有n的对象在引用,不能
    	//直接删除1的这一端的对象,如果没有引用则可以直接删除该对象
    	Customer customer = (Customer) session.get(Customer.class, 1);
    	session.delete(customer);
    }
	//UPDATE
	@Test
    public void testManyToOneUpdate(){
    	Order order = (Order) session.get(Order.class, 1);
    	order.getCustomer().setCustomerName("Kyle");
    	
    }
	//QUERY
	@Test
    public void testManyToOneGet(){
    	//1,若查询多的一端的一个对象,则在默认情况下,只查询了多的一端的对象
    	//而没有查询关联的1的那一端的对象
    	Order order = (Order) session.get(Order.class, 1);
    	System.out.println(order.getOrderName());
    	
    	System.out.println(order.getCustomer().getClass().getName());
    	
    	//session.close();
    	
    	//2,在需要使用到关联的对象时,才发送对应的SQL语句
    	Customer customer = order.getCustomer();
    	System.out.println(customer.getCustomerName());
    	
    	//3,在查询Customer对象时,由多的一端导航到1的一端时
    	//若此时session被关闭了,则默认情况下
    	//会发生 LazyInitializationException 异常
    	
    	//4,获取Order对象时,默认情况下,其关联的Customer对象是一个代理对象
    }
	//INSERT
	@Test
    public void testManyToOneSave(){
    	Customer customer = new Customer();
    	customer.setCustomerName("AA");
    	
    	Order order1 = new Order();
    	order1.setOrderName("ORDER-1");
    	
    	Order order2 = new Order();
    	order2.setOrderName("ORDER-2");
    	
    	//设定关联关系
    	order1.setCustomer(customer);
    	order2.setCustomer(customer);
    	
    	//先执行save操作:先插入Customer,再插入Order,结果有3条INSERT语句
    	//先插入1的一端,再插入n的一端,只有INSERT
    	
    	/*session.save(customer);
    	session.save(order1);
    	session.save(order2);*/
    	
    	//如果先插入Order,再插入Customer,结果有3条INSERT,2条UPDATE
    	//先插入n的一端,再插入1的一端,会多出UPDATE语句
    	//因为在插入多的一端时,无法确定1的一端的外键值,所有只能等1的一端插入
    	//后,再额外发送UPDATE语句,推荐先插入1的一端,后插入n的一端,这样效率高
    	
    	session.save(order1);
    	session.save(order2);
    	session.save(customer);
    }
}
