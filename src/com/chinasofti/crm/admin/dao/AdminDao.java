package com.chinasofti.crm.admin.dao;

import java.util.List;

import com.chinasofti.crm.admin.entity.Admin;


public interface AdminDao {
	public List<Admin> queryAll(String value,int pageIndex,int pageCount);
	public String addAdmin(Admin a);
	public boolean delAdmin(int id);
	public int updateAdmin(Admin a);
	public int getPages(String value,int pageCount);

}
