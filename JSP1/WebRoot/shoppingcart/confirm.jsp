<%@page import="shopping.Customer"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'confirm.jsp' starting page</title>
    
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
   Customer customer1 = (Customer)session.getAttribute("customer");
   String [] books   = (String []) session.getAttribute("books"); 
   %>
  <table>
        <tr>
            <td>顾客姓名:</td>
            <td><%= customer1.getName() %></td>
        </tr>
        <tr>
            <td>顾客地址:</td>
            <td><%= customer1.getAddress()  %></td>
        </tr>
        <tr>
            <td>顾客卡号:</td>
            <td><%= customer1.getCard() %></td>
        </tr>
        <tr>
            <td>卡号类型:</td>
            <td><%= customer1.getCardType() %></td>
        </tr>
         <tr>
             <td>Books</td>
             <td>
              <%
                for(String book:books){
                   out.print(book);
                   out.print("<br>");
                }
               %>
             </td>
         </tr>
  </table>
  </body>
</html>
