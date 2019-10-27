<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import = "javax.servlet.http.Cookie" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cookie1.jsp' starting page</title>
    
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
   //获取Cookie
   Cookie cookies[] = request.getCookies();
   if(cookies != null && cookies.length>0){
    for(Cookie cookie:cookies){
    //获取Cookie的name和value
    out.print(cookie.getName()+":"+cookie.getValue());
    out.print("<br>");
      }
   }else{
   out.print("没有一个Cookie,正在创建并返回");
   //1.创建一个Cookie对象
   Cookie cookie = new Cookie("name","kyle");
   //setMaxAge: 设置Cookie的最大时效以秒为单位  若为0表示立即删除该Cookie
   //若为负数, 表示不存储该 Cookie, 若为正数, 表示该 Cookie 的存储时间. 
   cookie.setMaxAge(30);
   //2. 调用 response 的一个方法把 Cookie 传给客户端. 
   response.addCookie(cookie);
   }
    %>
  </body>
</html>
