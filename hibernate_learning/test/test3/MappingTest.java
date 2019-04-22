package test3;

import static org.junit.Assert.*;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mrhu.hibernate.collection.mapping.Group;
import com.mrhu.hibernate.collection.mapping.User;
import com.mrhu.hibernate.model2.Husband;
import com.mrhu.hibernate.model2.Wife;
import com.mrhu.hibernate.util.MySession;

public class MappingTest {

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
	public void test() {
		SessionFactory sessionFactory = MySession.getSessionFactory();
	}
	
	@Test 
	public void testSaveUser() {
		User u = new User();
		u.setName("u1");
		Group g = new Group();
		g.setName("g1");
		u.setGroup(g);
		session.beginTransaction();
//		session.save(g);
		session.save(u);
		session.getTransaction().commit();
	}
	
	@Test 
	public void testSaveGroup() {
		User u = new User();
		u.setName("u1");
		User u2 = new User();
		u2.setName("u2");
		User u3 = new User();
		u3.setName("u3");
		
		Group g = new Group();
		g.setName("g1");
//		g.getUsers().add(u);
//		g.getUsers().add(u2);
//		g.getUsers().add(u3);
		u.setGroup(g);
		u2.setGroup(g);
		u3.setGroup(g);
		session.beginTransaction();
		session.save(g);
		session.getTransaction().commit();
	}
	
	@Test 
	public void testGetUser() {
		
		testSaveGroup();
		

		session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		User u = (User)session.get(User.class, 2);
//		u.getGroup().getName();
		session.getTransaction().commit();
		
	}
	@Test 
	public void testGetGroup() {
		
		testSaveGroup();
		

		session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		Group g = (Group)session.get(Group.class, 1);
		session.getTransaction().commit();
//		for(User u :g.getUsers()) {
//			System.out.println(u.getName());
//		}
		
	}	
	@Test 
	public void testUpdateUser() {
		testSaveGroup();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User u = (User)session.get(User.class, 2);
		u.setName("jjj");
		Group g = u.getGroup();
		g.setName("ggg");
		session.getTransaction().commit();
	}	
	@Test 
	public void testDeleteUser() {
		
		testSaveGroup();
		
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User u = (User)session.get(User.class, 2);
		
		//打破级联关系
		u.setGroup(null);
		
		session.delete(u);
		session.getTransaction().commit();
	}
	@Test 
	public void testDeleteGroup() {
		
		testSaveGroup();
		
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Group g= session.load(Group.class, 1);
		session.delete(g);
		
		session.getTransaction().commit();
	}
	@Test 
	public void testLoadGroupMap() {
		
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Group g= session.load(Group.class, 1);
		for(Map.Entry<Integer, User> entry : g.getUsers().entrySet()) {
			System.out.println(entry.getValue().getName());
		}
		
		session.getTransaction().commit();
	}
}















