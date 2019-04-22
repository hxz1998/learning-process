package com.mrhu.spring.OldVersion.dao.impl;

import com.mrhu.spring.OldVersion.model.Log;
import com.mrhu.spring.OldVersion.dao.LogDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

//@Component("logDAO")
public class LogDAOImpl implements LogDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Log log) {
		Session session = sessionFactory.getCurrentSession();
		session.save(log);
	}
}
