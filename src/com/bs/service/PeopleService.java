package com.bs.service;

import java.util.List;

import com.bs.bean.People;
import com.bs.exception.ModelException;

public interface PeopleService {
	public People selectByName(final String pname,final String password) throws ModelException;
	public People registerUser(People people) throws ModelException;
	public People updateUserInfo(People people) throws ModelException;
	public void updateUserSelf(People people) throws ModelException;
	public People getUserByPid(int pid) throws ModelException;
	public List getTeammatesByTid(int tid) throws ModelException;
	public List getApplyersByTid(int tid) throws ModelException;
	public List getJudgeList() throws ModelException;
	public People checkByName(final String pname) throws ModelException;
	public List getTeamMemMsg(int tid) throws ModelException;
}
