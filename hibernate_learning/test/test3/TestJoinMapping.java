package test3;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mrhu.hibernate.joined.Person;
import com.mrhu.hibernate.joined.Student;
import com.mrhu.hibernate.joined.Teacher;
import com.mrhu.hibernate.util.MySession;

public class TestJoinMapping {

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
	public void saveData() {
		Teacher t = new Teacher();
		t.setName("t1");
		t.setTitle("ttt");
		Person p = new Person();
		p.setName("p1");
		Student s = new Student();
		s.setName("s1");
		s.setScore("777");
		session.beginTransaction();
		session.save(p);
		session.save(t);
		session.save(s);
		session.getTransaction().commit();
	}
	
	@Test
	public void test() {
		saveData();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student s = session.load(Student.class, 3);
		System.out.println(s.getName()+s.getScore());
		session.getTransaction().commit();
	}

}
