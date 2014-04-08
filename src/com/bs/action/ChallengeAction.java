package com.bs.action;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.bs.bean.Challenge;
import com.bs.bean.P_T;
import com.bs.bean.People;
import com.bs.bean.Team;
import com.bs.exception.ModelException;
import com.bs.service.ChallengeService;
import com.bs.service.P_TService;
import com.bs.service.PeopleService;
import com.bs.service.TeamService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class ChallengeAction extends ActionSupport{
	private ChallengeService challengeService=null;
	private P_TService p_tService=null;
	private PeopleService peopleService=null;
	private Challenge challenge=null;
	private TeamService teamService=null;

	public void setChallengeService(ChallengeService challengeService) {
		this.challengeService = challengeService;
	}
	public void setP_tService(P_TService p_tService) {
		this.p_tService = p_tService;
	}
	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	public Challenge getChallenge() {
		return challenge;
	}
	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}
	public String getTodayMatchList() throws ModelException
	{
		List list=this.challengeService.getTodayMatchList();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("todayMatchList", list);
		return SUCCESS;
	}
	public String getMatchingListByJudgeid() throws ModelException
	{
		People people=(People)ActionContext.getContext().getSession().get("user");
		if(people.getPself()==2)
		{
			List list=this.challengeService.getMatchingListByJudgeid(people.getPid());
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("matchingList", list);
		}
		return SUCCESS;
	}
	public String getMatchedListByJudgeid() throws ModelException
	{
		People people=(People)ActionContext.getContext().getSession().get("user");
		if(people.getPself()==2)
		{
			List list=this.challengeService.getMatchedListByJudgeid(people.getPid());
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("matchedList", list);
			Map session=ActionContext.getContext().getSession();
			session.put("matchedList", list);
		}
		return SUCCESS;
	}
	public String getUnAllowList() throws ModelException
	{
		People people=(People)ActionContext.getContext().getSession().get("user");
		if(people.getPself()==3)
		{
			List list=this.challengeService.getUnAllowList();
			Map request=(Map)ActionContext.getContext().get("request");		
			request.put("unallowList", list);
		}
		return SUCCESS;
	}
	public String getAllowList() throws ModelException
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
					List list1=this.challengeService.getAllowListByTid(pt.getTid());
					List list2=this.challengeService.getUnallowListByTid(pt.getTid());
					List list3=this.challengeService.getWaitAcceptListByTid(pt.getTid());
					Map request=(Map)ActionContext.getContext().get("request");
					request.put("allowList", list1);
					request.put("unallowList", list2);
					request.put("waitAcceptList", list3);
				}
			}
		}
		return SUCCESS;
	} 
	public String rejectChallenge() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		if(people.getPself()==3)
		{
			Boolean result=this.challengeService.delChallengeByCid(this.getChallenge().getCid());
			if(result)
				return SUCCESS;
		}
		return ERROR;
	}
	public String toAllowChallenge() throws ModelException
	{
		List list=this.peopleService.getJudgeList();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("judgeList", list);
		return SUCCESS;
	}
	public String allowChallenge() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		if(people.getPself()==3)
		{
			Boolean result=this.challengeService.UpdateChallenge(this.getChallenge());
			if(result)
				return SUCCESS;
		}
		return ERROR;
	}
	public String rejectMatch() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if(people.getPself()==1)
		{
			Boolean result=this.challengeService.delChallengeByCid(this.getChallenge().getCid());
			if(result)
				return SUCCESS;
		}
		return ERROR;
	}
	public String allowMatch() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if(people.getPself()==1)
		{
			Boolean result=this.challengeService.UpdateChallState(this.getChallenge());
			if(result)
				return SUCCESS;
		}
		return ERROR;
	}
	public String toChallengeinfo() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if(people.getPself()==1)
			return SUCCESS;
		else
			return "notLeader";
	}
	public String addChallengeinfo() throws ModelException, ParseException
	{
		Map session=ActionContext.getContext().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if(people.getPself()==1)
		{
			List ptlist=this.p_tService.getP_TByPid(people.getPid(), 1);
			if(ptlist.size()==1)
			{
				P_T pt=(P_T)ptlist.get(0);
				Team team=this.teamService.getTeamByTid(pt.getTid());
				if(team.getTnumbers()==4)
				{
					this.getChallenge().setTid1(pt.getTid());
					this.getChallenge().setJudgeid(-1);
					this.getChallenge().setPlace("нч");
					this.getChallenge().setState(1);
					String dateString=request.getParameter("dateString");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date=sdf.parse(dateString);
					this.getChallenge().setDate(date);
					this.challengeService.addChallenge(this.getChallenge());
					return SUCCESS;
				}
				else
					return "notFull";
			}
		}
		return "notLeader";
	}
	public String toEditreport() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if(people.getPself()==2)
		{
			List list=(List) session.get("matchedList");
			for(int i=0;i<list.size();i++)
			{
				Object obj[] =(Object[]) list.get(i);
				if(obj[0].toString().equals(""+this.getChallenge().getCid()))
				{
					Map request=(Map)ActionContext.getContext().get("request");
					request.put("chall", obj);
					return SUCCESS;
				}
			}	
			return ERROR;
		}
		else
			return ERROR;
	}
}
