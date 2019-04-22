# Spring学习项目

## IOC
---
```
依赖的jar包
    aspect2
    dbcp
    hibernate
    jdom
    junit4
    mysql
    pool2
    spring
    slf4j
```
1. 注入类型
	1. setter（重要）Setter-based dependency injection
	2. 构造方法注入 Constructor-based dependency injection
	3. beans.xml
2. id--VS--name
	* beans.xml
3. 简单属性的注入
	1. <property value=""/>
	2. UserDAOImpl
	3. 连接池需要
4. bean的scope属性
	1. singleton单例
	2. prototype原型
	3. 官方文档，scope
5. 集合注入
	1. 设置好set，get方法
	2. 在bean中设置好值
6. 自动装配
	* auto-wire
7. 生命周期
	* lazy-init
	* init-method,destory-method
8. 使用Annotation配置Spring
	1. 命名空间的配置
	2. <context:annotation-config></context:annotation-config>
	3. 学到的注解 
		1. @Autowired，默认是byType，当多个相同类型的type存在时，要和@Qualifier联合使用
		2. @Qualifier使用byName
		3. 如果使用Qualifier要写在set参数上
		4. @Resource,默认使用byName（name属性指定了从容器中找哪一个key符合的对象），找不到再使用byTpye
		5. @Component,初始化key默认是类名小写，value就是对象，一般要定义名字
		6. @Scope，@PostConstruct，@PreDestroy

---
## AOP

1. 动态代理
	* annotation包中相关示例及Loginterceptor类示例
2. AOP配置
	1. <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
	2. 导入相关的Aspect包
	3. 实例化@Aspect，如果定义了component-scan，那么要注解@component
	4. 织入点语法---Spring文档pointcut
	5. 奇葩方法：
        ```
        @Pointcut("execution(public * com.mrhu.spring.dao..*.*(..))")
        public void myMethod(){};
        @Before("myMethod()")
        //	@Before("execution(public void UserDAOImpl.save(User))")
        //	@Before("execution(public * com.mrhu.spring.dao..*.*(..))")
        public void before() {
            System.out.println("method start");
        }
        ```
---

## Spring整合hibernate

1. Spring整合hibernate
    1. Spring指定datasource（官方文档有误，应该是commons.dbcp2.BasicDataSource）
    2. 引入相关的包，dbcp2，pool2
    3. 根据官方文档配置bean
    4. 可以使用jdbc.properties+占位符的方式用单独文件配置
    5. 遇到的问题：
    	* Id使用GeneratedValue(strategy = GenerationType.AUTO)时，会报spring_sequence不存在，
    		* 解决方法：使用sGenerationType.IDENTITY解决
2. Spring相关的的注入
    1. 在DAO层注入SessionFactory，然后使用SessionFactory获取Session进行存储数据
    2. 在Service层注解@Transactional，将其事务交给Spring处理
        * Spring默认catch到RuntimeException就回滚事务
        * 配置文件中内容
        ```
           <bean id="txManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
               <property name="sessionFactory" ref="sessionFactory"/>
           </bean>
           <tx:annotation-driven transaction-manager="txManager"></tx:annotation-driven> 
        ```
    3. 注入方向：dataSource->sessionFactory->txManager,接下来所有的事务就交给txManager管理
4. Spring的TemplateMethod设计模式
5. HibernateTemplate，HibernateCallback，HibernateDaoSupport
	1. 设计模式：TemplateMethod
	2. 第一种：
		1. 在Spring中初始化HibernateTemplate，注入SessionFactory
		2. DAO里面注入HibernateTemplate
		3. save写getHibernateTemplate.save();
	2. 第二种：
		1. 从HibernateDaoSupport继承-->需要在配置文件中配置DAO，注入sessionFactory或者hibernateTemplate
			* 遇到的问题：
				1. 当在beans_spring_hibernate.xml配置文件中写成：
				```
				<bean name="logDAO" class="LogDAOImpl">
					<property name="sessionFactory" ref="sessionFactory"></property>
				</bean>
				```
				2. 在LogDAOImpl中写为：
				```
				this.getHibernateTemplate().save(log);//不会报-->java.lang.StackOverflowError异常
				//this.save(log);会报-->java.lang.StackOverflowError异常
				```
---
## Spring告一段落2018年2月16日17:43:33