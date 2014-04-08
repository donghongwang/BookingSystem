package com.bs.service.impl;
import java.util.List;

import com.bs.dao.P_TDao;
import com.bs.bean.P_T;
import com.bs.exception.ModelException;
import com.bs.service.P_TService;
public class P_TServiceImpl implements P_TService{
	private P_TDao p_tDao=null;
	public void setP_tDao(P_TDao p_tDao)
	{
		this.p_tDao=p_tDao;
	}
	public void addTeammate(P_T p_t) throws ModelException
	{
		this.p_tDao.addTeammate(p_t);
	}
	public void delMatesByPid(int pid) throws ModelException
	{
		this.p_tDao.delMatesByPid(pid);
	}
	public List getP_TByPid(int pid,int state) throws ModelException
	{
		return this.p_tDao.getP_TByPid(pid, state);
	}
	public boolean addApplyJoin(P_T pt) throws ModelException
	{
		return this.p_tDao.addApplyJoin(pt);
	}
	public void delP_tByTid(int tid,int state) throws ModelException
	{
		this.p_tDao.delP_tByTid(tid, state);
	}
}
