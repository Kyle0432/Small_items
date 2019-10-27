<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emp-list.jsp' starting page</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    
    $(function(){
       //1,点击delete时,弹出 确定是要删除xx的信息吗？ 若确定,执行删除,若不确定,则取消
       $(".delete").click(function(){
           var lastName = $(this).next(":hidden").val();
           var flag = confirm("确定要删除"+lastName+ "的信息吗？");
           if(flag){
                    var $tr = $(this).parent().parent();
                    //删除,使用ajax的方式,这里的url表示是emp-delete?id=${id}(访问路径)
                    //也就是Ajax请求的目标URL
                    var url = this.href;
                    //这里的args传递的参数表示去掉缓存的,json格式
                    var args = {"time":new Date()};
                    //$.post表示jQuery对Ajax操作进行了封装,在jQuery中的方法是$.post
                    //function:回调函数:当响应结束时,回调函数被触发,响应结果在data中
                    //data:表示响应成功后的数据,可能是 HTML、XML、Json
                    (url,args,function(data){
                       //若data的返回值为1,则提示 删除成功,且把当前行删除
                       if(data == "1"){
                         alert("删除成功");
                         $tr.remove();
                       }else{
                         //若data的返回值不是1,提示删除失败
                         alert("删除失败");
                       }
                    
                    });
               };
               //取消超链接的默认行为
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
        <h4>Employee List Page</h4>
        
        <s:if test="#request.employees == null || #request.employees.size() == 0">
              <b>没有任何员工信息</b>
        </s:if>
        <s:else>
             <table border="1" cellpadding="10" cellspacing="0">
                <tr>
                     <td>ID</td>
                     <td>LASTNAME</td>
                     <td>EMAIL</td>
                     <td>BIRTH</td>
                     <td>CREATETIME</td>
                     <td>DEPT</td>
                     <td>DELETE</td>
                     <td>EDIT</td>
                </tr>
                <s:iterator value="#request.employees">
                     <tr>
                         <td>${id}</td>
                         <td>${lastName}</td>
                         <td>${email}</td>
                         <td>
                            <s:date name="birth" format="yyyy-MM-dd"/>
                         </td>
                         <td>
                            <s:date name="birth" format="yyyy-MM-dd hh:mm:ss"/>
                         </td>
                         <td>${department.departmentName}</td>
                         <td>
                             <a href="emp-delete?id=${id}" class="delete">DELETE</a>
                             <input type="hidden" value="${lastName}"/>
                         </td>
                         <td>
                            <a href="emp-input?id=${id}">Edit</a>
                         </td>
                     </tr>
                </s:iterator>
             </table>
        </s:else>
  </body>
</html>
