package com.bs.dao;

import java.util.List;

import com.bs.bean.Team;

import com.bs.exception.ModelException;

public interface TeamDao {
	public int teamRegister(Team team) throws ModelException;
	public List getUnTeamList(String tname,String psex,int pid) throws ModelException;
	public List getUnedTeamList(String tname,String psex,int pid) throws ModelException;
	public List getScoreSortList(String tname) throws ModelException;
	public List getChallengeTeamList(String tname,int tid) throws ModelException;
	public Team getTeamByTid(int tid) throws ModelException;
	public void updateTeamNumber(int tid,int num) throws ModelException;
	public void deleteTeamByTid(int tid) throws ModelException;
	public void updateTeamLeader(int tid,int leaderid) throws ModelException;
	public void updateTeam(Team team) throws ModelException;
}
