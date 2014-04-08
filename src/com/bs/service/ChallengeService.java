package com.bs.service;
import java.util.List;

import com.bs.bean.Challenge;
import com.bs.exception.ModelException;
public interface ChallengeService {

	public List getTodayMatchList() throws ModelException;
	public List getMatchingListByJudgeid(int judgeid) throws ModelException;
	public List getMatchedListByJudgeid(int judgeid) throws ModelException;
	public List getUnAllowList() throws ModelException;
	public List getAllowListByTid(int tid) throws ModelException;
	public List getUnallowListByTid(int tid) throws ModelException;
	public List getWaitAcceptListByTid(int tid) throws ModelException;
	public Boolean delChallengeByCid(int cid) throws ModelException;
	public Boolean UpdateChallenge(Challenge challenge) throws ModelException;
	public Boolean UpdateChallState(Challenge challenge) throws ModelException;
	public void addChallenge(Challenge challenge) throws ModelException;
	public Challenge getChallengeByCid(int cid) throws ModelException;
	public void UpdateChallengeState(Challenge challenge) throws ModelException;
}
