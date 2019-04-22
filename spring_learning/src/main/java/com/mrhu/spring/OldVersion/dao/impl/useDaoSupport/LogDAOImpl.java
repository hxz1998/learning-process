package com.mrhu.spring.OldVersion.dao.impl.useDaoSupport;

import com.mrhu.spring.OldVersion.model.Log;
import com.mrhu.spring.OldVersion.dao.LogDAO;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component("logDAO")
public class LogDAOImpl extends HibernateDaoSupport implements LogDAO {


	@Override
	public void save(Log log) {
		
		this.getHibernateTemplate().save(log);
//		this.save(log);
		
	}
}
