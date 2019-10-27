<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
      <h1>Success Page</h1>
      <br><br>
      
      time:${requestScope.time}
      <br><br>
      
      names:${requestScope.names}
      <br><br>
      
      request user: ${requestScope.user }
	  <br><br>
	
	  session user: ${sessionScope.user }
	  <br><br>
	
	  request school: ${requestScope.school }
	  <br><br>
	
	  session school: ${sessionScope.school }
	  <br><br>
	  
	  <fmt:message key="i18n.username"></fmt:message>
	  <br><br>
	  
	  <fmt:message key="i18n.password"></fmt:message>
	  <br><br>
	  
  </body>
</html>
