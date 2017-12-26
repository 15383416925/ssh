package com.chinasofti.crm.user.service;

import com.chinasofti.crm.user.entity.EUser;

public interface IUserService {
	public boolean initAdministrator(EUser user);
	public boolean loginAdministrator(EUser user);
}
