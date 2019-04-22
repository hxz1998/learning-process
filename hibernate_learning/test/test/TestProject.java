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
	//Ū����һ���Ự�����ܲ����׵ģ�����Ҫ�õ���ģʽ�Ż�
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
		
		Project project = new Project(1, "Test", "����һ�����Ե�");
		session.save(project);
		
		Project project2 = new Project(2, "Test", "����һ�����Ե�");
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
