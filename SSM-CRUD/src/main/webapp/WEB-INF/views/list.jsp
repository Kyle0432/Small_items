<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工列表页面</title>
    <%
       pageContext.setAttribute("APP_PATH",request.getContextPath());
     %>
    <!-- 
       Web路径:
                不以/开始的相对路径,找资源,以当前资源的路径为基准，经常容易出问题
                以/开始的相对路径,找资源,以服务的路径为基准(http://localhost:8080),需要加上项目名
       http://localhost:8080/crud
     -->
    <!-- 引入BootStrap样式 -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入js -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <!-- 引入jQuery -->
    <script type="text/javascript" src="${APP_PATH}/static/scripts/jquery-1.12.3.js"></script>
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
        <!-- Bootstrap搭建显示页面 -->
        <div class="conatiner">
             <!--①标题 -->
             <div class="row">
                  <div class="col-md-12">
                      <h1>SSM_CRUD</h1>
                  </div>
             </div>
             <!-- ②按钮 -->
             <div class="row">
                  <div class="col-md-4 col-md-offset-8">
                       <button class="btn btn-primary">新增</button>
                       <button class="btn btn-danger">删除</button>
                  </div>
             </div>
             <!-- ③显示表格数据 -->
             <div class="row">
                 <div class="col-md-12">
                      <table class="table table-hover">
                          <tr>
                             <th>#</th>
                             <th>lastName</th>
                             <th>email</th>
                             <th>gender</th>
                             <th>deptName</th>
                             <th>操作</th>
                          </tr>
               <c:forEach items="${PageInfo.list }" var="emp">
                          <tr>
                             <th>${emp.empId}</th>
                             <th>${emp.empName}</th>
                             <th>${emp.email}</th>
                             <th>${emp.gender == "F" ? "男" : "女"}</th>
                             <th>${emp.department.deptName}</th>
                             <th>
                                <button class="btn btn-primary btn-group-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                                              新增
                                </button>
                                <button class="btn btn-danger btn-group-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                                                             删除
                                </button>
                             </th>
                          </tr>
               </c:forEach>
                      </table>
                 </div>
             </div>
             <!-- ④显示分页信息栏 -->
             <div class="row">
               <!-- 分页文字信息 -->
               <div class="col-md-6">
                                     当前第${PageInfo.pageNum}页,总共${PageInfo.pages},总共${PageInfo.total}条记录	
               </div>
          			<!-- 分页条信息 -->
				<div class="col-md-6">
					<nav aria-label="Page navigation">
					<ul class="pagination">
						<li><a href="${APP_PATH }/emps?pn=1">首页</a></li>
						<c:if test="${PageInfo.hasPreviousPage }">
							<li><a href="${APP_PATH }/emps?pn=${PageInfo.pageNum-1}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach items="${PageInfo.navigatepageNums }" var="page_Num">
							<c:if test="${page_Num == PageInfo.pageNum }">
								<li class="active"><a href="#">${page_Num }</a></li>
							</c:if>
							<c:if test="${page_Num != PageInfo.pageNum }">
								<li><a href="${APP_PATH }/emps?pn=${page_Num }">${page_Num }</a></li>
							</c:if>
	
						</c:forEach>
						<c:if test="${PageInfo.hasNextPage }">
							<li><a href="${APP_PATH }/emps?pn=${PageInfo.pageNum+1 }"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
						<li><a href="${APP_PATH }/emps?pn=${PageInfo.pages}">末页</a></li>
					</ul>
					</nav>
				</div>
             </div>
        </div>
  </body>
</html>
