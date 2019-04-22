<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    <title>My JSP 'ognl.jsp' starting page</title>
    
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
    <br>
   	访问值栈中普通属性：<s:property value="username"/><br>
   	访问对象的值（get和set方法）：<s:property value="user.age"/>|<s:property value="user.name"/>|<s:property value=""/><br>
   	访问值栈中普通属性:<s:property value="cat.friend.name"/><br>
   	访问值栈中对象的普通方法：<s:property value="password.length()"/>|<s:property value="cat.miaomiao()"/>\同时还可以访问action中的普通方法<br>
   	<hr>
   	访问静态方法：<s:property value="@com.mrhu.struts.ognl.S@s()"/><br>
   	访问静态属性：<s:property value="@com.mrhu.struts.ognl.S@string"/><br>
   	访问Math类的静态方法：<s:property value="@@max(2,3)"/>
   	<hr>
   	<ol>
   		<li>访问List:<s:property value="users"/></li>
		<li>访问List中某个元素：<s:property value="users[1]"/></li>
		<li>访问List中属性的集合：<s:property value="users.{age}"/></li>
		<li>访问List中属性的集合中的特定值：<s:property value="users[0].age"/></li>
		<li>访问Set：<s:property value="dogs"/></li>
		<li>访问Map：<s:property value="dogMap"/></li>
		<li>访问Map中某个元素：<s:property value="dogMap.dog101"/></li>
		<li>访问Map中所有的key：<s:property value="dogMap.keys"/></li>
		<li>访问Map中所有的value：<s:property value="dogMap.values"/></li>
		<li>访问容器大小：<s:property value="dogMap.size()"/></li>
   	</ol>
   	<ol>
   		<li><s:property value="users.{?#this.age==1}.{age}"/></li>
		<li><s:property value="users.{^#this.age>1}.{age}"/></li>
		<li><s:property value="users.{$#this.age>1}.{age}"/></li>
		<li><s:property value="users.{$#this.age>1}.{age} == null"/></li>   		
   	</ol>
   	
   	<ol>
   		<li><s:if test="#parameters.age < 20"/>too young</li>
   		<li><s:elseif test="#parameters.age >= 20">yeah</s:elseif>
   		<li><s:else>No</s:else></li>
   		<s:property value="#parameters.age"/>
   	</ol>
   	<s:debug></s:debug>
  </body>
</html>
