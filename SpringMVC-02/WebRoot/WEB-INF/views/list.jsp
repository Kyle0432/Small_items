<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    <!--  
	SpringMVC 处理静态资源:
	1. 为什么会有这样的问题:
	优雅的 REST 风格的资源URL 不希望带 .html 或 .do 等后缀
	所以 DispatcherServlet 请求映射配置为 /拦截所以资源,包括静态资源, 
	则 Spring MVC 将捕获 WEB 容器的所有请求, 包括静态资源的请求, SpringMVC 会将他们当成一个普通请求处理, 
	因找不到对应处理器将导致错误。
	2. 解决: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler/>
-->
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    
             $(function(){
                   $(".delete").click(function(){
                      var href = $(this).attr("href");
                      $("form").attr("action",href).submit();//表示提交表单
                      return false;
                   });
             });
    
    </script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <!-- 通过jQuery对action进行填充 -->
        <form action="" method="POST">
        <!-- 在前面是超链接get请求而DELETE请求需要POST转换DELETE所以需要通过表单来进行转换 -->
            <input type="hidden" name="_method" value="DELETE"/>
        </form>
  
  
        <c:if test="${empty requestScope.employees}">
                                                       没有任何员工信息
        </c:if>
        <c:if test="${!empty requestScope.employees}">
                   <table border="1" cellpadding="10" cellspacing="0">
                          <tr>
                              <th>ID</th>
                              <th>LastName</th>
                              <th>Email</th>
                              <th>Gender</th>
                              <th>Department</th>
                              <th>Edit</th>
                              <th>Delete</th>
                          </tr>
                     <c:forEach items="${requestScope.employees }" var="emp">
                          <tr> 
                              <td>${emp.id}</td>
                              <td>${emp.lastName}</td>
                              <td>${emp.email}</td>
                              <td>${emp.gender == 0 ? "Female" : "Male"}</td>
                              <td>${emp.department.departmentName}</td>
                              <td><a href="emp/${emp.id}">Edit</a></td>
                              <td><a href="emp/${emp.id}" class="delete">Delete</a></td>
                          </tr>
                      </c:forEach>
                   </table>
        </c:if>
        <br><br>
        <a href="emp">Add New Employee</a>
  </body>
</html>
