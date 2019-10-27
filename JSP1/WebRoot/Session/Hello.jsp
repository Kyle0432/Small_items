<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Hello.jsp' starting page</title>
    
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
    SessionId: <%= session.getId() %>
    <br><br>
    
    IsNew: <%= session.isNew() %>
    <br><br>
    
    MaxInactiveInterval:<%= session.getMaxInactiveInterval() %>
    <br><br>
    
    CreateTime: <%= session.getCreationTime() %>
    <br><br>
    
    LastAccessTime: <%= session.getLastAccessedTime() %>
    <br><br>
    
    <%
    session.setAttribute("username", request.getParameter("username"));   
     %>
    <a href="<%= response.encodeURL("Session/Login.jsp")%>">重新登录</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<%= response.encodeURL("Session/Logout.jsp") %>">注销</a>
  </body>
</html>
