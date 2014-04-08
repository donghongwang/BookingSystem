package com.bs.action;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.bs.bean.P_T;
import com.bs.bean.People;
import com.bs.bean.Team;
import com.bs.exception.ModelException;
import com.bs.service.P_TService;
import com.bs.service.PeopleService;
import com.bs.service.TeamService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class P_TAction extends ActionSupport{
	private P_TService p_tService=null;
	private TeamService teamService=null;
	private PeopleService peopleService=null;
	private P_T p_t=null;
	public void setP_tService(P_TService p_tService) {
		this.p_tService = p_tService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	public P_T getP_t() {
		return p_t;
	}
	public void setP_t(P_T p_t) {
		this.p_t = p_t;
	}
	public String addApplyJoin() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=this.peopleService.getUserByPid(p_t.getPid());
		session.put("user", people);
		if(people.getPself()==-1)
		{
			Team team=this.teamService.getTeamByTid(p_t.getTid());
			if(team.getTnumbers()<4)
			{
				p_t.setState(0);
				p_t.setJointime(new Date());
				Boolean result=this.p_tService.addApplyJoin(p_t);
				if(result)
					return SUCCESS;
				else
					return ERROR;
			}
		}
		return "joinedOrFull";
	}
	public String delTeammate() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if(people.getPself()==1)
		{
			this.p_tService.delMatesByPid(p_t.getPid());
			this.teamService.updateTeamNumber(p_t.getTid(), -1);
			People _people=this.peopleService.getUserByPid(p_t.getPid());
			_people.setPself(-1);
			this.peopleService.updateUserSelf(_people);
			return SUCCESS;
		}
		return ERROR;
	}
	public String addTeammate() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People user=(People)session.get("user");
		user=this.peopleService.getUserByPid(user.getPid());
		session.put("user", user);
		if(user.getPself()==1)
		{
			People mate=this.peopleService.getUserByPid(p_t.getPid());
			if(mate.getPself()==-1)
			{
				Team team=this.teamService.getTeamByTid(p_t.getTid());
				if(team.getTnumbers()<4)
				{
					this.p_tService.delMatesByPid(p_t.getPid());
					p_t.setJointime(new Date());
					p_t.setState(1);
					this.p_tService.addTeammate(this.getP_t());
					this.teamService.updateTeamNumber(p_t.getTid(), 1);
					People _people=this.peopleService.getUserByPid(p_t.getPid());
					_people.setPself(0);
					this.peopleService.updateUserSelf(_people);
					return SUCCESS;
				}
				else
				{
					this.p_tService.delP_tByTid(p_t.getTid(), 0);
					return "full";
				}
			}
		}
		return ERROR;
	}
	public String quitOfTeam() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People user=(People)session.get("user");
		user=this.peopleService.getUserByPid(user.getPid());
		session.put("user", user);
		if(user.getPself()==1)
			return "forLeader";
		else
			return "forTeamer";
	}
	public String quitForTeamer() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People user=(People)session.get("user");
		user=this.peopleService.getUserByPid(user.getPid());
		if(user.getPself()==0)
		{
			List list=this.p_tService.getP_TByPid(user.getPid(), 1);
			if(list.size()==1)
			{
				P_T pt=(P_T)list.get(0);
				this.p_tService.delMatesByPid(user.getPid());
				this.teamService.updateTeamNumber(pt.getTid(), -1);
				user.setPself(-1);
				this.peopleService.updateUserSelf(user);
				session.put("user", user);
				return SUCCESS;
			}	
		}
		return ERROR;
	}
	public String quitForLeader() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People user=(People)session.get("user");
		user=this.peopleService.getUserByPid(user.getPid());
		if(user.getPself()==1)
		{
			List list=this.p_tService.getP_TByPid(user.getPid(), 1);
			if(list.size()==1)
			{
				P_T pt=(P_T)list.get(0);
				this.p_tService.delP_tByTid(pt.getTid(), 1);
				this.p_tService.delP_tByTid(pt.getTid(), 0);
				this.teamService.deleteTeamByTid(pt.getTid());
				user.setPself(-1);
				this.peopleService.updateUserSelf(user);
				session.put("user", user);
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
}
