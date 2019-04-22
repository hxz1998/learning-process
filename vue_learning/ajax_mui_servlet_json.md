# 谨以此纪念自己ajax mui servlet Tomcat json学习历程
>以下经验的生产环境：
>1. 框架：mui V3.7.0
>2. 框架：ajax使用mui封装产品
>3. 框架：Vue.js V2.5.13
>4. 工具：Tomcat V9.0
>5. 工具：Hbuilder V9.0.1.201802011934
>6. 工具：MyEclipse2017
>7. 工具：Firefox V58.0.1
>8. 工具：Microsoft Edge 38.14393.1066.0

---
1. 关于跨域请求被拒绝
	* 状况
		```
		XMLHttpRequest cannot load  *
		Origin http://** is not allowed by Access-Control-Allow-Origin.
		```
	* 解决方法：
		* 在Servlet拦截器中配置(自己写拦截器实现)
		
			```
			public class CrosFilter implements Filter {
				@Override
				public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain) throws IOException, ServletException {
					HttpServletResponse response = (HttpServletResponse)rsp;
					HttpServletRequest request = (HttpServletRequest)req;
					response.setHeader("Access-Control-Allow-Origin", "*"); 
			        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");  
			        response.setHeader("Access-Control-Max-Age", "3600");  
			        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, accept, Content-Type");  
			        response.setHeader("Access-Control-Allow-Credentials", "true");
			        //下面这句非常重要
			        chain.doFilter(req, rsp);
				}
			}
			```
		
		* 在web.xml中配置使用拦截器
	
	```
	<filter>
   		<filter-name>cors</filter-name>
		<filter-class>com.mrhu.struts.util.CrosFilter</filter-class>
   	</filter>
   	<filter-mapping>
   		<filter-name>cors</filter-name>
   		<url-pattern>/servlet/*</url-pattern>
   	</filter-mapping>
	```

2. 请求约定
	* MUI中不应该使用:
	
	>dataType:'json'<br>
	因为服务器传过来的是一个字符串<br>
	这时候也就需要在前端将字符串解析为json格式
	
	* Servlet中应该使用：
	
	>response.setContentType("text/json; charset=utf-8");
	>response.setCharacterEncoding("utf-8");
	
---	
时间：2018-02-11 

