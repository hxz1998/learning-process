# Vue.js学习
---
>官方教程地址：https://cn.vuejs.org/v2/guide/index.html

### 第一遍学习Vue.js
1. 实例化Vue
	```javascript
	var vm = new Vue({
		//选项
	})
	```
2. 文本插值
	```
	<span>Message: {{ message }}</span>
	var app = new Vue({
        el:'#app',
        data:{
            message:'hello vue!'
        }
    })
	```
3. data的json数据定义
	* 标准的json数据，
	* 注意数组与非数组时的符号使用[],{}

4. for循环
	* 我们用 v-for 指令根据一组数组的选项列表进行渲染。v-for 指令需要使用 item in items 形式的特殊语法，items 是源数据数组并且 item 是数组元素迭代的别名。
		```
		<ul id="example-1">
		  <li v-for="item in items">
		    {{ item.message }}
		  </li>
		</ul>
		var example1 = new Vue({
		  el: '#example-1',
		  data: {
		    items: [
		      { message: 'Foo' },
		      { message: 'Bar' }
		    ]
		  }
		})
		```
	* 一个对象的v-for
	
		```
		<ul id="v-for-object" class="demo">
		  <li v-for="value in object">
		    {{ value }}
		  </li>
		</ul>
		new Vue({
		  el: '#v-for-object',
		  data: {
		    object: {
		      firstName: 'John',
		      lastName: 'Doe',
		      age: 30
		    }
		  }
		})
		```
---
### 第二遍学习Vue.js
1. 计算属性 `Computed`


---

# 谨以此纪念自己ajax mui servlet Tomcat json学习历程
>以下经验的开发环境：
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
	* 浏览器报错：
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
	* MUI中不应该使用:`dataType:'json'`因为服务器传过来的是一个字符串这时候也就需要在前端将字符串解析为json格式
	* Servlet中应该使用：
        ```
        response.setContentType("text/json; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        ```
---	
时间：2018-02-11 



