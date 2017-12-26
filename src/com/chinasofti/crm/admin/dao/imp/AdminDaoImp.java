package com.chinasofti.crm.admin.dao.imp;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chinasofti.crm.admin.dao.AdminDao;
import com.chinasofti.crm.admin.entity.Admin;
@Transactional  
@Repository
public class AdminDaoImp implements AdminDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
 
   @Override
	public String addAdmin(Admin a) {
		List<Admin> find =(List<Admin>) this.hibernateTemplate.find("FROM Admin where username=? and department=? and income=?",a.getUsername(),a.getDepartment(),a.getIncome());
			if (find.toString()=="[]") {
				Serializable save = this.hibernateTemplate.save(a);
				 find =(List<Admin>) this.hibernateTemplate.find("FROM Admin where username=? and department=? and income=?",a.getUsername(),a.getDepartment(),a.getIncome());
				 for (Admin admin : find) {
					return admin.getId().toString();
				}
			}
		return null;
	}

	@Override
	public boolean delAdmin(int id) {
	    Admin admin = this.hibernateTemplate.get(Admin.class, id);
	   
	    if (admin!=null) {
	    	this.hibernateTemplate.delete(admin);
	    	return true;
		}
		return false;
	}

	@Override
	public List<Admin> queryAll(String value, int pageIndex, int pageCount) {	
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
	
        String hql = "FROM Admin WHERE (1=1) ";  
		if (value!=null) {
			hql = " FROM Admin WHERE (department LIKE '%"+value+"%' OR income LIKE '%"+value+"%' OR username LIKE '%"+value+"%') "; 
		}		  
		Query query = session.createQuery(hql);
		query.setFirstResult((pageIndex-1)*pageCount) ; 
		query.setMaxResults(pageCount);  
		List<Admin> list = query.list();  

	        return list;
	}
	
	
	@Override
	public int getPages(String value, int pageCount) {
			int pages=1;
			int count=0;
			String hql="SELECT COUNT(id) FROM Admin WHERE (1=1)";
			if (value!=null) {
				
				hql = "SELECT COUNT(id) FROM Admin WHERE (department LIKE '%"+value+"%' OR income LIKE '%"+value+"%' OR username LIKE '%"+value+"%') ";   
			}
		     List<Long> list=(List<Long>) this.hibernateTemplate.find(hql);
		        if(list!=null&&list.size()>=0){
		             count=list.get(0).intValue();
		        }
	        if (count%pageCount==0) {
				 pages=count/pageCount;
			}else{
				 pages=count/pageCount+1;
			}
	       System.out.println("查询的总页数:"+pages);
		return pages;
	}

	@Override
	public int updateAdmin(Admin a) {
		int i=1;
			this.hibernateTemplate.update(a);
		return i;
	}
	

}
