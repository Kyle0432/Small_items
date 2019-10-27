<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品搜索结果</title>
    
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
    <jsp:include page = "search.jsp"/>
        <%!
    public String Bytes(String str){
    try{
    String strOld = str;
    //把str转化成字节数组,进行编码
    byte[] strNew = strOld.getBytes("IS08859-1");
    //字节数组转化为字符串
    String bytes  = new String(strNew);
    return bytes;
      }catch(Exception e){
          return null;
      }    
    }
     %>
    <%
       Connection conn = null;
       Statement stmt  = null;
       ResultSet rsAll = null;
        try{
            String user = "root";
            String password = "mysqladmin";
            String jdbcUrl = "jdbc:mysql://localhost:3306/ebuy";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl, user, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String strItem = request.getParameter("item");
            String strContent = Bytes(request.getParameter("content"));
            String sql = "";
            if(strItem == null || strItem ==""){
              sql = "SELECT p_id,p_type,p_name,p_price,p_quantity,p_time FROM product";
            }else{
            sql = "SELECT p_id,p_type,p_name,p_price,p_quantity,p_time FROM product WHERE"
              +strItem.trim()+"LIKE '%"+strContent.trim()+"%'";
            }
            rsAll = stmt.executeQuery(sql);
        }catch(Exception e){
        e.printStackTrace();
        }
     %>
<table width="80%" border="1" cellpadding="0" align="center">
<tr>
     <td><font size="2" color="#0000FF">商品编号</font></td>
     <td><font size="2" color="#0000FF">商品名称</font></td>
     <td><font size="2" color="#0000FF">商品类别</font></td>
     <td><font size="2" color="#0000FF">商品价格</font></td>
     <td><font size="2" color="#0000FF">商品数量</font></td>
     <td><font size="2" color="#0000FF">商品日期</font></td>
</tr>
<%
   //str保存当前的页码
    String str = (String)request.getParameter("page");
    if(str == null){
      str = "0";
    }
    int pagesize = 10;//每页的记录的数量
    
    rsAll.last();//光标移到结果集最后一行
    int recordCount = rsAll.getRow();//取得结果集最后一行的行号,即为总记录数
    
    int maxPage = 0;//表示页数
    maxPage = (recordCount%pagesize == 0)?(recordCount/pagesize):(recordCount/pagesize+1);
    
    int currentPage = Integer.parseInt(str);//表示当前的页码
    if(currentPage < 1){  //如果页码为0,就自动默认为第一页
        currentPage = 1;
    }else{
        if(currentPage > maxPage){//如果页码大于实际页码就显示实际最大页码
           currentPage = maxPage;
        }
    }
    //absolute方法根据指定页码currentPage和每页记录数pagesize定位指定页起始记录
    rsAll.absolute((currentPage-1)*pagesize+1);//第一页码是1开始    第二页码是11开始......
    for(int i = 1 ; i <= pagesize;i++){
 %>
   <tr>
   <td><font size="2"><%= rsAll.getString("p_id") %></font></td>
   <td><font size="2"><%= rsAll.getString("p_name") %></font></td>
   <td><font size="2"><%= rsAll.getString("p_type") %></font></td>
   <td><font size="2"><%= rsAll.getFloat("p_price") %></font></td>
   <td><font size="2"><%= rsAll.getInt("p_quantity") %></font></td>
   <td><font size="2"><%= rsAll.getString("p_time") %></font></td>
   <td><a href="#"><font size="2">详情</font></a></td>
   <td><a href="#"><font size="2">购买</font></a></td>
   </tr>
   <%
    
      try{
       if(!rsAll.next()){
           break;
       }
      }catch(Exception e){
         e. printStackTrace();
       } 
      }
    %>
</table>
<p align="center"><font size="2">跳转到:
<input type="text" name= "page" size = "3"/>
当前页数:[<%=currentPage %>/<%=maxPage %>]&nbsp;
<%
   if(currentPage > 1){

 %>
<a href="search_result.jsp?page=1">第一页</a>
<a href="search_result.jsp?page=<%= currentPage-1%>">上一页</a>
<%
   }
    if(currentPage < maxPage) {
 %>
 <a href="search_result.jsp?page=<%=currentPage+1 %>">下一页</a>
 <a href="search_result.jsp?page=<%=maxPage %>">最后一页&nbsp;</a>
 
 <%
   }
    if(rsAll != null){
    rsAll.close();
    }
    if(stmt != null){
    stmt.close();
    }
    if(conn != null){
    conn.close();
    }
  %>
</font></p>
  </body>
</html>
