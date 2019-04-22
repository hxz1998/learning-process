<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
	<h2>取得Request/Response/Session，HttpServletRequest,HttpServletResponse,ServletContext的引用</h2>
	<form name="f" id="f" action="" method="post">
		用户名：<input name="name" type="text"><br>
		密    码：<input type="password" name="password">
		<br>
		<input type="button" onclick="submitData(1)" value="Submit1">
		<input type="button" onclick="submitData(2)" value="Submit2">
		<input type="button" onclick="submitData(3)" value="Submit3">
		<input type="button" onclick="submitData(4)" value="Submit4">   
	</form>  
  
  <script>
  	function submitData(index) {
  		var oBtn = document.getElementById('f');
		switch(index) {
		case 1: oBtn.action="login/login1";oBtn.submit(); break;
		case 2: oBtn.action="login/login2";oBtn.submit(); break;
		case 3: oBtn.action="login/login3";oBtn.submit(); break;
		case 4: oBtn.action="login/login4";oBtn.submit(); break;
		}
  	}
  </script>
  </body>
</html>






















