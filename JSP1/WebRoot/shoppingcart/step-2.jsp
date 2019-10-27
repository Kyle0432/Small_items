<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'step-2.jsp' starting page</title>
    
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
    <h4>Step2:请输入寄送地址和信用卡信息</h4>
    <form action="<%= request.getContextPath()%>/processStep2" method="post">
    <table border="1" cellpadding= "10" callspacing="0">
    <tr>
         <td colspan="2">寄送信息</td>
    </tr>
     <tr>
         <td>姓名:</td>
         <td><input type="text" name="name"/></td>
    </tr>
     <tr>
         <td>寄送地址:</td>
         <td><input type = "text" name="address"/></td>
    </tr>
     <tr>
        <td colspan="2">信用卡信息</td>
    </tr>
     <tr>
       <td>种类:</td>
       <td>
           <input type= "radio" name = "cardType" value="Visa"/>Visa
           <input type= "radio" name = "cardType" value="Master"/>Master
       </td>
    </tr>
    <tr>
        <td>卡号:</td>
        <td>
        <input type= "text" name = "card"/>
        </td>
    </tr>
    <tr>
    <td colspan="2"><input type="submit" value="Submit"/></td>
    </tr>
    </table>
    </form>
  </body>
</html>
