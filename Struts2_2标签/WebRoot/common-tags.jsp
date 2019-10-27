<%@page import="com.kyle.struts2.tags.Person"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.kyle.struts2.tags.PersonComparator" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'common-tags.jsp' starting page</title>
    
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
    <br>
    s:property  打印值栈中的属性值:对于对象栈,打印值栈中对应的属性
    <br><br>
    <s:property value="productName"/>
    <br><br>
    map栈:打印 request session application 的某个属性值 或某个请求参数的值
    <br><br>
    <s:property value="#session.date"/>
    <br><br>         <!-- 注意parameters是个数组 -->
    <s:property value="#parameters.name[0]"/>
    <br><br>
    
    s:url 创建一个 URL 字符串
    <br><br>
    <!-- 结果为: /Struts2_2标签/testUr -->
    <s:url value="/testUrl" var="url">
           <!-- 结果为:/Struts2_2标签/testUrl?productId=2002
                         因为1001不可能为属性名,struts2会把2002直接作为属性值所以OGNL会自动不去解析-->
           <s:param name="productId" value="2002"></s:param>
    </s:url> 
    ${url}
    <br><br>
    
    <s:url value="/testUrl" var="url1">
           <!-- 1001 
                   说明有个问题value里的productName会自动被OGNL解析-->
           <s:param name="productId" value="productName"></s:param>
    </s:url> 
    ${url1}
    <br><br>
    
    <s:url value="/testUrl" var="url2">
           <!-- 结果为:/Struts2_2标签/testUrl 什么也没有了
                          若不需要解析就在value里面加上单引号括起来,这样就会显示productId的value值来-->
           <s:param name="productId" value="'abcdef'"></s:param>
    </s:url> 
    ${url2}
    <br><br>
    
    <!-- 构建一个请求action的字符串 -->
    <s:url action="testAction" namespace="/helloworld" method="save" var="url3"></s:url>
    ${url3}
    <br><br>
     <!-- 结果为:testUrl?name=kyle  表示是否包含请求参数 是该请求方式的话就会显示你的请求参数-->   
    <s:url value="testUrl" var="url4" includeParams="get"></s:url>
    ${url4}
    <br><br>
    
    s:set  向page request session application 域对象中加入属性值
    <!-- 结果为:productName:CPU OGNL会自动解析  后面session等域对象类似做法 -->
    <s:set name="productName"value="productName" scope="request"></s:set>
    <br><br>
    productName:${requestScope.productName}
    <br><br>
    
    s:push 把一个对象在标签开始后压入到值栈中,标签结束后,弹出值栈
    <br><br>
    <% 
       Person per = new Person();
       per.setAge("10");
       per.setName("kyle");
       request.setAttribute("per", per);
     %>
     <s:push value="#request.per"><!-- 也可以 #request.per.name这样写 -->
              ${name}<!-- 显示结果为:kyle -->
     </s:push>
     <br><br>
     
     s:if else if else
     <br><br>
     <!-- 可以直接使用值栈中的属性 -->
     <s:if test="productPrice > 1000">
            I7处理器
     </s:if>
     <s:elseif test="productPrice > 600">
            I5处理器
     </s:elseif>
     <s:else>
            I3处理器
     </s:else>
     <br><br>
     
     s:iterator:遍历集合,把这个可遍历对象里的每一个元素可依次压入和弹出
     <br><br>
     <%
       List<Person> list = new ArrayList<Person>();
       list.add(new Person("CC","14"));
       list.add(new Person("AA","12"));
       list.add(new Person("BB","13"));
       request.setAttribute("list", list);
      %>
      <s:iterator value="#request.list">
                  ${name }--${age }<br>
      </s:iterator>
      <br><br>
      s:sort :可对集合中的元素进行排序
      <br><br>
      
      <%
       PersonComparator  pc = new PersonComparator();
       request.setAttribute("comparator", pc);
       %>
       <s:sort comparator="#request.comparator" source="list" var="list2"></s:sort>
       <s:iterator value="#attr.list2">
                   ${name }--${age }
       </s:iterator>
       <br><br>
       s:date 可以对date对象进行排版
       <br><br>
       <s:date name="#session.date" format="yyyy-MM-dd hh:mm:ss" var="date2"/>
       date2: ${date2}
  </body>
</html>
