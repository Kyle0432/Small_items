<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Welcome.jsp' starting page</title>
    
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
    String strLogin = (String)application.getAttribute("Login");
    String struser = (String)application.getAttribute("me");
    if(strLogin == null){
         out.print("<h2>请先登录,谢谢！</h2>");
         out.print("<h2>5秒后,自动跳转到登录页面</h2>");
         response.setHeader("Refresh","5; URL = Login.jsp");
       }else{
       if(strLogin.equals("one")){
          out.print(struser+"<h2>欢迎进入我们的网站！</h2>");
          out.print("Login:"+strLogin);
          out.print("me:"+struser);
           }else{
          out.print("<h2>请先登录,谢谢！</h2>");
          out.print("<h2>5秒后,自动跳转到登录页面</h2>");
          response.setHeader("Refresh","5; URL = Login.jsp");
           }
         }
     %>
  </body>
</html>
