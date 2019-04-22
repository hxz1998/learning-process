package test3;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mrhu.hibernate.concurrency.Account;
import com.mrhu.hibernate.util.MySession;

public class ConcurrencyTest {

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
	public void testConcurrency1() {
		session.beginTransaction();
		Account a = new Account();
		a.setBalance(100);
		session.save(a);
		session.getTransaction().commit();
	}
	
	//悲观锁
	@Test
	public void testPessimisticLock() {
		testConcurrency1();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Account a = session.load(Account.class, 1, LockMode.UPGRADE);
		int balance = a.getBalance();
		balance = balance - 10;
		a.setBalance(balance);
		session.getTransaction().commit();
		
	}
	
	
	//乐观锁，使用注解@Version
	@Test
	public void testOptimisticLock() {
		testConcurrency1();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Account a1 = session.load(Account.class, 1);
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Account a2 = session2.load(Account.class, 1);
		
		a1.setBalance(900);
		a2.setBalance(1100);
		
		session.getTransaction().commit();
//		System.out.println(a1.getVersion());
		
		session2.getTransaction().commit();
//		System.out.println(a2.getVersion());
		
	}
}


















