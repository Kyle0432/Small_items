package com.kyle.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyle.spring.hibernate.dao.BookShopDao;
import com.kyle.spring.hibernate.exceptions.BookStockException;
import com.kyle.spring.hibernate.exceptions.UserAccountException;

//该注解表示持久化组件,在xml里进行配置扫描组件后,该类将会被IOC容器管理,然后就可以引用该类了
@Repository
public class BookShopDaoImpl implements BookShopDao {
   
	@Autowired
	private SessionFactory sessionFactory;
	
	//不推荐使用HibernateTemplate 和 HibernateDaoSupport
	//因为这样会导致Dao 和 Spring 的API进行耦合
	//可抑制变差
	//private HibernateTemplate hibernateTemplate;
	
	//获取和当前线程绑定的Session
	private Session getSession(){
		 return sessionFactory.getCurrentSession();
	}
	
	
	/*
	 * list():调用该方法表示结果放到一个List的集合里面去
	 * uniqueResult():调用该方法表示查询一个字段
	 * executeUpdate():调用该方法表示更新操作
	 */
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String hql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
		Query query = getSession().createQuery(hql).setString(0, isbn);
		return (Integer) query.uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn) {
        //验证书的库存是否足够
		String hql = "SELECT b.stock FROM Book b WHERE b.isbn = ?";
		int stock = (Integer) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		if(stock == 0){
			throw new BookStockException("库存不足");
		}
		String hql2 = "UPDATE Book b SET b.stock = b.stock - 1 WHERE b.isbn = ?";
		getSession().createQuery(hql2).setString(0, isbn).executeUpdate();
	}

	@Override
	public void updateUserAccount(String username, int price) {
        //验证账户余额是否足够
		String hql = "SELECT a.balance FROM Account a WHERE a.username = ?";
		int balance = (Integer) getSession().createQuery(hql).setString(0, username).uniqueResult();
		if(balance < price){
			throw new UserAccountException("余额不足");
		}
        String hql2 = "UPDATE Account a SET a.balance = a.balance - ? WHERE a.username = ?";
        getSession().createQuery(hql2).setInteger(0, price).setString(1, username).executeUpdate();
	}

}
