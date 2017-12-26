package com.chinasofti.crm.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.chinasofti.crm.user.dao.IUserDao;
import com.chinasofti.crm.user.entity.EUser;
@Repository(value="userDao")
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public boolean initAdministrator(EUser user) {
	
		this.hibernateTemplate.save(user);
		return false;
	}
	
	@Override
	public boolean loginAdministrator(EUser user) {
		
		
		
		List<EUser> list = this.hibernateTemplate.findByExample(user);
		System.out.println(list.toString());
		for (EUser e : list) {
			if(e.getAdmin_username()!=null){
				return true;
			}
		}
		return false;
	}
	
	


}
