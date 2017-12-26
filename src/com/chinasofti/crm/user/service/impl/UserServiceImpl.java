package com.chinasofti.crm.user.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasofti.crm.user.dao.IUserDao;
import com.chinasofti.crm.user.entity.EUser;
import com.chinasofti.crm.user.service.IUserService;
@Service(value="userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Resource(name="userDao")
	private IUserDao userDao;

	@Override
	public boolean initAdministrator(EUser user) {
		// TODO Auto-generated method stub
		return userDao.initAdministrator(user);
	}

	@Override
	public boolean loginAdministrator(EUser user) {
		// TODO Auto-generated method stub
		return userDao.loginAdministrator(user);
	}


	

}
