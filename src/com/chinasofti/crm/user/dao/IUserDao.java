package com.chinasofti.crm.user.dao;

import com.chinasofti.crm.user.entity.EUser;

public interface IUserDao {
	public boolean initAdministrator(EUser user);
	public boolean loginAdministrator(EUser user);
	
}
