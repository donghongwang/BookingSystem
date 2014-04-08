package com.bs.bean;

import java.util.Date;

public class Team implements java.io.Serializable{
	
	private int tid;
	private String tname;
	private String tjianjie;
	private int tpoint;
	private int tnumbers;
	private int leaderid;
	private String tsex;
	private Date createtime;
	
	public Team(){}
	public Team(int tid,String tname,String tjianjie,int tpoint,int tnumbers,int leaderid,String tsex,Date createtime)
	{
		this.tid=tid;
		this.tname=tname;
		this.tjianjie=tjianjie;
		this.tpoint=tpoint;
		this.tnumbers=tnumbers;
		this.leaderid=leaderid;
		this.tsex=tsex;
		this.createtime=createtime;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTjianjie() {
		return tjianjie;
	}
	public void setTjianjie(String tjianjie) {
		this.tjianjie = tjianjie;
	}
	public int getTpoint() {
		return tpoint;
	}
	public void setTpoint(int tpoint) {
		this.tpoint = tpoint;
	}
	public int getTnumbers() {
		return tnumbers;
	}
	public void setTnumbers(int tnumbers) {
		this.tnumbers = tnumbers;
	}
	public int getLeaderid() {
		return leaderid;
	}
	public void setLeaderid(int leaderid) {
		this.leaderid = leaderid;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}

