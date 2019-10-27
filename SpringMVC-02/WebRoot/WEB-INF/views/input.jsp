<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'input.jsp' starting page</title>
    
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
         <form action="testConversionServiceConverer" method="POST">
                 <!-- lastName-email-gender-department.id 例如: GG-gg@kyle.com-0-105-->
                 Employee:<input type="text" name="employee"/>
                 <input type="submit" value="Submit"/>
         </form>
         <br><br>
    <!--  
		1. WHY 使用 form 标签呢 ?
		可以更快速的开发出表单页面, 而且可以更方便的进行表单值的回显
		2. 注意:
		可以通过 modelAttribute 属性指定绑定的模型属性,
		若没有指定该属性，则默认从 request 域对象中读取 command 的表单 bean
		如果该属性值也不存在，则会发生错误。
	-->
	
        <br><br> <!-- springmvc表单是一定自动回显的,因为目标添加页面不需要回显,
               所以设置modelAttribute="employee"然后在handler设置一个空的employee就不会回显了 -->
        <form:form action="${pageContext.request.contextPath}/emp" method="POST" modelAttribute="employee">
        
               <c:if test="${employee.id == null}">
                    <!-- path属性对应html表单标签的name属性值 -->
                    LastName:<form:input path="lastName"/>
                    <%--<form:errors>是用来显示校验错误消息的 --%>
                    <form:errors path="lastName"></form:errors>
               </c:if>
               <c:if test="${employee.id != null}">
                     <form:hidden path="id"/><!-- 此时lastName就没有了,lastName也就是没有提交,所以在Handler要用到ModelAttribute -->
                     <input type="hidden" name="_method" value="PUT"/>
               <%--对于_method不能使用form:hidden标签,因为modelAttribute对应的bean中没有_method这个属性 --%>
               </c:if>
        <br><br>
        Email:<form:input path="email"/>
        <form:errors path="email"></form:errors>
        <br><br>
        <%
          Map<String,String> genders = new HashMap();
          genders.put("1", "Male");
          genders.put("0", "Female");
        
          request.setAttribute("genders", genders);
         %>
         Gender
         <br>                      <!-- 这里将自动解析genders里面的内容 -->   
         <form:radiobuttons path="gender" items="${genders}"/>
         <br><br>   <!-- 支持级联属性 path="department.id",items可以是一个list map 或数组,-->
         Department:<form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"></form:select>
         <br><br>
         
        <!--  
			1. 数据类型转换
			2. 数据类型格式化
			3. 数据校验. 
			1). 如何校验 ? 注解 ?
			①. 使用 JSR 303 验证标准
			②. 加入 hibernate validator 验证框架的 jar 包
			③. 在 SpringMVC 配置文件中添加 <mvc:annotation-driven />
			④. 需要在 bean 的属性上添加对应的注解
			⑤. 在目标方法 bean 类型的前面添加 @Valid 注解
			2). 验证出错转向到哪一个页面 ?
			注意: 需校验的 Bean 对象和其绑定结果对象或错误对象时成对出现的，它们之间不允许声明其他的入参
			3). 错误消息 ? 如何显示, 如何把错误消息进行国际化
		-->
		Birth:<form:input path="birth"/>
		<form:errors></form:errors>
		<br><br>
		Salary:<form:input path="salary"/>
		<br><br>
		<input type="submit" value="Submit"/>
        </form:form>
        
  </body>
</html>
