<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'javaBean.jsp' starting page</title>
    
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
   <jsp:useBean id = "customer" class = "javaBean.Customer" scope = "request"></jsp:useBean>
   <jsp:useBean id = "customer2" beanName = "javaBean.Customer" type = "java.lang.Object" scope="request"></jsp:useBean>
   <%--
   Object customer2 = request.getAttribute("customer2");
   if(customer2){
          customer2 = Class.forName("javaBean.Customer").newInstance();
          request.setAttibute("customer2",customer2);
   }
    --%>
    <!-- 若property 的值为*,省略value 属性值,则将自动为所有属性值为对应的请求参数的值 -->
    <jsp:setProperty property="*" name="customer"/>
    <%--
    <jsp:setProperty property="name" value="Kyle" name="customer"/>
     --%>
     age:<jsp:getProperty property="age" name="customer"/>
     <br>
     name:<jsp:getProperty property="name" name="customer"/>
     <br>
     id:<jsp:getProperty property="id" name="customer"/>
     <%-- 
     <%= customer.getAge() %>
     --%>
     <%--
         customer.setAge(10)
      --%>
      	<%-- 
		//1. 从 scope(session) 中获取 id(customer) 属性值, 赋给 class(com.atguigu.javaweb.Customer) 
		//类型的 id(customer) 变量
		Customer customer = (Customer)session.getAttribute("customer");
		
		//2. 若属性值为 null, 则利用反射创建一个新的对象, 把该对象赋给 id(customer), 并以 id(customer) 
		//为属性名让如到 scope(session) 中.
		if(customer == null){
			customer = (Customer)Class.forName("com.atguigu.javaweb.Customer").newInstance();
			session.setAttribute("customer", customer);
		}
	--%>
  </body>
</html>
