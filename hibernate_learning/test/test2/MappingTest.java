package test2;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void testOnToOne() {
		SessionFactory sessionFactory = MySession.getSessionFactory();
	}

}