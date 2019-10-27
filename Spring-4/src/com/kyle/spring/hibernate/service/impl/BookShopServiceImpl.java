package com.kyle.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.spring.hibernate.dao.BookShopDao;
import com.kyle.spring.hibernate.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService {
	//��ע���ʾ�����Զ�װ������͵�Bean
    @Autowired
	private BookShopDao bookShopDao;
     
	/*
	 * Spring hibernate ���������
	 * 1,�ڷ�����ʼ֮ǰ
	 * ��.��ȡSession
	 * ��.Session�͵�ǰ�̰߳� ,�����Ϳ�����Dao��ʹ��SessionFactory��
	 * getCurrentSession()��������ȡSession��
	 * ��.��������
	 * 2����������������,��û�г����쳣,��
	 * ��.�ύ����
	 * ��.ʹ�͵�ǰ�̰߳󶨵�Session�����
	 * ��.�ر�Session
	 * 
	 * 3,�����������쳣,��
	 * ��.�ع�����
	 * ��.ʹ�͵�ǰ�̰߳󶨵�Session �����
	 * ��.�ز�Session
	 * 
	 */
	@Override
	public void purchase(String username, String isbn) {

		//��ȡ����
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//���¿��
		bookShopDao.updateBookStock(isbn);
		//�������
		bookShopDao.updateUserAccount(username, price);
		
	}

}
