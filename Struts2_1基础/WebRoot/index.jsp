<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
      <a href="product-input.action">Product Input</a>
      <br><br>
      
      <a href="TestActionContext.action?name=atguigu">Test ActionContext</a>
      <br><br>
      
      <a href="TestAware.do?name=atguigu">Test Aware</a>
      <br><br>
      
      <a href="TestServletActionContext.do">Test Servlet</a>
      <br><br>
      
      <a href="TestResult.do?number = 4">Test Result</a>
      <br><br>
      
      <a href="UserAction-save">User Save</a>
      <br><br>
      
      <a href="UserAction-update">User Update</a>
      <br><br>
      
      <a href="UserAction-delete">User Delete</a>
      <br><br>
      
      <a href="UserAction-query">User Query</a>
      <br><br>
  </body>
</html>
