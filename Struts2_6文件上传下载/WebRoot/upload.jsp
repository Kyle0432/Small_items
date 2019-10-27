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
    
    <title>My JSP 'upload.jsp' starting page</title>
    
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
        <s:form action="testUpload" method="POST" enctype="multipart/form-data">
                <s:file name="ppt" label="PPT"></s:file>
                <s:textfield name="pptDesc[0]" label="PPTDesc"></s:textfield>
                
                <s:file name="ppt" label="PPT"></s:file>
                <s:textfield name="pptDesc[1]" label="PPTDesc"></s:textfield>
                
                <s:file name="ppt" label="PPT"></s:file>
                <s:textfield name="pptDesc[2]" label="PPTDesc"></s:textfield>
                <s:submit></s:submit>
        </s:form>
  </body>
</html>
