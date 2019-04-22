package test3;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mrhu.hibernate.tree.Org;
import com.mrhu.hibernate.util.MySession;

public class TestTree {
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
		Org o1 = new Org();
		o1.setName("总公司");
		Org o2 = new Org();
		o2.setName("总公司下分公司1");
		Org o3 = new Org();
		o3.setName("总公司下分公司2");
		Org o4 = new Org();
		o4.setName("分公司1下部门1");
		Org o5 = new Org();
		o5.setName("分公司1下部门2");
		
		o1.getChildren().add(o2);
		o1.getChildren().add(o3);
		o2.getChildren().add(o4);
		o2.getChildren().add(o5);
		o4.setParent(o2);
		o5.setParent(o2);
		o2.setParent(o1);
		o3.setParent(o1);
		
		session.beginTransaction();
		session.save(o1);
		session.getTransaction().commit();
	}
	
	@Test
	public void testLoad() {
		testSave();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Org o = session.get(Org.class, 1);
		print(o, 0);
		session.getTransaction().commit();
		
	}

	private void print(Org o, int level) {
		String preStr = "";
		for(int i = 0;i < level;i++) {
			preStr += "---";
		}
		System.out.println(preStr + o.getName());
		for(Org child : o.getChildren()) {
			print(child, level+1);
		}
	}

}
