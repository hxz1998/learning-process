package com.mrhu.spring.OldVersion.dao.impl.onetoseven;

import com.mrhu.spring.OldVersion.dao.onetoseven.UserDAO;
import com.mrhu.spring.OldVersion.model.onetoseven.User;

import java.util.*;

public class UserDAOImpl implements UserDAO {

	//简单属性注入
	private int daoId;
	private String daoStatus;
	
	//集合注入
	private List<String> list;
	private Map<String, String> map;
	private Set<String> set;
	
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
        System.out.println("user save777");
    }
	
	@Override
	public String toString() {
		//用于测试集合注入
//		return "map:"+map.size()+"-"+"list"+list.size()+"-set:"+set.size();
		return this.daoId+"";
	}

}
