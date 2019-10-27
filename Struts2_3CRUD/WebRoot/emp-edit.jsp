<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emp-edit.jsp' starting page</title>
    
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
        <s:debug></s:debug>
        <br>
        <br>
        <s:form action="emp-update"> <!-- 此隐藏域的表示要通过哪个Id来修改 -->
               <s:hidden name="employeeId"></s:hidden>
               <s:textfield name="firstName" label="FirstName"></s:textfield>
               <s:textfield name="lastName" label="LastName"></s:textfield>
               <s:textfield name="email" label="Email"></s:textfield>
               <s:submit></s:submit>
        </s:form>
  </body>
</html>
