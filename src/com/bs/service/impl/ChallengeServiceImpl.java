package com.bs.service.impl;
import java.util.List;

import com.bs.dao.ChallengeDao;
import com.bs.bean.Challenge;
import com.bs.exception.ModelException;
import com.bs.service.ChallengeService;
public class ChallengeServiceImpl implements ChallengeService{
	private ChallengeDao challengeDao=null;
	public void setChallengeDao(ChallengeDao challengeDao)
	{
		this.challengeDao=challengeDao;
	}
	public List getTodayMatchList() throws ModelException
	{
		return challengeDao.getTodayMatchList();
	}
	public List getMatchingListByJudgeid(int judgeid) throws ModelException
	{
		return this.challengeDao.getMatchingListByJudgeid(judgeid);
	}
	public List getMatchedListByJudgeid(int judgeid) throws ModelException
	{
		return this.challengeDao.getMatchedListByJudgeid(judgeid);
	}
	public List getUnAllowList() throws ModelException
	{
		return this.challengeDao.getUnAllowList();
	}
	public List getAllowListByTid(int tid) throws ModelException
	{
		return this.challengeDao.getAllowListByTid(tid);
	}
	public List getUnallowListByTid(int tid) throws ModelException
	{
		return this.challengeDao.getUnallowListByTid(tid);
	}
	public List getWaitAcceptListByTid(int tid) throws ModelException
	{
		return this.challengeDao.getWaitAcceptListByTid(tid);
	}
	public Boolean delChallengeByCid(int cid) throws ModelException
	{
		return this.challengeDao.delChallengeByCid(cid);
	}
	public Boolean UpdateChallenge(Challenge challenge) throws ModelException
	{
		return this.challengeDao.UpdateChallenge(challenge);
	}
	public Boolean UpdateChallState(Challenge challenge) throws ModelException
	{
		return this.challengeDao.UpdateChallState(challenge);
	}
	public void addChallenge(Challenge challenge) throws ModelException
	{
		this.challengeDao.addChallenge(challenge);
	}
	public Challenge getChallengeByCid(int cid) throws ModelException
	{
		return this.challengeDao.getChallengeByCid(cid);
	}
	public void UpdateChallengeState(Challenge challenge) throws ModelException
	{
		this.challengeDao.UpdateChallengeState(challenge);
	}
}
