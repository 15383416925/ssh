package com.chinasofti.crm.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="t_admin")
public class Admin {
	private Integer id;
	private String username;
	private String department;
	private String income;
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(Integer id, String username, String department, String income) {
		super();
		this.id = id;
		this.username = username;
		this.department = department;
		this.income = income;
	}
	public Admin(String username, String department, String income) {
		super();
		this.username = username;
		this.department = department;
		this.income = income;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", department="
				+ department + ", income=" + income + "]";
	}
	

}
