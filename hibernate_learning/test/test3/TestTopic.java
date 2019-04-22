package test3;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mrhu.hibernate.util.MySession;
import com.mrhu.hibernate.topic.*;

public class TestTopic {

	private static SessionFactory sessionFactory = MySession.getSessionFactory();
	private static Session session = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		session = sessionFactory.getCurrentSession();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sessionFactory.close();
	}
	
	@Test
	public void testSave() {
		session.beginTransaction();
		for(int i = 0;i < 10;i++) {
			Category c = new Category();
			c.setName("c" + i);
			session.save(c);
		}
		
		for(int i = 0;i < 10;i++) {
			Category c = new Category();
			c.setId(1);
			Topic t = new Topic();
			t.setCategory(c);
			t.setTitle("t" + i);
			t.setCreateDate(new Date());
			session.save(t);
			
			Category c2 = new Category();
			c2.setId(2);
			Topic t2 = new Topic();
			t2.setCategory(c2);
			t2.setTitle("et" + i);
			t2.setCreateDate(new Date());
			session.save(t2);
		}
		
		for(int i = 0;i < 10;i++) {
			Topic t = new Topic();
			t.setId(1);
			Msg msg = new Msg();
			msg.setTopic(t);
			msg.setCont("msg" + i);
			session.save(msg);
		}
		
		session.getTransaction().commit();
		
		session = sessionFactory.getCurrentSession();
	}

	@Test
	public void HQL_01_test() {
		testSave();
		session.beginTransaction();
										//这里一定要写类名
		Query q = session.createQuery("from Category");
		List<Category> categories = q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void HQL_02_test() {
		testSave();
		session.beginTransaction();
										//这里一定要写类名
		Query q = session.createQuery("from Category c where c.name > 'c5'");
		List<Category> categories = q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void HQL_03_test() {
		testSave();
		session.beginTransaction();
										//这里一定要写类名					desc降序
		Query q = session.createQuery("from Category c order by c.name asc");
		List<Category> categories = q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void HQL_04_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("select distinct c from Category c order by c.name asc");
		List<Category> categories = q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void HQL_05_test() {
		testSave();
		session.beginTransaction();
//		Query q = session.createQuery("from Category c where c.id > :min and c.id <= :max");
//		q.setInteger("min", 6);
//		q.setInteger("max", 8);
		Query q = session.createQuery("from Category c where c.id > :min and c.id <= :max").setInteger("min", 6).setInteger("max", 8);
		List<Category> categories = q.list();
		for(Category c : categories) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
	}
	
	//分页操作
	@Test
	public void HQL_06_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Category c order by c.name asc");
		
		q.setMaxResults(8);
		q.setFirstResult(6);
		
		List<Category> categories = q.list();
		for(Category c : categories) {
			System.out.println(c.getId() + c.getName());
		}
		session.getTransaction().commit();
	}
	
	//取其中一些个属性
	@Test
	public void HQL_07_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("select c.id, c.name from Category c order by c.name asc");

		List<Object[]> categories = q.list();
		for(Object[] o : categories) {
			System.out.println(o[0] + " - " + o[1]);
		}
		session.getTransaction().commit();
	}
	
	//设定fetch type 为lazy后不发出第二条sql语句
	@Test
	public void HQL_08_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.category.id = 1");

		List<Topic> topics = q.list();
		for(Topic t : topics) {
			System.out.println(t.getTitle());
			System.out.println(t.getCategory().getName());
		}
		session.getTransaction().commit();
	}
	
	//DTO数据传输对象
	@Test
	public void HQL_09_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("select new com.mrhu.hibernate.topic.MsgInfo(m.id, m.cont, m.topic.title, m.topic.category.name) from Msg m");

		for(Object o : q.list()) {
			System.out.println(((MsgInfo)o).getCont());
		}
		
		session.getTransaction().commit();
	}
	
	//join
	@Test
	public void HQL_10_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("select t.title, c.name from Topic t join t.category c");

		for(Object o : q.list()) {
			Object[] m = (Object[])o;
			System.out.println(m[0] + "-" +m[1]);
		}
		
		session.getTransaction().commit();
	}
	
	//学习使用uniqueResult
	@Test
	public void HQL_11_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Msg m where m = :MsgToSerch");

		Msg m = new Msg();
		m.setId(1);
		q.setParameter("MsgToSerch", m);
		Msg result = (Msg) q.uniqueResult();
		System.out.println(result.getCont());
		session.getTransaction().commit();
	}
	
	//查询总数
	@Test
	public void HQL_12_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("select count(*) from Msg m");

		long count = (long)q.uniqueResult();
		System.out.println(count);
		session.getTransaction().commit();
	}
	
	@Test
	public void HQL_13_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Msg m where m.id between 3 and 5");

		for(Object o:q.list()) {
			Msg m = (Msg)o;
			System.out.println(m.getId() + "" + m.getCont());
		}
		
		session.getTransaction().commit();
	}
	
	@Test
	public void HQL_14_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Msg m where m.id in (3, 4, 5, 6)");

		for(Object o:q.list()) {
			Msg m = (Msg)o;
			System.out.println(m.getId() + "" + m.getCont());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void HQL_15_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Msg m where m.cont is not null");

		for(Object o:q.list()) {
			Msg m = (Msg)o;
			System.out.println(m.getId() + "" + m.getCont());
		}
		session.getTransaction().commit();
	}
}



























