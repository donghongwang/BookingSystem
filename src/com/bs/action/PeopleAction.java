package com.bs.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.bs.bean.People;
import com.bs.exception.ModelException;
import com.bs.service.PeopleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.bs.other.encoding;
public class PeopleAction extends ActionSupport{
	private PeopleService peopleService=null;
	private People people=null;

	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}
	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}
	public String checkLogin() throws ModelException
	{
		People _people=(People)peopleService.selectByName(this.getPeople().getPname(),this.getPeople().getPassword());
		if(_people==null)
			return INPUT;
		else
		{
			ActionContext.getContext().getSession().put("user",_people);
			return SUCCESS;
		}
	}
	private transient String used;
	public void setUsed(String used)
	{
		this.used=used;
	}
	public String getUsed()
	{
		return this.used;
	}
	public String checkUsername() throws ModelException
	{
		//this.getPeople().setPname("Åí¿¡Íþ");
		People p=null;
		p=this.peopleService.checkByName(this.getPeople().getPname());
		if(p==null)
			used="no";
		else
			used="yes";
		return SUCCESS;
	}
	public String registerUser() throws ModelException
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String passwordAgain=(String)request.getParameter("passwordAgain");
		if(passwordAgain==null)
			return INPUT;
		if(!passwordAgain.equals(this.getPeople().getPassword()))
			return INPUT;
		this.getPeople().setPassword(encoding.generatePassword(this.getPeople().getPassword()));
		this.getPeople().setPself(-1);
		People _people=(People)peopleService.registerUser(this.getPeople());
		HttpSession session=request.getSession();
		session.setAttribute("user", _people);
		return SUCCESS;
	}	
	public String lookUserInfo() throws ModelException
	{
		People _people=(People)ActionContext.getContext().getSession().get("user");
		_people=this.peopleService.getUserByPid(_people.getPid());
		ActionContext.getContext().getSession().put("user",_people);
		return SUCCESS;
	}
	public String editUserInfo()
	{
		return SUCCESS;
	}
	public String updateUserInfo() throws ModelException
	{
		People _people= (People)peopleService.updateUserInfo(this.getPeople());
		if(_people==null)
			return ERROR;
		ActionContext.getContext().getSession().put("user",_people);
		return SUCCESS;
	}
}
