package com.kyle.spring.tx;


import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//���������IOC������ͨ�����ͻ�ȡBeanʵ��
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testTransactionlPropagation(){
		cashier.checkout("kyle", Arrays.asList("1001", "1002"));
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("kyle", "1001");
	}
	
	@Test
	public void testBookShopDaoUpdateUserAccount(){
		bookShopDao.updateUserAccount("kyle", 200);
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock(){
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}

}
