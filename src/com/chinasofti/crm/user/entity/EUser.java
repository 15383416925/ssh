package com.chinasofti.crm.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_USER")
public class EUser {
	private Integer id;
	private String admin_username;
	private String admin_password;
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	@Override
	public String toString() {
		return "EUser [id=" + id + ", admin_username=" + admin_username
				+ ", admin_password=" + admin_password + "]";
	}

	public EUser(String admin_username, String admin_password) {
		super();
		this.admin_username = admin_username;
		this.admin_password = admin_password;
	}

	public EUser() {
		super();
	}

}
