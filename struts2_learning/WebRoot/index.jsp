<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<h1>Struts2</h1>
	<br>
	<h2>动态方法绑定 DMI</h2>
	<a href="http://localhost:8080/Struts2_0100_Introduction/user/userAdd">添加用户</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/user/userABB!add">添加用户</a>
	<hr/>
	
	<h2>通配符绑定方法</h2>
	<a href="http://localhost:8080/Struts2_0100_Introduction/actions/Studentadd">添加学生</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/actions/Studentdelete">删除学生</a>
	<br>
	<a href="http://localhost:8080/Struts2_0100_Introduction/actions/Teacher_add">添加老师</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/actions/Teacher_delete">删除老师</a>
	<hr/>
	<h2>参数传递</h2>
	<a href="http://localhost:8080/Struts2_0100_Introduction/user/user!add?name=a&age=8">添加学生</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/user/user2!add?user.name=a&user.age=8">添加学生</a>
  	<a href="http://localhost:8080/Struts2_0100_Introduction/user/user3!add?user.name=a&user.age=8">添加学生</a>
  	<hr>
  	<h2>中文问题</h2>
  	<form action="user/user3!add" method="post">
  	姓名:<input type="text" name="name"></input>
  	<input type="submit" value="submit">
  	</form>
  	<hr>
  	<h2>登陆</h2>
  	<a href="http://localhost:8080//Struts2_0100_Introduction/login.jsp">登陆</a>
  	<hr>
  	<h2>result</h2>
	<a href="http://localhost:8080/Struts2_0100_Introduction/r/r1">页面重定向</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/r/r2">重定向</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/r/r3">链条重定向</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/r/r4">Action重定向</a>
	<hr>
	<h2>使用动态结果dynamicResult</h2>
	<a href="http://localhost:8080/Struts2_0100_Introduction/user/user5?type=1">1</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/user/user5?type=2">2</a>
	<hr>
	<h2>向结果传参数</h2>
	<a href="http://localhost:8080/Struts2_0100_Introduction/user/user6?type=2">向结果传参数</a>
	<hr>
	<a href="http://localhost:8080/Struts2_0100_Introduction/ognl/ognl?username=u&password=p">ognl1</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/ognl/ognl?username=u&password=p&user.age=1&user.name=2">ognl2</a>
	<a href="http://localhost:8080/Struts2_0100_Introduction/ognl/ognl?username=u&password=p&user.age=1&user.name=2&cat.friend.name=oudy">ognl2</a>
	</body>
</html>



















