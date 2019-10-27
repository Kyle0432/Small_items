package com.kyle.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("cashier")
public class CashierImpl implements Cashier {
    
	@Autowired
	private BookShopService bookShopService;
	
	//购买全部,结账操作
	@Override
	public void checkout(String username, List<String> isbns) {
          for(String isbn:isbns){
        	  bookShopService.purchase(username, isbn);
          }
	}

}
