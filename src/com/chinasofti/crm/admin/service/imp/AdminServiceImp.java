package com.chinasofti.crm.admin.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasofti.crm.admin.dao.AdminDao;
import com.chinasofti.crm.admin.entity.Admin;
import com.chinasofti.crm.admin.service.AdminService;
@Service
@Transactional
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String addAdmin(Admin a) {
		// TODO Auto-generated method stub
		return adminDao.addAdmin(a);
	}


	@Override
	public boolean delAdmin(int id) {
		// TODO Auto-generated method stub
		return adminDao.delAdmin(id);
	}

	@Override
	public List<Admin> queryAll(String value, int pageIndex, int pageCount) {
		// TODO Auto-generated method stub
		return adminDao.queryAll(value, pageIndex, pageCount);
	}

	@Override
	public int getPages(String value, int pageCount) {
		// TODO Auto-generated method stub
		return adminDao.getPages(value, pageCount);
	}


	@Override
	public int updateAdmin(Admin a) {
		// TODO Auto-generated method stub
		return adminDao.updateAdmin(a);
	}

}
