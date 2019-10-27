<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'application.jsp' starting page</title>
    
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
    if(request.getParameter("username") != null && request.getParameter("password") != null ){
         String strName = request.getParameter("username");
         String strPassword = request.getParameter("password");
         if("kyle".equals(strName) && "123456".equals(strPassword)){
                     application.setAttribute("Login", "one");
                     application.setAttribute("me", strName);
                     response.sendRedirect("Welcome.jsp");                   
            }else{
            out.print("请输入正确的密码 ");
            }    
    }
     %>
  </body>
</html>
