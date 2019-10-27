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
    	//�ڲ��趨������ϵ�����,��1����һ�˵Ķ�����n�Ķ���������,����
    	//ֱ��ɾ��1����һ�˵Ķ���,���û�����������ֱ��ɾ���ö���
    	Customer customer = (Customer) session.get(Customer.class, 1);
    	session.delete(customer);
    }
	public void testOneToManyUpdate(){
		Customer customer = (Customer) session.get(Customer.class, 1);
		//iterator()������ʾ����set���� Ȼ��ü����������
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
		//1,��n��һ�˵ļ���ʹ���ӳټ���
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println(customer.getCustomerName());
		
		//2,���صĶ��һ�˵ļ���ʱHibernate���õļ�������
		//�����;����ӳټ��غʹ�Ŵ������Ĺ���
		System.out.println(customer.getOrders().getClass());
		
		//session.close();
		//3,���ܻ��׳�LazyInitializationException �쳣
		System.out.println(customer.getOrders().size());
		
		//4,��Ҫʹ�ü����е�Ԫ�ص�ʱ����г�ʼ��,��ֹ��ָ���쳣
	}
	//QUERY
	@Test
    public void testManyToOneGet(){
    	//1,����ѯ���һ�˵�һ������,����Ĭ�������,ֻ��ѯ�˶��һ�˵Ķ���
    	//��û�в�ѯ������1����һ�˵Ķ���
    	Order order = (Order) session.get(Order.class, 1);
    	System.out.println(order.getOrderName());
    	
    	System.out.println(order.getCustomer().getClass().getName());
    	
    	//session.close();
    	
    	//2,����Ҫʹ�õ������Ķ���ʱ,�ŷ��Ͷ�Ӧ��SQL���
    	Customer customer = order.getCustomer();
    	System.out.println(customer.getCustomerName());
    	
    	//3,�ڲ�ѯCustomer����ʱ,�ɶ��һ�˵�����1��һ��ʱ
    	//����ʱsession���ر���,��Ĭ�������
    	//�ᷢ�� LazyInitializationException �쳣
    	
    	//4,��ȡOrder����ʱ,Ĭ�������,�������Customer������һ���������
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
    	
    	//�趨������ϵ
    	order1.setCustomer(customer);
    	order2.setCustomer(customer);
    	//��ʱ������˫�������ϵ��
    	customer.getOrders().add(order1);
    	customer.getOrders().add(order2);
    	
    	//��ִ��save����:�Ȳ���Customer,�ٲ���Order,
    	//�����3��INSERT���,2��UPDATE���
    	//��Ϊ1��һ�˺�n��һ�˶��ڻ�ȥά��������ϵ,���Ի���UPDATE
    	//������1��һ�˵�set�ڵ�ָ��inverse=true,��ʹ1��һ�˷���
    	//ά��������ϵ�� �����趨set �� inverse = true,
    	//�����Ȳ���1��һ��,�������һ��,�ô��ǲ�����UPDATE���
/*    	session.save(customer);
    	session.save(order1);
    	session.save(order2);*/
    	
    	//����Ȳ���Order,�ٲ���Customer,�����3��INSERT,4��UPDATE
    	
    	session.save(order1);
    	session.save(order2);
    	session.save(customer);
    }
}
