# mystruts2learning
Struts2学习

### Struts2基础配置
	1. struts.xml配置文件
	
	```
	    <!-- 动态方法绑定注册 -->
	    <constant name="struts.enable.DynamicMethodInvocation" value="true" />
	    <!-- 继承于 struts-default的根目录，默认情况下是"/" -->
	    <package name="front" extends="struts-default">	
	    	<action name="hello" class="com.mrhu.struts.IndexAction" method="execute" >
			   	<!-- 可以不加name属性，默认为success -->
			   	<result name="success">
			   		/Hello.jsp
			   	</result>
	    	</action>
	    	
	    	<action name="index2" class="com.mrhu.struts.IndexAction1" method="execute">
	    		<result name="success">
	    			/Error.jsp
	    		</result>
	    	</action>
			<action name="index3" class="com.mrhu.struts.Test" method="execute">
	    		<result name="success">
	    			/index.jsp
	    		</result>
	    	</action>
	    </package>
	    <package name="user" extends="front" namespace="/user">
	    	<action name="userAdd" class="com.mrhu.struts.T0500.UserAction" method="add">
	    		<result>/UserAddSuccess.jsp</result>
	    	</action>
	    	<!-- 动态方法绑定，访问时使用actionName!methodName方式访问 -->
	    	<action name="userABB" class="com.mrhu.struts.T0500.UserAction">
	    		<result>/UserAddSuccess.jsp</result>
	    		<!-- 
	    			当不设置全局允许方法时需要额外对action进行指定方法
	    			struts2的2.5版本需要额外指定allowed-methods属性，为了增强安全性
	    		 -->
	    		<allowed-methods>add</allowed-methods>
	    	</action>
	    </package>
		<package name="actions" extends="front" namespace="/actions">
			<!-- 
				注册通配符的使用
				注意！
				约定优于配置原则
			-->
			<global-allowed-methods>regex:.*</global-allowed-methods>
			<action name="Student*" class="com.mrhu.struts.wildcard.StudentAction" method="{1}">
				<result>/Student{1}_success.jsp</result>
			</action> 
			<action name="*_*" class="com.mrhu.struts.wildcard.{1}Action" method="{2}">
				<result name="success">/{1}{2}_success.jsp</result>
				<result name="error">/{1}{2}_error.jsp</result>
			</action>
		</package>
	```
	
	2. web.xml配置文件
		
	```
	  <!-- 默认处理页面 -->
	  <welcome-file-list>
	    <welcome-file>index.jsp</welcome-file>
	  </welcome-file-list>
	  <!-- 拦截器 -->
	  <!-- START SNIPPET: filter -->
	    <filter>
	        <filter-name>action2</filter-name>
	        <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
	    </filter>
	    <!-- END SNIPPET: filter -->
	    <filter-mapping>
	        <filter-name>action2</filter-name>
	        <url-pattern>/*</url-pattern>
	    </filter-mapping>
	```
		
	3. struts2最小开发jar包
	![struts2最小开发jar包.png](http://upload-images.jianshu.io/upload_images/7364514-6abd7ef9145f1984.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

	4. 三种实现Action的方法
		1. 自己写一个可以返回String类型的方法
		2. 实现Action接口
		3. 继承于ActionSupport类（推荐）
	
### Action总结
	1. 实现一个Action最常用方式：从ActionSupport继承

	```
		import com.opensymphony.xwork2.ActionSupport;
		
		public class UserAction extends ActionSupport{
		    //返回String类型的值
			public String add() {
				return SUCCESS;
			}
		}
	```
	
	2. DMI动态方法调用   ！  在struts2.5以后需要指定
	
	```
		<!--在action中指定-->
		<allowed-methods>add</allowed-methods>
		<!--或者在package中指定-->
		<global-allowed-methods>add</global-allowed-methods>
	```
	
	3. 通配符配置    * 在2.5版本以后需要在package中声明
	
	```
		<global-allowed-methods>regex:.*</global-allowed-methods>
	```
	
	4. 接收参数的方法（一般使用属性或者DomainModel来接收）
		```
		//属性方法
		import com.opensymphony.xwork2.ActionSupport;
		
		public class UserAction extends ActionSupport{
			private String name;
			private int age;
			
			public String add() {
				System.out.println("Name:"+name);
				System.out.println("Age:"+age);
				return SUCCESS;
			}
			
			/**
			 * @return the name
			 */
			public String getName() {
				return name;
			}
			/**
			 * @param name the name to set
			 */
			public void setName(String name) {
				this.name = name;
			}
			/**
			 * @return the age
			 */
			public int getAge() {
				return age;
			}
			/**
			 * @param age the age to set
			 */
			public void setAge(int age) {
				this.age = age;
			}
			
		}
		
		```
		
		```
		//DomainModel方法
		import com.opensymphony.xwork2.ActionSupport;
		
		public class UserAction extends ActionSupport{
			private User user;
			
			public String add() {
				System.out.println(user.getAge());
				System.out.println(user.getName());
				return SUCCESS;
			}
		
			/**
			 * @return the user
			 */
			public User getUser() {
				return user;
			}
		
			/**
			 * @param user the user to set
			 */
			public void setUser(User user) {
				this.user = user;
			}
			
		}
	
		//支持DomainModel的模型类
		public class User {
			private int age;
			private String name;
			/**
			 * @return the age
			 */
			public int getAge() {
				return age;
			}
			/**
			 * @param age the age to set
			 */
			public void setAge(int age) {
				this.age = age;
			}
			/**
			 * @return the name
			 */
			public String getName() {
				return name;
			}
			/**
			 * @param name the name to set
			 */
			public void setName(String name) {
				this.name = name;
			}
			
		}
		```
	5. 简单的参数验证  addFieldError（一般不用struts2的UI标签）
		* JSP页面用来取出数据
		
		```
		    <h2>数据验证</h2>
			用户添加错误
			<s:fielderror fieldName="name"></s:fielderror>
			<br><s:property value="errors.name"/>
			<s:debug></s:debug>
		```
		
		* 对应的Action
		```
			import com.opensymphony.xwork2.ActionSupport;
			
			public class UserAction extends ActionSupport{
				
				private String name;
				
				public String add() {
					if(name == null || !name.equals("admin")){	
						this.addFieldError("name", "你的用户名是不正确的！");
						return ERROR;
					}
					return SUCCESS;
				}
			
				/**
				 * @return the name
				 */
				public String getName() {
					return name;
				}
			
				/**
				 * @param name the name to set
				 */
				public void setName(String name) {
					this.name = name;
				}
			}
		```
	6. 访问Web元素
		* Map类型
		  * IoC
		  * 依赖于Struts容器
		* 原始类型
		  * Ioc
		  * 依赖于Struts容器
		```
		//依赖于容器
		import java.util.Map;
		
		import com.opensymphony.xwork2.ActionContext;
		import com.opensymphony.xwork2.ActionSupport;
		
		public class LoginAction extends ActionSupport{
			private Map request;
			private Map session;
			private Map application;
			
			public LoginAction1() {
				request = (Map)ActionContext.getContext().get("request");
				session = ActionContext.getContext().getSession();
				application = ActionContext.getContext().getApplication();
			}
			
			public String execute() {
				request.put("r1", "r1");
				session.put("s1", "s1");
				application.put("a1", "a1");
				if(session == null) {
					System.out.println("Hello");
				}
				System.out.println(session);
				return SUCCESS;
			}
			
		}
		```

		```
		<!--依赖于容器的JSP页面-->
		<s:property value="#request.r1"/> | <%= request.getAttribute("r1") %> <br>
		<s:property value="#session.s1"/> |　<%= session.getAttribute("s1") %> <br>
		<s:property value="#application.a1"/> |　<%= application.getAttribute("a1") %> <br>
		<s:debug></s:debug>
		```
		
		IoC实现
		
		```
		import java.util.Map;
		
		import org.apache.struts2.interceptor.ApplicationAware;
		import org.apache.struts2.interceptor.RequestAware;
		import org.apache.struts2.interceptor.SessionAware;
		
		import com.opensymphony.xwork2.ActionSupport;
		
		public class LoginAction2 extends ActionSupport implements RequestAware, SessionAware, ApplicationAware{
		
			private Map<String, Object> request;
			private Map<String, Object> session;
			private Map<String, Object> application;
			
			public String execute() {
				request.put("r1", "r1");
				session.put("s1", "s1");
				application.put("a1", "a1");
				return SUCCESS;
			}
			
			@Override
			public void setApplication(Map<String, Object> application) {
				this.application = application;
			}
		
			@Override
			public void setSession(Map<String, Object> session) {
				this.session = session;
			}
		
			@Override
			public void setRequest(Map<String, Object> request) {
				this.request = request;
			}
			
		}
		```
		
	7. 包含文件配置
	
	```
	<include file="struts2-mydefaction.xml"></include> 
	```
	
	8. 默认Action处理
	
	```
	<default-action-ref name="index"></default-action-ref>
	<action name="index">
		<result>
			/index.jsp
		</result>
	</action>
	```
	
---

### OGNL表达式
	1. user.xxx只有传，才会构造。同时还必须要提供参数 为空的构造方法。
	2. 详情见ognl包中的示例和ognl.jsp
---

### 标签
	空，需要时再看*
---

### 命名规范（原则：简单就是美）
	* 数据库命名
		1. 库名：项目名
		2. 表命命名：_TableName(下划线+驼峰标识的mode名)
		2. 字段命名：保持和属性名一致
	* 类及文件命名
		1. 用层来分包：com.xxx.service/manager/bean/model
		2. Action都以Action结尾
		3. JSP命名，使用 *-* 配置
	* 配置文件
		1. 前台命名 /
		2. 后台命名 /admin
	
### 项目实战采用其他方式（当下流行的后台UI框架）

---
### 2018年2月11日14:43:49 更新 
	1. 将servlet和struts2共存，重新定义拦截器
	2. 规范化readme.md文档
