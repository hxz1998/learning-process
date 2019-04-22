package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mrhu.hibernate.model.Teacher;
import com.mrhu.hibernate.model.TeacherPK;
import com.mrhu.hibernate.model.ZhiCheng;

public class TeacherTest {

	public static void main(String[] args) {
		TeacherPK pk = new TeacherPK();
		pk.setId(11);
		pk.setName("jjj");
		Teacher t = new Teacher();
		t.setTitle("中级");
//		t.setName("t1");
		t.setZhiCheng(ZhiCheng.A);
		t.setPk(pk);
		
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		
		//Session session = sf.openSession();
		Session session = sf.getCurrentSession();
		
		System.out.println(t.getPk().getId());

		session.beginTransaction();
		System.out.println(session.save(t));
		
//		session.delete(t);
//		session.update(t);
		System.out.println(t.getPk().getId());
		Session session2 = sf.getCurrentSession();
		
		//判断是否两个session是否相同
		System.out.println(session == session2);
		session.getTransaction().commit();
		
		System.out.println(t.getPk().getId());
		//当是openSession时使用显式的close
//		session.close();
		sf.close();
		
	}

}
