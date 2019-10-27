package com.kyle.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {

	public String execute(){
		//1,获取ActionContext对象
		//ActionContext 是Action的上下文对象,可以从中获取到往Action需要的一切信息
		  ActionContext actionContext = ActionContext.getContext();
		
		//2,获取application对应的Map 并向其中加入有个属性
		//通过调用ActionContext 对象的getApplication()方法来获取application对象的Map对象
		  Map <String,Object> applicationMap = actionContext.getApplication();
		  //设置属性值
		  applicationMap.put("application","applicationValue");
		  //获取属性值
		  Object date = applicationMap.get("date");
		  System.err.println("date:"+date);
		//3session
		  Map<String,Object> sessionMap = actionContext.getSession();
		  sessionMap.put("sessionKey","sessionValue");
		// 4,request
		  //ActionContext中并没有提供getRequest方法来获取request对应的Map
		  //需要手工调用get(）方法,传入request字符串来获取
		  Map<String,Object> requestMap = (Map<String, Object>) actionContext.get("request");
		  requestMap.put("requestKey","requestValue");
		//5,获取请求参数对应的Map,并获取指定的参数值  
		  //键"请求参数的名字 , 值:请求参数的值对应的字符串
		  //注意:1,getParameters 的返回值为在Map<String,Object>,而不是Map<String,String[]>
		  //注意:2,parameters这个Map只能读,不能写入数据,如果写入不会报错,但也不起作用
		  Map<String,Object> parameters = actionContext.getParameters();
		  System.out.println(((String[])parameters.get("name"))[0]);
		  
		return"success";
	}
	
	
}
