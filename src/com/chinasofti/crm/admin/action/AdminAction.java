
package com.chinasofti.crm.admin.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasofti.crm.admin.entity.Admin;
import com.chinasofti.crm.admin.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope(value="prototype")
public class AdminAction extends ActionSupport{
	private String SUCCESS="success";
	private String FAILED="failed";
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@Autowired
	private AdminService adminService;
	public String addAdmin(){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String username = request.getParameter("username");
		String department = request.getParameter("department");
		String income = request.getParameter("income");
		
		String id = adminService.addAdmin(new Admin(username, department, income));
		try {
			response.getWriter().print(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	
	public String updateAdmin(){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	 int flg= adminService.updateAdmin(admin);
		System.out.println(flg);
			if (flg==1) {
				try {
					response.getWriter().print("1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					response.getWriter().print("修改失败,ID:"+admin.getId()+"名字:"+admin.getUsername()+"部门:"+admin.getDepartment());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return NONE;
	}
	
	public String delAdmin(){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int yes=0;
		int no=0;
		String str="删除失败ID为:";
		String[] boxs = request.getParameterValues("box");
		for (int i = 0; i < boxs.length; i++) {
			if (boxs[i]!=null&&!boxs[i].equals("")) {
		
				int id=Integer.parseInt(boxs[i]);
				boolean flg = adminService.delAdmin(id);
				if (flg) {
					yes++;
				}else{
					no++;
					str=str+id+".";
				}
		}
	}
		
		try {
			response.getWriter().print("成功删除:"+yes+"条,失败:"+no+"条,"+str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	
	public String queryAll(){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pageIndex=1;
		int pageCount=10;
		String value=null;
		String values = request.getParameter("value");
		String pageIndexs = request.getParameter("pageIndex");
		if (pageIndexs!=null&&!pageIndexs.equals("")) {
			pageIndex=Integer.parseInt(pageIndexs);
		}
		if (values!=null&&!values.equals("")) {
			value=values;
		}
		int pages = adminService.getPages(value, pageCount);
		List<Admin> list = adminService.queryAll(value,pageIndex,pageCount);
		if (pageIndex<1) {
			pageIndex=1;
		}
		if (pageIndex>pages) {
			pageIndex=pages;
		}
		 request.setAttribute("list", list);
		 request.setAttribute("pageIndex", pageIndex);
		 request.setAttribute("pages", pages);
		 request.setAttribute("msg", value);
		return SUCCESS;
	}

}
