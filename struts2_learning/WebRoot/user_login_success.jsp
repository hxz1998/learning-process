<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_login_success.jsp' starting page</title>
    
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
  	用户登陆成功
  	<br>
  	<s:property value="#request.r1"/> | <%= request.getAttribute("r1") %> <br>
  	<s:property value="#session.s1"/> |　<%= session.getAttribute("s1") %> <br>
  	<s:property value="#application.a1"/> |　<%= application.getAttribute("a1") %> <br>
  	<s:debug></s:debug>
  	<br>
  	<h2>下面是关于向结果传参数的实验</h2><br>
  	<s:property value="#parameters.t"/> 
	<br>
	<s:debug></s:debug>
  	<br/>
  </body>
</html>
