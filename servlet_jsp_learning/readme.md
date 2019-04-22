# Servlet和JSP学习
---
## 编写Servlet和配置Servlet
1. Servlet要继承自HttpServlet，同时要重写其中的一些个方法如：doGet，doPost，默认情况下直接在浏览器地址栏中访问使用的是get方法
2. 配置servlet
  * 使用注解
  * 使用web.xml
3. 部署配置
  * 目录
  * WEB-INF目录下的是对外界不可直接访问的目录
  * classes 编译好的类文件
  * lib 库文件，目录名称不可变
  * 导出为 war 文件，然后放到Tomcat的webapp目录下，重启Tomcat后自解压
---
## 请求与响应
1. HttpServletRequest
	* getParameter-->获取单个参数
	* getParameterValues-->获取多个同一name的参数
	
未完待续
   
