<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//若可以获取到请求参数 name ,则打印出欢迎信息,把登录存储到Cookie中,并设置Cookie的最大时效为30-S
String name = request.getParameter("name");
if(name != null && !name.trim().equals("")){
	Cookie cookie = new Cookie("name",name);
	cookie.setMaxAge(30);
	response.addCookie(cookie);
}else{
	//从Cookie中读取用户信息,若存在则打印欢迎信息
	Cookie cookies[] = request.getCookies();
	if(cookies != null && cookies.length >0){
		for(Cookie cookie : cookies){
			String cookieName = cookie.getName();
			if("name".equals(cookieName)){
				String val = cookie.getValue();
				name = val;
			}
		}
	}
}
if(name != null && !name.trim().equals("")){
	out.print("Hello"+name);
}else{
	//若既没有请求参数,也没有Cookie,则重定向到Login.jsp
	response.sendRedirect("Login.jsp");
}
%>
</body>
</html>