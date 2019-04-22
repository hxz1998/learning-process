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
import com.mrhu.hibernate.topic2.*;

public class TestTopic2 {

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
	public void HQL_20_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.msgs is empty");

		for(Object o:q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "" + t.getTitle());
		}
		session.getTransaction().commit();
	}
	
	//like的使用，%代表0个或者多个，_代表一个
	@Test
	public void HQL_21_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.title like '%5'");

		for(Object o:q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "" + t.getTitle());
		}
		session.getTransaction().commit();
	}
	@Test
	public void HQL_22_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.title like '_5'");

		for(Object o:q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "" + t.getTitle());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void HQL_23_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where t.createDate < :date");
		q.setParameter("date", new Date());
		for(Object o:q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "" + t.getTitle());
		}
		session.getTransaction().commit();
	}
	
	//in和exists都可以用，但是
	//exists执行效率高
	@Test
	public void HQL_24_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("from Topic t where not exists (select m.id from Msg m where m.topic.id=t.id)");
//		Query q = session.createQuery("from Topic t where not exists (select m.id from Msg m where m.topic.id=t.id)") ;
		for(Object o:q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "" + t.getTitle());
		}
		session.getTransaction().commit();
	}
	
	//update用法
	@Test
	public void HQL_25_test() {
		testSave();
		session.beginTransaction();
		Query q = session.createQuery("update Topic t set t.title = upper(t.title)");
		q.executeUpdate();
		q = session.createQuery("from Topic");
		for(Object o:q.list()) {
			Topic t = (Topic)o;
			System.out.println(t.getId() + "" + t.getTitle());
		}
		session.getTransaction().commit();
	}
}



























