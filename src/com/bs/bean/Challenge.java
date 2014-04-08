package com.bs.bean;

import java.util.Date;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Challenge implements java.io.Serializable{

	private int cid;
	private int tid1;
	private int tid2;
	private Date date;
	private int state;
	private String place;
	private int judgeid;
	
	public Challenge(){}
	public Challenge(int cid,int tid1,int tid2,Date date,int state,String place,int judgeid)
	{
		this.cid=cid;
		this.tid1=tid1;
		this.tid2=tid2;
		this.date=date;
		this.state=state;
		this.place=place;
		this.judgeid=judgeid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getTid1() {
		return tid1;
	}
	public void setTid1(int tid1) {
		this.tid1 = tid1;
	}
	public int getTid2() {
		return tid2;
	}
	public void setTid2(int tid2) {
		this.tid2 = tid2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getJudgeid() {
		return judgeid;
	}
	public void setJudgeid(int judgeid) {
		this.judgeid = judgeid;
	}
	
}
