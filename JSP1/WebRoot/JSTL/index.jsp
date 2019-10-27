<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="shopping.Customer" import="java.util.List" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <%
      //模拟Servlet中的操作
      List<Customer> customers = new ArrayList<Customer>();
      customers.add(new Customer("张三","A","a","1"));
      customers.add(new Customer("李四","B","b","2"));
      customers.add(new Customer("王五","C","c","3"));
      customers.add(new Customer("赵六","D","d","4"));
      
      request.setAttribute("customers", customers);
      %>
      <jsp:forward page = "testtag.jsp"></jsp:forward>
</body>
</html>