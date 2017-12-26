package com.chinasofti.crm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate5 {
	static Configuration configuration=null;
	static SessionFactory sessionFactory=null;
	static Session session=null;
	static{
		configuration=new Configuration();
		configuration.configure();
		sessionFactory= configuration.buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	public static Session getGurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
