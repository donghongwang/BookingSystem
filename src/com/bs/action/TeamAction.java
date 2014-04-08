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
public class TeamAction extends ActionSupport{
	private TeamService teamService=null;
	private PeopleService peopleService=null;
	private P_TService p_tService=null;
	private Team team=null;
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	
	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	public void setP_tService(P_TService p_tService) {
		this.p_tService = p_tService;
	}

	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public String teamReging() throws ModelException
	{
		People people=(People)ActionContext.getContext().getSession().get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		ActionContext.getContext().getSession().put("user", people);
		if(people.getPself()==-1)
			return SUCCESS;
		else
			return "reged";
	}
	public String teamReged() throws ModelException
	{
		People people=(People)ActionContext.getContext().getSession().get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		if(people.getPself()==-1)
		{
			this.getTeam().setTnumbers(1);
			this.getTeam().setCreatetime(new Date());
			this.getTeam().setLeaderid(people.getPid());
			this.getTeam().setTpoint(0);
			this.getTeam().setTsex(people.getPsex());
			int tid=this.teamService.teamRegister(team);
			P_T p_t=new P_T();
			p_t.setPid(people.getPid());
			p_t.setTid(tid);
			p_t.setState(1);
			p_t.setJointime(new Date());
			people.setPself(1);
			this.peopleService.updateUserSelf(people);
			this.p_tService.delMatesByPid(people.getPid());
			this.p_tService.addTeammate(p_t);
			ActionContext.getContext().getSession().put("user", people);
			return SUCCESS;
		}
		ActionContext.getContext().getSession().put("user", people);
		return ERROR;
		
	}
	
	public String getUnTeamList() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		if(people.getPself()==-1)
		{
			List unList=this.teamService.getUnTeamList("", people.getPsex(),people.getPid());
			List unedList=this.teamService.getUnedTeamList("", people.getPsex(),people.getPid());
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("unTeamList", unList);
			request.put("unedTeamList", unedList);
			session.put("user", people);
			return SUCCESS;
		}
		session.put("user", people);
		return "joined";
	}
	
	public String searchUnTeamList() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		if(people.getPself()==-1)
		{
			List unList=this.teamService.getUnTeamList(this.getTeam().getTname(), people.getPsex(),people.getPid());
			List unedList=this.teamService.getUnedTeamList(this.getTeam().getTname(), people.getPsex(),people.getPid());
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("unTeamList", unList);
			request.put("unedTeamList", unedList);
			session.put("user", people);
			return SUCCESS;
		}
		session.put("user", people);
		return "joined";
	}
	public String getScoreSortList() throws ModelException
	{
		List list=this.teamService.getScoreSortList("");
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("scoreSortList", list);
		return SUCCESS;
	}
	public String searchScoreSortList() throws ModelException
	{
		List list=this.teamService.getScoreSortList(this.getTeam().getTname());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("scoreSortList", list);
		return SUCCESS;
	}
	public String getChallengeTeamList() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if( (people.getPself()==0 || people.getPself()==1) )
		{
			List ptlist=this.p_tService.getP_TByPid(people.getPid(), 1);
			if(ptlist.size()==1)
			{
				P_T pt=(P_T)ptlist.get(0);
				Team team=this.teamService.getTeamByTid(pt.getTid());
				if(team.getTnumbers()==4)
				{
					List list=this.teamService.getChallengeTeamList("",team.getTid());
					Map request=(Map)ActionContext.getContext().get("request");
					request.put("challengeTeamList", list);
				}
			}
		}
		return SUCCESS;
	}
	public String searchChallengeTeamList() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if( (people.getPself()==0 || people.getPself()==1) )
		{
			List ptlist=this.p_tService.getP_TByPid(people.getPid(), 1);
			if(ptlist.size()==1)
			{
				P_T pt=(P_T)ptlist.get(0);
				Team team=this.teamService.getTeamByTid(pt.getTid());
				if(team.getTnumbers()==4)
				{
					List list=this.teamService.getChallengeTeamList(this.getTeam().getTname(),team.getTid());
					Map request=(Map)ActionContext.getContext().get("request");
					request.put("challengeTeamList", list);
				}
			}
		}
		return SUCCESS;
	}
	public String getTeamMsg() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if( (people.getPself()==0 || people.getPself()==1) )
		{
			List ptlist=this.p_tService.getP_TByPid(people.getPid(), 1);
			if(ptlist.size()==1)
			{
				P_T pt=(P_T)ptlist.get(0);
				Team _team=this.teamService.getTeamByTid(pt.getTid());
				List mateList=this.peopleService.getTeammatesByTid(pt.getTid());
				List applyList=this.peopleService.getApplyersByTid(pt.getTid());
				Map request=(Map)ActionContext.getContext().get("request");
				request.put("myTeam", _team);
				request.put("matesList", mateList);
				request.put("applyList", applyList);
			}
		}
		return SUCCESS;
	}
	public String getTeammatesForLeader() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if( people.getPself()==1 )
		{
			List ptlist=this.p_tService.getP_TByPid(people.getPid(), 1);
			if(ptlist.size()==1)
			{
				P_T pt=(P_T)ptlist.get(0);
				List mateList=this.peopleService.getTeammatesByTid(pt.getTid());
				Map request=(Map)ActionContext.getContext().get("request");
				request.put("matesList", mateList);
			}
		}
		return SUCCESS;
	}
	public String updateTeamLeader() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		if(people.getPself()==1)
		{
			People newLeader=(People)this.peopleService.getUserByPid(this.getTeam().getLeaderid());
			if(newLeader.getPself()==0)
			{
				List list=this.p_tService.getP_TByPid(people.getPid(), 1);
				if(list.size()==1)
				{
					P_T pt=(P_T)list.get(0);
					this.teamService.updateTeamLeader(pt.getTid(), this.getTeam().getLeaderid());
					people.setPself(0);
					newLeader.setPself(1);
					this.peopleService.updateUserSelf(people);
					this.peopleService.updateUserSelf(newLeader);
					session.put("user", people);
					return SUCCESS;
				}
			}
		}
		return ERROR;
	}
}
