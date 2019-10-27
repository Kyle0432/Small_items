<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="javax.ws.rs.WebApplicationException"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import = "com.kyle.spring.struts.beans.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
        <%
          //1,application域对象中得到IOC容器实例
          ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
        
          //2,从IOC容器中得到bean
          Person person = ctx.getBean(Person.class);
        
          //3,使用Bean
          person.hello();
         %>
  </body>
</html>
