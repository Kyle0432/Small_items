package com.kyle.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//该注解表示标识持久化组件
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao{
    //自动装配
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class,isbn);
	}

	@Override
	public void updateBookStock(String isbn) {
		//检查书的库存是否足够,若不够,则抛出异常
		String sql = "SELECT stock FROM book_stock WHERE isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql,Integer.class,isbn);
		if(stock == 0){
			 throw new BookStockException("库存不足");
		}
		String sql2 = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
		jdbcTemplate.update(sql2,isbn);
	}

	@Override
	public void updateUserAccount(String username, int price) {
		//验证余额是否足够,若不足,则抛出异常
		String sql = "SELECT balance FROM account WHERE username = ?";
		int balance = jdbcTemplate.update(sql,Integer.class,username);
		if(balance < price){
			throw new UserAccountException("余额不足");
		}
		String sql2 = "UPDATE account SET balance = balance - ? WHERE username = ?";
		jdbcTemplate.update(sql2,price,username);
	}

}
