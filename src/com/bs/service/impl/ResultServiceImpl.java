package com.bs.service.impl;
import java.util.List;

import com.bs.dao.ResultDao;
import com.bs.bean.Result;
import com.bs.exception.ModelException;
import com.bs.service.ResultService;
public class ResultServiceImpl implements ResultService{
	private ResultDao resultDao=null;
	public void setResultDao(ResultDao resultDao)
	{
		this.resultDao=resultDao;
	}
	public List getPjListByJudgeid(int judgeid) throws ModelException
	{
		return this.resultDao.getPjListByJudgeid(judgeid);
	}
	public List getJudgePerformence() throws ModelException
	{
		return this.resultDao.getJudgePerformence();
	}
	public List getJudgeUnperformence() throws ModelException
	{
		return this.resultDao.getJudgeUnperformence();
	}
	public void addResult(Result result) throws ModelException
	{
		this.resultDao.addResult(result);
	}
	public List getUnPingjiaByTid1(int tid) throws ModelException
	{
		return this.resultDao.getUnPingjiaByTid1(tid);
	}
	public List getUnPingjiaByTid2(int tid) throws ModelException
	{
		return this.resultDao.getUnPingjiaByTid2(tid);
	}
	public void updatePingjia(int cid,int pjNum,String teamid) throws ModelException
	{
		this.resultDao.updatePingjia(cid, pjNum, teamid);
	}
}
