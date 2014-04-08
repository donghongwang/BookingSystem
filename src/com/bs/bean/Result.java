package com.bs.bean;

public class Result implements java.io.Serializable{

	private int cid;
	private int judgeid;
	private int t1_score;
	private int t2_score;
	private int winid;
	private int t1_appraisalJudge;
	private int t2_appraisalJudge;
	
	public Result(){}
	public Result(int cid,int judgeid,int t1_score,int t2_score,int winid,int t1_appraisalJudge,int t2_appraisalJudge)
	{
		this.cid=cid;
		this.judgeid=judgeid;
		this.t1_score=t1_score;
		this.t2_score=t2_score;
		this.winid=winid;
		this.t1_appraisalJudge=t1_appraisalJudge;
		this.t2_appraisalJudge=t2_appraisalJudge;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getJudgeid() {
		return judgeid;
	}
	public void setJudgeid(int judgeid) {
		this.judgeid = judgeid;
	}
	
	public int getT1_score() {
		return t1_score;
	}
	public void setT1_score(int t1_score) {
		this.t1_score = t1_score;
	}
	public int getT2_score() {
		return t2_score;
	}
	public void setT2_score(int t2_score) {
		this.t2_score = t2_score;
	}
	public int getWinid() {
		return winid;
	}
	public void setWinid(int winid) {
		this.winid = winid;
	}
	public int getT1_appraisalJudge() {
		return t1_appraisalJudge;
	}
	public void setT1_appraisalJudge(int t1_appraisalJudge) {
		this.t1_appraisalJudge = t1_appraisalJudge;
	}
	public int getT2_appraisalJudge() {
		return t2_appraisalJudge;
	}
	public void setT2_appraisalJudge(int t2_appraisalJudge) {
		this.t2_appraisalJudge = t2_appraisalJudge;
	}
	
	
}
