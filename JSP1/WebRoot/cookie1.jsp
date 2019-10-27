<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import = "javax.servlet.http.Cookie" %>
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
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
Cookie uname = new Cookie("uname",username);
Cookie upwd = new Cookie("upwd",password);
response.addCookie(uname);
response.addCookie(upwd);
response.sendRedirect("cookie2.jsp");
 %>
  </body>
</html>
