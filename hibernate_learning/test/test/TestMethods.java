package test;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.mrhu.hibernate.model.Course;
import com.mrhu.hibernate.model.Student;
import com.mrhu.hibernate.model.StudentPK;
import com.mrhu.hibernate.model.Teacher;
import com.mrhu.hibernate.model.TeacherPK;
import com.mrhu.hibernate.util.MySession;

public class TestMethods {

	@Test
	public void testDelete() {
		Teacher t = new Teacher();
		TeacherPK pk = new TeacherPK();
		pk.setId(11);
		pk.setName("jjj");
		t.setPk(pk);
		
		SessionFactory sessionFactory = MySession.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(t);
		session.getTransaction().commit();
	}
	
	@Test
	public void testLoad() {
		Teacher t;
		TeacherPK pk = new TeacherPK();
		pk.setId(11);
		pk.setName("jjj");
		
		
		Student s;
		StudentPK pk2 = new StudentPK();
		pk2.setId(1);
		pk2.setName("jjj");
		
		Course c;
		
		SessionFactory sessionFactory = MySession.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
//		t = (Teacher)session.load(Teacher.class, pk);
//		s = (Student)session.load(Student.class, pk2);
		c = (Course)session.load(Course.class, 1);
//		System.out.println(s.getAge());
		System.out.println(c.getName());
		session.getTransaction().commit();
	}
	
	@Test
	public void testUpdate1() {
		
		Course c2;
		
		SessionFactory sessionFactory = MySession.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Course c = session.get(Course.class, 1);
		c2 = session.load(Course.class, 1);
		session.getTransaction().commit();
		
//		c.setName("jfdskl");	
		c2.setName("yyy");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.update(c2);
		session2.getTransaction().commit();
	}
	
	@Test
	public void testUpdate2() {
		
		Course c2;
		SessionFactory sessionFactory = MySession.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		c2 = session.load(Course.class, 1);
		
		c2.setName("iii");
		
		session.getTransaction().commit();

	}
	
	@Test
	public void testUpdate3() {
		
		SessionFactory sessionFactory = MySession.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
//		Query q = session.createQuery("update Project p set p.proName = 'QQQ' where p.Id = 1");
		Query q = session.createQuery("update Monkey m set m.name='mmm' where m.id = 1");
		q.executeUpdate();
		
		session.getTransaction().commit();

	}
	
	@Test
	public void testSchemaExport() {
		//API²»Ò»ÖÂ
	}

}
