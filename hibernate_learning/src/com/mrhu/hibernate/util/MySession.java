package com.mrhu.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySession {
	
	private static SessionFactory sessionFactory = null;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
