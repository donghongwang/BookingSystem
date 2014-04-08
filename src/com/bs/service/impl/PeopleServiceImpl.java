package com.bs.service.impl;

import java.util.List;

import com.bs.dao.PeopleDao;
import com.bs.bean.People;
import com.bs.exception.ModelException;
import com.bs.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{
	private PeopleDao peopleDao=null;
	public void setPeopleDao(PeopleDao peopleDao)
	{
		this.peopleDao=peopleDao;
	}
	public People selectByName(final String pname,final String password) throws ModelException {
		return (People)peopleDao.selectByName(pname,password);
	}
	public People registerUser(People people) throws ModelException
	{
		return (People)peopleDao.registerUser(people);
	}
	public People updateUserInfo(People people) throws ModelException
	{
		return (People)peopleDao.updateUserInfo(people);
	}
	public void updateUserSelf(People people) throws ModelException
	{
		peopleDao.updateUserSelf(people);
	}
	public People getUserByPid(int pid) throws ModelException
	{
		return this.peopleDao.getUserByPid(pid);
	}
	public List getTeammatesByTid(int tid) throws ModelException
	{
		return this.peopleDao.getTeammatesByTid(tid);
	}
	
	public List getApplyersByTid(int tid) throws ModelException
	{
		return this.peopleDao.getApplyersByTid(tid);
	}
	public List getJudgeList() throws ModelException
	{
		return this.peopleDao.getJudgeList();
	}
	public People checkByName(final String pname) throws ModelException
	{
		return this.peopleDao.checkByName(pname);
	}
}
