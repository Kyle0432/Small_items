package com.kyle.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {

	public String execute(){
		//1,��ȡActionContext����
		//ActionContext ��Action�������Ķ���,���Դ��л�ȡ����Action��Ҫ��һ����Ϣ
		  ActionContext actionContext = ActionContext.getContext();
		
		//2,��ȡapplication��Ӧ��Map �������м����и�����
		//ͨ������ActionContext �����getApplication()��������ȡapplication�����Map����
		  Map <String,Object> applicationMap = actionContext.getApplication();
		  //��������ֵ
		  applicationMap.put("application","applicationValue");
		  //��ȡ����ֵ
		  Object date = applicationMap.get("date");
		  System.err.println("date:"+date);
		//3session
		  Map<String,Object> sessionMap = actionContext.getSession();
		  sessionMap.put("sessionKey","sessionValue");
		// 4,request
		  //ActionContext�в�û���ṩgetRequest��������ȡrequest��Ӧ��Map
		  //��Ҫ�ֹ�����get(������,����request�ַ�������ȡ
		  Map<String,Object> requestMap = (Map<String, Object>) actionContext.get("request");
		  requestMap.put("requestKey","requestValue");
		//5,��ȡ���������Ӧ��Map,����ȡָ���Ĳ���ֵ  
		  //��"������������� , ֵ:���������ֵ��Ӧ���ַ���
		  //ע��:1,getParameters �ķ���ֵΪ��Map<String,Object>,������Map<String,String[]>
		  //ע��:2,parameters���Mapֻ�ܶ�,����д������,���д�벻�ᱨ��,��Ҳ��������
		  Map<String,Object> parameters = actionContext.getParameters();
		  System.out.println(((String[])parameters.get("name"))[0]);
		  
		return"success";
	}
	
	
}
