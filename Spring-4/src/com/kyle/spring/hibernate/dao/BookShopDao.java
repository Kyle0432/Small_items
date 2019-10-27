package com.kyle.spring.hibernate.dao;

public interface BookShopDao {

	//������Ż�ȡ��ĵ���
	public int findBookPriceByIsbn(String isbn);
	
	//������Ŀ��,ʹ��Ŷ�Ӧ�Ŀ��  -1
	public void updateBookStock(String isbn);
	
	//�����û����˻����,ʹusername��balance - price
	public void updateUserAccount(String username, int price);
	
}
