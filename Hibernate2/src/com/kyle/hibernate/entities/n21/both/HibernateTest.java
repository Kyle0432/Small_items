 package com.kyle.hibernate.entities.n21.both;

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
	public void testOneToManyUpdate(){
		Customer customer = (Customer) session.get(Customer.class, 1);
		//iterator()方法表示遍历set集合 然后该集合是无序的
		customer.getOrders().iterator().next().setOrderName("zezeze");
	}
	
	//UPDATE
	@Test
    public void testManyToOneUpdate(){
    	Order order = (Order) session.get(Order.class, 1);
    	order.getCustomer().setCustomerName("Kyle");
    	
    }
	//QUERY
	@Test
	public void  testOneToManyGet(){
		//1,对n的一端的集合使用延迟加载
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println(customer.getCustomerName());
		
		//2,返回的多的一端的集合时Hibernate内置的集合类型
		//该类型具有延迟加载和存放代理对象的功能
		System.out.println(customer.getOrders().getClass());
		
		//session.close();
		//3,可能会抛出LazyInitializationException 异常
		System.out.println(customer.getOrders().size());
		
		//4,需要使用集合中的元素的时候进行初始化,防止空指针异常
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
    	//此时整个就双向关联关系了
    	customer.getOrders().add(order1);
    	customer.getOrders().add(order2);
    	
    	//先执行save操作:先插入Customer,再插入Order,
    	//结果有3条INSERT语句,2条UPDATE语句
    	//因为1的一端和n的一端都在会去维护关联关系,所以会多出UPDATE
    	//可以在1的一端的set节点指定inverse=true,来使1的一端放弃
    	//维护关联关系！ 建议设定set 的 inverse = true,
    	//建议先插入1的一端,后插入多的一端,好处是不会多出UPDATE语句
/*    	session.save(customer);
    	session.save(order1);
    	session.save(order2);*/
    	
    	//如果先插入Order,再插入Customer,结果有3条INSERT,4条UPDATE
    	
    	session.save(order1);
    	session.save(order2);
    	session.save(customer);
    }
}
