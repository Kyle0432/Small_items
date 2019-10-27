<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
     <!-- 可知  默认情况下, Action 对象会被 Struts2 自动的放到值栈的栈顶.  -->
     <s:debug></s:debug>   
                     <!-- 此时是Test对象压入栈顶的对象的值 -->
        ProductName: ${productName }
        <br><br>         <!-- 此时就从第二个对象查找了   顶栈直接跳过了所以显示的是你输入文本框的值 -->
        ProductDesc: <s:property value="[1].productDesc"/>
        <br><br>
        ProductPrice: ${productPrice }
        <br><br>
        ProductName:^<s:property value="[0].productName"/>
        <br><br> <!-- 两者相同 -->
        ProductName:^^<s:property value="productName"/>
        <br><br>
        (EL)ProductName2:${sessionScope.product.productName }
        (EL)ProductName3:${requestScope.test.productName }
        <br><br>
        (OGNL)<s:property value="#session.product.productName"/>
        (OGNL)<s:property value="#request.test.productName"/>
        
        <!-- 调用对象栈中的一个方法为属性赋值 -->
        <s:property value="setProductName('Kyle')"/>
        <br><br>
        <s:property value="prductName"/>
        
        <!--调用数组对象的属性  -->
        <%
           String [] names = new String[]{"AA","BB","CC","DD"};
           request.setAttribute("names", names);
         %>
        length:<s:property value="#attr.names.length"/>
        <br><br>
        names[2]:<s:property value="#attr.names[2]"/>
        <!-- 调用集合 -->
        <%
          Map<String,String> map = new HashMap<String,String>();
           request.setAttribute("map", map);
           map.put("aaa", "AAA");
           map.put("bbb", "BBB");
           map.put("ccc", "CCC");
         %>
         size:<s:property value="#attr.map.size"/>
         <br><br>
         AAA:<s:property value="#atr.map['aaa']"/>
  </body>
</html>
