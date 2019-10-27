<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="javaBean.Customer" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'el1.jsp' starting page</title>
    
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
        <form action="<%=request.getContextPath() %>/EL/el1.jsp" method="post">
           username:<input type="text" name= "username" 
           value= "<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>"/>
           <!-- 
           EL 表达式的特点:简洁
            -->
           username:<input type="text" name= "username"
           value="${param.username }"/>
           <input type="submit" value="Submit"/>
    </form>
    
    <br><br>
    
    <jsp:useBean id="customer" class="javaBean.Customer" scope="session"></jsp:useBean>
    <jsp:setProperty property="age" value="12" name="customer"/>
    
    age:
    <%
        Customer customer2 = (Customer)session.getAttribute("customer");
        out.print(customer2.getAge());
     %>
     <br>
    age:<jsp:getProperty property="age" name="customer"/>
    
    <br>
    <br>
    
    <%
        application.setAttribute("time", new Date());
     %>
     
     <a href ="el2.jsp?score=89&name=A&name=B&name=C">To EL2 Page</a>
  </body>
</html>
