package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mrhu.hibernate.model.Project;
import com.mrhu.hibernate.util.MySession;

public class TestProject {
	//弄出来一个会话工厂很不容易的，所以要用单例模式优化
//	private static SessionFactory sessionFactory= null;
	
//	@BeforeClass
//	public static void beforeClass() {
//		sessionFactory = new Configuration().configure().buildSessionFactory();
//	}
	
	@Test
	public void test() {
//		
//		Configuration cfg = new Configuration();
//		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = MySession.getSessionFactory().openSession();
		session.beginTransaction();
		
		Project project = new Project(1, "Test", "这是一个测试的");
		session.save(project);
		
		Project project2 = new Project(2, "Test", "这是一个测试的");
		project2.setDateTime(new Date());
		session.save(project2);
		
		session.getTransaction().commit();
		
		
		session.close();
		
	}
	
//	@AfterClass
//	public static void afterClass {
//		
//	}

}
