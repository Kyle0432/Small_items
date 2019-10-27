<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'details.jsp' starting page</title>
    
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
  
        ProductId:  ${productId } 
        <br><br>
        ProductName: ${productName }
        <br><br>
        ProductDesc: <%=request.getAttribute("productDesc")%>
        <br><br>
        ProductPrice: ${productPrice }
        
            <%--${productDesc }和<%=request.getAttribute(productDesc) %>
                             是一样的结果 ,也就是说在{productDesc }里面隐藏了requestScope,这就是
            struts2配置所完成否 --%>
  </body>
</html>
