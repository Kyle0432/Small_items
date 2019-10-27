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
    
    <title>My JSP 'el2.jsp' starting page</title>
    
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
        <!-- 7.EL的运算符 -->
        ${param.score > 60?"及格":不及格}
        <br>
        
        <%
           List<String> names = new ArrayList<String>();
           names.add("abc");
           request.setAttribute("names",names);
         %>
         <!-- empty 可以作用于一个集合,若该集合不存在或集合中没有元素,其结果都为true-->
         names is empty:${empty requestScope.names}
         <br>
         
         <!-- 6.其他隐含对象:pageContext等(cookie,header,initParam只需了解) -->
         <!-- pageContext: pageContext 即为PageContext类型,但是只读取属性就可以一直.下去 -->
         <br>
         contextPath:${pageContext.request.contextPath}
         <br>
         sessionId:${pageContext:session.id}
         <br>
         sessionAttributeNames:${pageContext.session.attributeNames}
         <br>
         initParam:${initParam.initName}
         <br>
         Accept-Language:${header["Accept-Language"]}
         <br>
         JSESSIONID:${cookie.JSESSIONID.name}-->${cookie.JSESSIONID.value}
         <br>
         <!-- 5.与输入有关的隐含对象:param,paramValues -->
         score:${param.score}
         <%-- 
         <%= request.getParameter("score") %>
         --%>
         <br>
         names:${paramValues.name[0].class.name}
         <%-- 
         <%
             request.getParameterValues("name")[0].getClass().getName();
          %>
          --%>
          <br>
          <!-- 4.隐含对象之与范围相关的:pageScope,requestScope,sessionScope,applicationScope -->
          time:${applicationScope.time.time}
          <%-- 
          <%= application.getAttribute("time") %>
          --%>
          <br>
          <!-- 3.EL可以进行自动类型转换 -->
          scope:${param.scope+11 }
          <br>
          scope:<%= request.getParameter("scope")+11 %>
          <br>
          <!-- 2.EL中的隐含对象 -->
          <%
             Customer cust2 = new Customer();
             cust2.setAge(28);
             request.setAttribute("customer", cust2);         
           %>
           age:${customer.age}
           <br>
           <!-- 1.EL的.或者[]运算符 -->
           age:${sessionScope.customer["age"]}
           <%--
           Customer customer = (Customer)session.getAttribute("customer");
           out.print(customer.getAge);
            --%>
  </body>
</html>
