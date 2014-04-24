package com.bs.dao;
import java.util.List;

import com.bs.bean.Challenge;

import com.bs.exception.ModelException;
public interface ChallengeDao {
	public List getTodayMatchList() throws ModelException;
	public List getMatchingListByJudgeid(int judgeid) throws ModelException;
	public List getMatchedListByJudgeid(int judgeid) throws ModelException;
	public List getUnAllowList() throws ModelException;
	public List getAllowListByTid(int tid) throws ModelException;
	public List getUnallowListByTid(int tid) throws ModelException;
	public List getWaitAcceptListByTid(int tid) throws ModelException;
	public List getLaunchListByTid(int tid) throws ModelException;
	public List getEndListByTid(int tid,int num) throws ModelException;
	public long getNumOfEndList(int tid) throws ModelException;
	public Boolean delChallengeByCid(int cid) throws ModelException;
	public Boolean UpdateChallenge(Challenge challenge) throws ModelException;
	public Boolean UpdateChallState(Challenge challenge) throws ModelException;
	public void addChallenge(Challenge challenge) throws ModelException;
	public Challenge getChallengeByCid(int cid) throws ModelException;
	public void UpdateChallengeState(Challenge challenge) throws ModelException;
	public boolean checkHaveChallengeByTid(int tid) throws ModelException;
}
