package com.kyle.struts2.valuestack;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class Product implements RequestAware,SessionAware{

	private Integer productId;
	
	private String productName;
	
	private String productDesc;
	
	private double productPrice;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public String execute(){
		
		//获取值栈
		ValueStack valuestack = ActionContext.getContext().getValueStack();
		
		//创建Test对象,并且为其附上属性值
		Test test = new Test();
		
		test.setProductDesc("AABBCCDD");
		test.setProductName("ABCD");
		
		//把Test对象压入值栈的栈顶
		valuestack.push(test);
		                          //此时this就表示被调用的Product
		sessionMap.put("product", this);
		requestMap.put("test",test);
		
		
       return "success";
	}
    
	private Map<String,Object> sessionMap;
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}
	
    private Map<String,Object> requestMap;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}
	
	
	
}
