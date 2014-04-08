package com.bs.bean;

import java.util.Date;

public class P_T implements java.io.Serializable{
	private static final long serialVersionUID = -4888836126783955019L;
	private int pid;
	private int tid;
	private int state;
	private Date jointime;
	
	public P_T(){}
	public P_T(int pid,int tid,int state,Date jointime)
	{
		this.pid=pid;
		this.tid=tid;
		this.state=state;
		this.jointime=jointime;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getJointime() {
		return jointime;
	}
	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        P_T other = (P_T) obj;
        if(pid!=other.pid)
        	return false;
        if(tid!=other.tid)
            return false;
        return true;
	}
	public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (new Integer(this.pid)).hashCode();
        result = prime * result + (new Integer(this.tid)).hashCode();
        return result;
    }
}
