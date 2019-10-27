<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品搜索</title>
    
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
    <form name = "form1" onsubmit  = "return check()" method = "post" action="search_result.jsp"> 
         <table width="80%" border="0" align="center" bgcolor="green">
         <tr bgcolor="blue">
         <th height="39" scope="row"><div align="left">
         <span style="font-weight: 400"><font size="2">查询项目:</font></span>
         </div></th>
         <td>
         <select name="item" size= "1">
         <option value="">请选择</option>
         <option value="p_type">p_type</option>
         <option value="p_id">p_id</option>
         <option value="p_name">p_name</option>
         </select>
         </td>
         <td><font  size= "2">查询内容:</font></td>
         <td><input type= "text" name="content"></td>
         <td><input type= "submit" name="submit" value="查询"></td>
         </tr>
         </table>
    </form>
  </body>
</html>
<script type="text/javascript">
function check(){
if(form1.content.value==""){
    alert("请输入查询内容！")
    form1.content.focus();
    return false;
}
}
</script>