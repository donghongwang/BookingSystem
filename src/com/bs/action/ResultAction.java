package com.bs.action;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.bs.bean.Challenge;
import com.bs.bean.P_T;
import com.bs.bean.People;
import com.bs.bean.Result;
import com.bs.bean.Team;
import com.bs.exception.ModelException;
import com.bs.service.ChallengeService;
import com.bs.service.P_TService;
import com.bs.service.PeopleService;
import com.bs.service.ResultService;
import com.bs.service.TeamService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class ResultAction extends ActionSupport{
	private ResultService resultService=null;
	private TeamService teamService=null;
	private ChallengeService challengeService=null;
	private PeopleService peopleService=null;
	private P_TService p_tService=null;
	private Result result=null;

	
	public void setP_tService(P_TService p_tService) {
		this.p_tService = p_tService;
	}
	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	public void setChallengeService(ChallengeService challengeService) {
		this.challengeService = challengeService;
	}
	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getPjListByJudgeid() throws ModelException
	{
		People people=(People)ActionContext.getContext().getSession().get("user");
		if(people.getPself()==2)
		{
			List list=this.resultService.getPjListByJudgeid(people.getPid());
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("pjList", list);
		}
		return SUCCESS;
	}
	public String getJudgePerformence() throws ModelException
	{
		People people=(People)ActionContext.getContext().getSession().get("user");
		if(people.getPself()==3)
		{
			List list1=this.resultService.getJudgePerformence();
			List list2=this.resultService.getJudgeUnperformence();
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("jedgePerformList", list1);
			request.put("jedgeUnperformList", list2);
		}
		return SUCCESS;
	}
	public String updateResult() throws ModelException
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		People people=(People)ActionContext.getContext().getSession().get("user");
		if(people.getPself()==2)
		{
			Challenge challenge=this.challengeService.getChallengeByCid(this.getResult().getCid());
			challenge.setState(5);
			this.challengeService.UpdateChallengeState(challenge);
			System.out.println(this.getResult().getCid());
			if(this.getResult().getT1_score()>this.getResult().getT2_score())
				this.getResult().setWinid(challenge.getTid1());
			else
				this.getResult().setWinid(challenge.getTid2());
			this.getResult().setJudgeid(people.getPid());
			this.getResult().setT1_appraisalJudge(-1);
			this.getResult().setT2_appraisalJudge(-1);
			this.resultService.addResult(this.getResult());
			
			Team team=this.teamService.getTeamByTid(this.getResult().getWinid());
			int tpoint=Integer.parseInt(request.getParameter("tpoint"));
			team.setTpoint(tpoint+team.getTpoint());
			this.teamService.updateTeam(team);
			return SUCCESS;
		}
		return ERROR;
	}
	public String getUnPingjia() throws ModelException
	{
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if(people.getPself()==1)
		{
			List ptlist=this.p_tService.getP_TByPid(people.getPid(), 1);
			if(ptlist.size()==1)
			{
				P_T pt=(P_T)ptlist.get(0);
				List list1=this.resultService.getUnPingjiaByTid1(pt.getTid());
				List list2=this.resultService.getUnPingjiaByTid2(pt.getTid());
				Map request=(Map)ActionContext.getContext().get("request");
				request.put("UnpjTid1", list1);
				request.put("UnpjTid2", list2);
				return SUCCESS;
			}
		}
		return ERROR;
	}
	public String toEditPingjia() throws ModelException
	{
		return SUCCESS;
	}
	public String updatePingjia() throws ModelException
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session=ActionContext.getContext().getSession();
		People people=(People)session.get("user");
		people=this.peopleService.getUserByPid(people.getPid());
		session.put("user", people);
		if(people.getPself()==1)
		{
			String teamid=request.getParameter("teamid");
			String pj=request.getParameter("appraisalJudge");
			int pjNum=Integer.parseInt(pj);
			this.resultService.updatePingjia(result.getCid(), pjNum, teamid);
			return SUCCESS;
		}
		return ERROR;
	}
}
