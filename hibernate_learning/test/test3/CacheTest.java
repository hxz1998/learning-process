package test3;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mrhu.hibernate.topic.Category;
import com.mrhu.hibernate.topic.Msg;
import com.mrhu.hibernate.topic.Topic;
import com.mrhu.hibernate.util.MySession;

public class CacheTest {
	
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
	public void testCache() {
		testSave();
		
		for(int i = 0;i < 10000;i++) {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Category c = session.load(Category.class, 1);
			System.out.println(c.getName());
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Category c2 = session.load(Category.class, 1);
			System.out.println(c2.getName());
			session.getTransaction().commit();
		}
	}

}























