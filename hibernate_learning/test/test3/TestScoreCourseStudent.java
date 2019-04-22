package test3;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mrhu.hibernate.util.MySession;
import com.mrhu.hibernate.coursescorestudent.*;

public class TestScoreCourseStudent {

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
		Student s = new Student();
		s.setName("zhangsan");
		Course c = new Course();
		Course c2 = new Course();
		c.setName("Java");
		c2.setName("C++");
		Score score = new Score();
		score.setStudent(s);
		score.setCourse(c);
		score.setScore(99);
		Score score2 = new Score();
		score2.setCourse(c2);
		score2.setStudent(s);
		score2.setScore(98);
		//下面两句不能执行
//		s.getCourses().add(c);
//		s.getCourses().add(c2);
		
		session.beginTransaction();
		session.save(s);
		session.save(c);
		session.save(c2);
		session.save(score);
		session.save(score2);
		session.getTransaction().commit();
	}
	@Test
	public void testLoad() {

		testSave();
			
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student s = session.load(Student.class, 1);
		for(Course c : s.getCourses()) {
			System.out.println(c.getName());
		}
		session.getTransaction().commit();
	}
}
