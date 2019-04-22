package com.mrhu.spring.OldVersion.dao.impl.annotation;

import com.mrhu.spring.OldVersion.dao.annotation.UserDAO;
import com.mrhu.spring.OldVersion.model.annotation.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

//@Component("uuu")
public class UserDAOImpl implements UserDAO {

	//简单属性注入
	private int daoId;
	private String daoStatus;
	
	//集合注入
	private List<String> list;
	private Map<String, String> map;
	private Set<String> set;

	//整合hibernate
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Resource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

    public int getDaoId() {
		return daoId;
	}

	public void setDaoId(int daoId) {
		this.daoId = daoId;
	}

	public String getDaoStatus() {
		return daoStatus;
	}

	public void setDaoStatus(String daoStatus) {
		this.daoStatus = daoStatus;
	}

	@Override
    public void save(User user) {
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			conn.createStatement().execute("insert into user VALUES(null, 'zhangsan'); ");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				conn.close();
			} catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
        System.out.println("user save666");
    }
	
	@Override
	public String toString() {
		//用于测试集合注入
//		return "map:"+map.size()+"-"+"list"+list.size()+"-set:"+set.size();
		return this.daoId+"";
	}

	@Override
	public void delete(User user) {
		System.out.println("delete user");
	}

}
