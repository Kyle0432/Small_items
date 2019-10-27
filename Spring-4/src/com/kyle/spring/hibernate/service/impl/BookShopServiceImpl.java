package com.kyle.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.spring.hibernate.dao.BookShopDao;
import com.kyle.spring.hibernate.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService {
	//该注解表示它会自动装配该类型的Bean
    @Autowired
	private BookShopDao bookShopDao;
     
	/*
	 * Spring hibernate 事务的流程
	 * 1,在方法开始之前
	 * ①.获取Session
	 * ②.Session和当前线程绑定 ,这样就可以在Dao中使用SessionFactory的
	 * getCurrentSession()方法来获取Session了
	 * ③.开启事务
	 * 2，若方法正常结束,即没有出现异常,则
	 * ①.提交事务
	 * ②.使和当前线程绑定的Session解除绑定
	 * ③.关闭Session
	 * 
	 * 3,若方法出现异常,则
	 * ①.回滚事务
	 * ②.使和当前线程绑定的Session 解除绑定
	 * ③.关不Session
	 * 
	 */
	@Override
	public void purchase(String username, String isbn) {

		//获取单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//更新库存
		bookShopDao.updateBookStock(isbn);
		//更新余额
		bookShopDao.updateUserAccount(username, price);
		
	}

}
