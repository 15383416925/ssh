package com.chinasofti.crm.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasofti.crm.user.entity.EUser;
import com.chinasofti.crm.user.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope(value="prototype")
public class UserAction extends ActionSupport{
	private EUser user;
	
	public EUser getUser() {
		return user;
	}
	public void setUser(EUser user) {
		this.user = user;
	}
	//注入Service
	@Resource(name="userService")
	IUserService userService;
	public String zhuceAdministrator(){
		
		userService.initAdministrator(user);
		return SUCCESS;
	}
	

	public String loginAdministrator(){
		
		boolean flag = userService.loginAdministrator(user);
		System.out.println(flag);
		if (flag) {
			return SUCCESS;
		}
		return "failed";
	}
	
}
