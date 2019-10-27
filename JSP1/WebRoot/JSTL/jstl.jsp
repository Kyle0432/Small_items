<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "shopping.Customer"  %>
<%@ page import = "java.util.List"  %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
 <h4>
		c:url 产生一个 url 地址. 可以 Cookie 是否可用来智能进行 URL 重写, 对 GET 请求的参数进行编码
		可以把产生的 URL 存储在域对象的属性中.
		还可以使用 c:param 为 URL 添加参数. c:url 会对参数进行自动的转码. 
		value 中的 / 代表的是当前 WEB 应用的根目录. 
	</h4>
	<c:url value="/test.jsp" var="testurl" scope="page">
		<c:param name="name" value="尚硅谷"></c:param>
	</c:url>
	
	url: ${testurl }
 
	<h4>
		c:redirect 使当前 JSP 页面重定向到指定的页面. 使当前 JSP 转发到指定页面可以使用
		<%--  
		<jsp:forward page="/test.jsp"></jsp:forward>	
		--%>
		/ 代表的是当前 WEB 应用的根目录. 
		
		response.sendRedirect("/test.jsp") / 代表 WEB 站点的根目录
	</h4>
	<%-- 
	<c:redirect url="http://www.atguigu.com"></c:redirect>
	<c:redirect url="/test.jsp"></c:redirect>
	--%>

<br><br>
<h4>⑦c:import可以包含任何页面到当前页面</h4>
<c:import url="www.baidu.com"></c:import>

<br><br>
<h4>⑥c:forTokens处理字符串的,类似于String的split()方法</h4>
<c:set value = "a,b,c,d,e,f" var = "test" scope= "request"></c:set>
<c:forTokens items="${requestScope.test }" delims="." var ="s" >
${s}
</c:forTokens>

<br><br>
<h4>⑤c:forEach可以对数组,Collection,Map进行遍历,begin(对于集合begin从0开始算),end,step</h4>
<c:forEach begin="1" end="10" step="3" var = "i">
     ${i}-----
</c:forEach>
<br><br>

<%
    List<Customer> custs = new ArrayList<Customer>();
    custs.add(new Customer("张三","aa","AA","11"));
    custs.add(new Customer("李四","bb","BB","22"));
    custs.add(new Customer("王五","cc","CC","33"));
    custs.add(new Customer("赵六","dd","DD","44"));
    custs.add(new Customer("田七","ee","EE","55"));
    request.setAttribute("custs", custs);
%>
<br><br>
<!-- 遍历Collection,遍历数组相同Collection -->
<c:forEach items="${requestScope.custs}" var="cust">
 ${cust.name}--${cust.cardType}--${cust.card}--${cust.address}
</c:forEach>
<br><br>
<!-- 遍历Map -->
<%
     Map<String,Customer> custMap = new HashMap<String,Customer>();
     custMap.put("a", new Customer("张三","AA","aa","11"));
     custMap.put("b", new Customer("李四","BB","bb","22"));
     custMap.put("c", new Customer("王五","CC","cc","33"));
     custMap.put("d", new Customer("赵六","DD","dd","44"));
     custMap.put("e", new Customer("田七","EE","ee","55"));
     request.setAttribute("custMap", custMap);
%>
 <br><br>
<c:forEach items="${requestScope.custMap}" var="cust">
${cust.key}--- ${cust.value.name}-${cust.value.cardType}-${cust.value.card}-${cust.address}<br>
</c:forEach>
<%
    String [] names = new String[]{"A","B","C"};
     request.setAttribute("names", names);
%>
<br><br>
<c:forEach items="${requestScope.names}" var="name">
${name}-----
</c:forEach>
<br><br>
	<h4>
		c:choose, c:when, c:otherwise: 可以实现 if...else if...else if...else 的效果. 但较为麻烦
		其中: c:choose 以 c:when, c:otherwise 的父标签出现.
		c:when, c:otherwise 不能脱离 c:choose 单独使用.
		c:otherwise 必须在 c:when 之后使用。 
	</h4>
<c:choose>
<c:when test="${param.age >60 }">老年</c:when>
<c:when test="${param.age >40 }">中年</c:when>
<c:when test="${param.age >18 }">成年</c:when>
<c:otherwise>未成年</c:otherwise>
</c:choose>
<c:set value="20" var="age" scope= "request"></c:set>


<br><br>
<h4>④c:if不能实现else操作,但是可以把结果储存起来</h4>
<c:if test="${param.age >18}">成年了！</c:if>
<br><br>
<c:if test="${param.age >18}" var = "isAdult" scope="request"></c:if>
isAdult:<c:out value="${requestScope.isAdult}"></c:out>

<br><br>
<h4>③c:remove移除指定域对象的指定属性值</h4>
<c:set value = "kyle" var = "name" scope = "session"></c:set>
name:${session.name}
<br><br>
<c:remove var="name" scope = "session"/>
name:--${sessionScope.name}--

<br><br>
<h4>②c:set 可以为域赋属性值,其中value属性支持···表达式,还可以为域对象中的JavaBean的属性赋值,target,value都支持EL表达式</h4>
<c:set var="name" value="Kyle" scope="page"></c:set>
<%--
 pageContext.setAttribute("name", "Kyle");
--%>
name:${pageScope.name}
<br><br>
<c:set var="subject" value="${param.submit}" scope="session"></c:set>
subject:${sessionScope.subject}
<br><br>
<%
   Customer cust = new Customer();
   cust.setName("呵呵呵");
   request.setAttribute("cust", cust);
%>
Name:${requestScope.cust.name}
<br><br>
<c:set target="${requestScope.cust}" property="name" value="${param.name}"></c:set>
Name:${requestScope.cust.name}
                                     <!--  param 相当于 getParameter  
                                                               而requestScope.name相当于 request.getAttribute("name")-->
<br><br>
<h4>① c:out可以对特殊字符进行转换</h4>
<%
  request.setAttribute("book", "<<Java>>");
%>
book: ${requestScope.book}
<br><br>
book:<c:out value="${requestScope.book}" default="booktitle"></c:out>
</body>
</html>