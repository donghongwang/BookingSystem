package com.bs.service.impl;
import java.util.List;

import com.bs.dao.TeamDao;
import com.bs.bean.Team;
import com.bs.exception.ModelException;
import com.bs.service.TeamService;
public class TeamServiceImpl implements TeamService{
	private TeamDao teamDao=null;
	public void setTeamDao(TeamDao teamDao)
	{
		this.teamDao=teamDao;
	}
	public int teamRegister(Team team) throws ModelException
	{
		return teamDao.teamRegister(team);
	}
	public List getUnTeamList(String tname,String psex,int pid) throws ModelException
	{
		return teamDao.getUnTeamList(tname, psex,pid);
	}
	public List getUnedTeamList(String tname,String psex,int pid) throws ModelException
	{
		return teamDao.getUnedTeamList(tname, psex, pid);
	}
	public List getScoreSortList(String tname) throws ModelException
	{
		return teamDao.getScoreSortList(tname);
	}
	public List getChallengeTeamList(String tname,int tid) throws ModelException
	{
		return this.teamDao.getChallengeTeamList(tname,tid);
	}
	public Team getTeamByTid(int tid) throws ModelException
	{
		return this.teamDao.getTeamByTid(tid);
	}
	public void updateTeamNumber(int tid,int num) throws ModelException
	{
		this.teamDao.updateTeamNumber(tid, num);
	}
	public void deleteTeamByTid(int tid) throws ModelException
	{
		this.teamDao.deleteTeamByTid(tid);
	}
	public void updateTeamLeader(int tid,int leaderid) throws ModelException
	{
		this.teamDao.updateTeamLeader(tid, leaderid);
	}
	public void updateTeam(Team team) throws ModelException
	{
		this.teamDao.updateTeam(team);
	}
}
