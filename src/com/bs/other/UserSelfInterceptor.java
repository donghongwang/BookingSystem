package com.bs.other;

import com.bs.bean.People;
import com.bs.service.PeopleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserSelfInterceptor extends AbstractInterceptor
{
	private String name;
	public void setName(String name)
	{
		this.name=name;
	}
	private PeopleService peopleService=null;
	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		People people=(People)ActionContext.getContext().getSession().get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		ActionContext.getContext().getSession().put("user",people);
		String result=invocation.invoke();
		return result;	
	}
	
}
