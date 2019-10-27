<%@page import="com.kyle.struts2.tags.City"%>
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
    
    <title>My JSP 'form-tags.jsp' starting page</title>
    
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
         <s:debug></s:debug>
         <!-- 在服务的要显示回显要用集合  数组会无效 -->
         <%
            List<City> cities = new ArrayList<City>();
            cities.add(new City("1001","AA"));
            cities.add(new City("1002","BB"));
            cities.add(new City("1003","CC"));
            cities.add(new City("1004","DD"));
            cities.add(new City("1005","EE"));
            request.setAttribute("cities", cities);
          %>
       <!-- 1，用这种标签他会自动帮你把form表单排版好,总体和普通表单差不多
            2,可以对表单操作提交的值进行回显,从栈顶对象开始匹配属性,并把匹配的属性值赋值到对应标签value中
                                若栈顶对象没有对应的属性,则依次向下找对应的属性-->
        <s:form  action="save">
                 <s:hidden name="userId"></s:hidden>
                 <!-- 相当于原生form表单的文本框 -->
                 <s:textfield name="userName" label="userName"></s:textfield><!-- 表示也让密码进行回显 -->
                 <s:password name="userPassword" label="passWorld" showPassword="true"></s:password>
                 <s:textarea name="desc" label="Desc"></s:textarea>
                 <s:checkbox name="married" label="Married"></s:checkbox>
                 
                 <s:radio name="gender" list="#{'1':'Male','0':'Female'}" label="Gender"></s:radio>
                 <s:checkboxlist name="city" list="#request.cities" listKey="cityId" listValue="cityName"
                 label="City">
                 </s:checkboxlist>
                  <!-- 这里的name属性必须写,并且要与UserAction里的setxxx对应 -->
                 <s:select list="{1,2,3,4,5,6,7,8,9 }"
                 headerKey="" headerValue="请选择" name="age" label="Age">
                 <!-- 相当于二级菜单是select否子标签 -->
                  <s:optgroup label="10~15" list="#{11:11,12:12 }"></s:optgroup>
                  <s:optgroup label="15~20" list="#{16:16,17:17 }"></s:optgroup>
                 
                 </s:select>
                 <s:submit></s:submit>
       </s:form>
       
  </body>
</html>
