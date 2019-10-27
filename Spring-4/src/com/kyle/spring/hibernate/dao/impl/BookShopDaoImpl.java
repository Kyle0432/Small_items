package com.kyle.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kyle.spring.hibernate.dao.BookShopDao;
import com.kyle.spring.hibernate.exceptions.BookStockException;
import com.kyle.spring.hibernate.exceptions.UserAccountException;

//��ע���ʾ�־û����,��xml���������ɨ�������,���ཫ�ᱻIOC��������,Ȼ��Ϳ������ø�����
@Repository
public class BookShopDaoImpl implements BookShopDao {
   
	@Autowired
	private SessionFactory sessionFactory;
	
	//���Ƽ�ʹ��HibernateTemplate �� HibernateDaoSupport
	//��Ϊ�����ᵼ��Dao �� Spring ��API�������
	//�����Ʊ��
	//private HibernateTemplate hibernateTemplate;
	
	//��ȡ�͵�ǰ�̰߳󶨵�Session
	private Session getSession(){
		 return sessionFactory.getCurrentSession();
	}
	
	
	/*
	 * list():���ø÷�����ʾ����ŵ�һ��List�ļ�������ȥ
	 * uniqueResult():���ø÷�����ʾ��ѯһ���ֶ�
	 * executeUpdate():���ø÷�����ʾ���²���
	 */
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String hql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
		Query query = getSession().createQuery(hql).setString(0, isbn);
		return (Integer) query.uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn) {
        //��֤��Ŀ���Ƿ��㹻
		String hql = "SELECT b.stock FROM Book b WHERE b.isbn = ?";
		int stock = (Integer) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		if(stock == 0){
			throw new BookStockException("��治��");
		}
		String hql2 = "UPDATE Book b SET b.stock = b.stock - 1 WHERE b.isbn = ?";
		getSession().createQuery(hql2).setString(0, isbn).executeUpdate();
	}

	@Override
	public void updateUserAccount(String username, int price) {
        //��֤�˻�����Ƿ��㹻
		String hql = "SELECT a.balance FROM Account a WHERE a.username = ?";
		int balance = (Integer) getSession().createQuery(hql).setString(0, username).uniqueResult();
		if(balance < price){
			throw new UserAccountException("����");
		}
        String hql2 = "UPDATE Account a SET a.balance = a.balance - ? WHERE a.username = ?";
        getSession().createQuery(hql2).setInteger(0, price).setString(1, username).executeUpdate();
	}

}
