package com.bs.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class otherAction extends ActionSupport{
	public String toAbout()
	{
		return SUCCESS;
	}
	public String exitSystem()
	{
		Map session=ActionContext.getContext().getSession();
		session.clear();
		session.remove("user");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session1=request.getSession();
		session1.invalidate();
		return SUCCESS;
	}
	public String loginSystem()
	{
		return SUCCESS;
	}
}
