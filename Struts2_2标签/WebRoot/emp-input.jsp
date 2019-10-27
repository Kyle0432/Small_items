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
    
    <title>My JSP 'input.jsp' starting page</title>
    
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

   <s:form action="emp-save">
   
          <s:textfield name="name" label="Name"></s:textfield>
          <s:password name="password" label="Password"></s:password>
         
          <s:radio name="gender"  list="#{'1':'Male','0':'Female' }" label="Gerder"></s:radio>
          <s:select name="dept" list="#request.depts" listKey="deptId" listValue="deptName" label="Department"></s:select>
          <s:checkboxlist name="roles" list="#request.roles" listKey="roleId" listValue="roleName" label="Role"></s:checkboxlist>
          <s:textarea name="desc" label="Desc"></s:textarea>
          <s:submit></s:submit>
   </s:form>

  </body>
</html>
