package test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mrhu.hibernate.model.Course;
import com.mrhu.hibernate.util.MySession;

public class CourseTest {

	@Test
	public void test() {
		SessionFactory sessionFactory = MySession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Course course = new Course();
		course.setName("fjf");
		session.save(course);
		session.getTransaction().commit();
		
	}

}
