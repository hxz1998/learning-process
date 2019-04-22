# myhibernatelearning
hibernate学习
---

## Id生成策略
1. xml生成Id
	* generator
	* class常用四个：native，sequence，identify， uuid
2. @GeneratedValue
	* 自定义Id
	* AUTO
		* 默认：MySQL是auto_increment
		* Oracle是hibernate_sequence（名称固定）
	* IDENTITY
	* SEQUENCE
		* @SequenceGenerator
	* Table
		* TableGenerator
3. 联合主键（重写equals、hashCode方法，实现Serializable接口）
	* xml版本：composite-id
	* 注解版本：
		1. @Embeddable @Id
		2. @EmbeddedId
		3. @Id @IdClass
---

## Hibernate核心API
1. Configuration
	* 产生SessionFactory
2. SessionFactory
	* 使用单例
	* openSession每次打开都是新的
	* getCurrentSession从上下文找是否有可用的，如果没有创建新的
3. Session接口常用方法
	*三种状态（有没有Id，Id在数据库中有没有，Id在内存中有没有）
		1. transient：内存中一个对象，没有Id，缓存中也没有
		2. persistent：内存中有，有Id，缓存中也有，数据库中也有
		3. detached： 缓存中没有，内存中有，数据库中也有
	* save方法
	* delete方法
	* get和load方法
		* 三种状态不一样
		* load使用代理方式，不直接使用SQL语句来查询，当使用到对象时才使用SQL语句去查询
		* get直接使用SQL语句去查询过来对象
	* update方法
		* 对detached对象更新（有ID，不管是自己设定的还是从数据库中取出来的）
		* 更新完成之后成为persistent状态
		* 在persistent状态更新
		* 在仅仅需要更新一部分的时候使用HQL语句（常用）
	* saveOrUpdate方法
	* clear方法
		1. 无论是load还是get，都会首先查找缓存中有没有（一级缓存），如果没有，才会去数据库查找，调用clear方法强制清空session缓存
	* flush方法
		1. 强制进行从内存到数据库的同步
		2. flushMode
3. SchemaExport
	* 生成建表语句
---	

## 约束关系 （※代表重要程度）
1. 一对一单项外键关联
	* @OneToOne，@JoinColumn(name="表里面的字段自定义命名")
2. 一对一双向外键关联
	* @OneToOne(mappedBy="对方那里的属性")
	* 双向关联，必设 mappedBy
3. 一对一单项主键关联	
	* @PrimaryKeyJoinColumn
4. 一对一双向主键关联
	* @PrimaryKeyJoinColumn
5. 联合主键
	* @JoinColumns
6. 组件映射
	* @Embedded
7. 一对多单向关联 ※
	* @OneToMany
8. 多对一单向关联 ※
	* @ManyToOne
9. 多对多单向关联 ※
	* @ManyToMany
10. 多对多双向关联 ※
	* 在其中一边设置@ManyToMany(mappedBy="")
---

## 增删改查CURD
1. 两者之间有关联
	* 默认：两者保存时互不影响
	* 设置@ManyToOne的cascade属性(cascade对读取没影响，只有CUD)
	* 规律 
		>双向关系在程序中要设置双向关联
		>双向一定要设置mappedBy
	* cascade属性（不要太重视，只是省了一点点麻烦）
		1. Cascade指明了做什么操作时关联对象是绑定在一起的
		2. refresh = A里面需要读 B 改过后的数据
	* fetch属性：多的那一边默认是eager，少的那一边默认是lazy
		>不要两边都设置eager，否则会冗余
		>对多方设置fetch时候要谨慎，结合具体应用，一般用lazy不用eager。
2. ORM编程模型
	1. 映射模型
		* JPA Annotation
		* hibernate Annotation Extension
		* hibernate xml
		* JPA xml
	2. 编程接口
		* JPA
		* Hibernate
3. 删除对象的时候要先打破级联关系，设级联对象为 null，或者用HQL语句。如果不删除对应的记录，记录就成了垃圾数据
4. 想要删除或者更新，先做load，除了精确知道ID之外
5. 集合映射
	1. Set
	2. List
		* OrderBy
	3. Map		
		* MapKey
6. 继承映射(三种方式)
	1. 使用@Inheritance()，joined包内示例
7. 树状映射
	1. 重要！
	
```
@Entity
public class Org {
	private int id;
	private String name;
	private Set<Org> children = new HashSet<Org>();
	private Org parent;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="parent", cascade=CascadeType.ALL)
	public Set<Org> getChildren() {
		return children;
	}
	public void setChildren(Set<Org> children) {
		this.children = children;
	}
	@ManyToOne
	@JoinColumn(name="p_id")
	public Org getParent() {
		return parent;
	}
	public void setParent(Org parent) {
		this.parent = parent;
	}
}
```

```
@Test
public void testLoad() {
	testSave();
	session = sessionFactory.getCurrentSession();
	session.beginTransaction();
	Org o = session.get(Org.class, 1);
	print(o, 0);
	session.getTransaction().commit();
	
}
```

```
private void print(Org o, int level) {
	String preStr = "";
	for(int i = 0;i < level;i++) {
		preStr += "---";
	}
	System.out.println(preStr + o.getName());
	for(Org child : o.getChildren()) {
		print(child, level+1);
	}
}
```

>解决自动生成ID会混肴的方法：标注使用不同的SequenceGenerator

8. Hibernate查询（HQL）
	1. NativeSQL > HQL
	2. QL应该和导航关系结合，方便查询
	3. 用例：
		* from Class.Name -> 查询整个表，返回一个List
		* from Class.Name c where c.property >/=/<... 
		* from Class.Name c order by c.property asc(升序)
		* select distinct from Class.Name
		* 带参数的 --- from Class.Name c where c.property > :min and c.property <= :max -> setParameter("max", "...");
		* 分页操作--- from Class.Name c order by c.property asc -> query.setMaxResults(),query.setFirstResult();
		* select c.property1, c.property.2 from Class.Name c.order by c.property asc;
		* join操作---select t.title, c.name from Topic t join t.category c
		* 查询总数---select count(*) from Class.Name c;
		* like的使用---from Class.Name c where c.property like '%_';
		
		
9. 性能优化
	1. 注意session.clear()运用，尤其是在不断分页循环的时候
		* 在一个大集合中进行遍历
		* 另一种形式的内存泄露
	2. 1+N问题
	3. iterate
	4. 一级缓存二级缓存和三级缓存
		* 什么是缓存
		* 什么是一级缓存，session级别的缓存
		* 什么是二级缓存，SessionFactory级别的缓存，可以跨session存在
		* 打开二级缓存
			* hibernate.cfg.xml设定
			><property<br>
			>name="cache.use_second_level_cache">true</property><br>
			><property<br>
			>name="cache.provider_class">org.hibernate.cache.EhCacheProvider</property><br>
			* @Cache注解
		* 什么适合二级缓存
			1. 经常被访问
			2. 改动不会很大
			3. 数量有限
		* 测试环境：大量的重复查询，观察JUnit运行时间
		* 三级缓存：重复相同的查询
10. 数据库的事务隔离机制
	* read-commited
	
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	