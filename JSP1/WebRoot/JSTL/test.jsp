<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "shopping.Customer"%>
<%@ page import = "java.util.List" %> 
<%@ page import ="java.util.ArrayList"%>   
    <!-- 导入标签库的文件 -->
<%@ taglib uri="http://www.atguigu.com/mytag/core" prefix="Kyle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <Kyle:printUpper time="10">I Love you</Kyle:printUpper>
      <br><br>
      <Kyle:testJspFragment>Hello:${param.name}</Kyle:testJspFragment>
      <br><br>
      <Kyle:ReadFile src="/WEB-INF/note3.txt"/>
      <br><br>
      <Kyle:Max num2="${param.a}" num1="${param.b}"/>
      <br><br>
      <Kyle:hello value="${param.name}" count="10"/>
       

      <br><br>
      <%
       List<Customer> customers = new ArrayList<Customer>();
       customers.add(new Customer("张三","江西","1","A"));
       customers.add(new Customer("李四","江西","2","B"));
       customers.add(new Customer("王五","江西","3","C"));
       customers.add(new Customer("赵六","江西","4","D"));
       request.setAttribute("customers", customers);      
      %>
      <Kyle:ForEach items="${requestScope.customers}" var="cust">
      --${cust.name}--${cust.address}--${cust.cardType}--${cust.card}<br>
      </Kyle:ForEach>
      
      <br><br>
      
      <Kyle:parentTag>
      	<!-- 子标签以父标签的标签存在,子标签把父标签的name属性打印到Jsp页面上-->
      <Kyle:sonTag/>
      </Kyle:parentTag>
      
      
      <br><br>
      
      <Kyle:choose>
      <Kyle:when test="${param.age>18}">大学</Kyle:when>
      <Kyle:when test="${param.age>13}">中学</Kyle:when>
      <Kyle:otherwise>小学</Kyle:otherwise>
      </Kyle:choose>
      
      
      
</body>
</html>