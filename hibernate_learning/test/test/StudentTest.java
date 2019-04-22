package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mrhu.hibernate.model.Student;
import com.mrhu.hibernate.model.StudentPK;

public class StudentTest {

	public static void main(String[] args) {
		StudentPK pk = new StudentPK();
		pk.setId(123);
		pk.setName("TTT");
		Student s = new Student();
		s.setPk(pk);
		s.setAge(100);
//		s.setName("Job");
		s.setDateTime(new Date());
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		session.save(s);
//		s.setAge(999);
//		session.update(s);
		session.getTransaction().commit();
//		
//		session.beginTransaction();
//		Student s2 = session.load(Student.class, 1);
//		System.out.println(s2.getName()+s2.getId());
//		session.getTransaction().commit();
		
		session.close();
		sf.close();
		
	}

}
