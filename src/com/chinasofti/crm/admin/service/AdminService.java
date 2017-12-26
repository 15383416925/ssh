package com.chinasofti.crm.admin.service;

import java.util.List;

import com.chinasofti.crm.admin.entity.Admin;

public interface AdminService {
	public String addAdmin(Admin a);
	public boolean delAdmin(int id);
	public List<Admin> queryAll(String value,int pageIndex,int pageCount);
	public int getPages(String value, int pageCount);
	public int updateAdmin(Admin a);

}
