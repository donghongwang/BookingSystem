package com.bs.service;
import java.util.List;

import com.bs.bean.Result;
import com.bs.exception.ModelException;
public interface ResultService {
	public List getPjListByJudgeid(int judgeid) throws ModelException;
	public List getJudgePerformence() throws ModelException;
	public List getJudgeUnperformence() throws ModelException;
	public void addResult(Result result) throws ModelException;
	public List getUnPingjiaByTid1(int tid) throws ModelException;
	public List getUnPingjiaByTid2(int tid) throws ModelException;
	public void updatePingjia(int cid,int pjNum,String teamid) throws ModelException;
}
