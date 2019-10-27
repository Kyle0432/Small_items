package com.kyle.spring.tx.xml.service.impl;

import java.util.List;

import com.kyle.spring.tx.xml.service.BookShopService;
import com.kyle.spring.tx.xml.service.Cashier;
public class CashierImpl implements Cashier {
    
	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	//购买全部,结账操作
	@Override
	public void checkout(String username, List<String> isbns) {
          for(String isbn:isbns){
        	  bookShopService.purchase(username, isbn);
          }
	}

}
