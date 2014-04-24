package com.bs.dao.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bs.dao.ChallengeDao;
import com.bs.exception.ModelException;
import com.bs.bean.Challenge;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class ChallengeDaoImpl extends HibernateDaoSupport implements ChallengeDao{

	@SuppressWarnings("deprecation")
	public List getTodayMatchList() throws ModelException
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateStart=new Date();
		Date dateEnd=new Date();
		dateStart.setHours(0);
		dateStart.setMinutes(0);
		dateStart.setSeconds(0);
		dateEnd.setHours(23);
		dateEnd.setMinutes(59);
		dateEnd.setSeconds(59);
		String dateS=df.format(dateStart);
		String dateE=df.format(dateEnd);
		String hql="select t1.tname,t2.tname,p.pname,c.place,c.date from Team as t1,Team as t2,Challenge as c,People as p"+
					" where t1.tid=c.tid1 and t2.tid=c.tid2 and c.judgeid=p.pid and c.state in(3,5) "+
					"and c.date>='"+dateS+"' and c.date<='"+dateE+"' order by c.date desc";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getMatchingListByJudgeid(int judgeid) throws ModelException
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=new Date();
		String nowTime=df.format(now);
		String hql="select t1.tname,t2.tname,t1.tpoint,t2.tpoint,p1.pname,p2.pname,c.date,p.pname,c.place,t1.tid,t2.tid "
					+"from Team as t1,Team as t2,Challenge as c,People as p,People as p1,People as p2"+
				" where t1.tid=c.tid1 and t2.tid=c.tid2 and t1.leaderid=p1.pid and t2.leaderid=p2.pid and c.judgeid=p.pid and c.state=3 "+
				"and c.judgeid="+judgeid+" and c.date>'"+nowTime+"'  order by c.date desc";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getMatchedListByJudgeid(int judgeid) throws ModelException
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=new Date();
		String nowTime=df.format(now);
		String hql="select c.cid,t1.tname,t2.tname,t1.tpoint,t2.tpoint,p1.pname,p2.pname,c.date,p.pname,c.place "
				+"from Team as t1,Team as t2,Challenge as c,People as p,People as p1,People as p2"+
			" where t1.tid=c.tid1 and t2.tid=c.tid2 and t1.leaderid=p1.pid and t2.leaderid=p2.pid and c.judgeid=p.pid and c.state=3 "+
			"and c.judgeid="+judgeid+" and c.date<'"+nowTime+"' order by c.date desc";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getUnAllowList() throws ModelException
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=new Date();
		String nowTime=df.format(now);
		String hql="select c.cid,t1.tname,t2.tname,t1.tpoint,t2.tpoint,p1.pname,p2.pname,c.date,t1.tid,t2.tid "
				+"from Team as t1,Team as t2,Challenge as c,People as p1,People as p2"+
			" where t1.tid=c.tid1 and t2.tid=c.tid2 and t1.leaderid=p1.pid and t2.leaderid=p2.pid and c.state=2 "+
			"and c.date>'"+nowTime+"' order by c.cid";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getAllowListByTid(int tid) throws ModelException
	{
		String hql="select t1.tname,t2.tname,t1.tpoint,t2.tpoint,p1.pname,p2.pname,c.date,p.pname,c.place "
				+"from Team as t1,Team as t2,Challenge as c,People as p1,People as p2,People as p "
				+"where t1.tid=c.tid1 and t2.tid=c.tid2 and t1.leaderid=p1.pid and t2.leaderid=p2.pid and c.judgeid=p.pid and c.state=3 "
				+"and (c.tid1="+tid+" or c.tid2="+tid+") "
				+"order by c.date";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getUnallowListByTid(int tid) throws ModelException
	{
		String hql="select t1.tname,t2.tname,t1.tpoint,t2.tpoint,p1.pname,p2.pname,c.date "
				+"from Team as t1,Team as t2,Challenge as c,People as p1,People as p2 "
				+"where t1.tid=c.tid1 and t2.tid=c.tid2 and t1.leaderid=p1.pid and t2.leaderid=p2.pid and c.state=2 "
				+"and (c.tid1="+tid+" or c.tid2="+tid+") "
				+"order by c.date";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getWaitAcceptListByTid(int tid) throws ModelException
	{
		String hql="select c.cid,t1.tname,t1.tpoint,p1.pname,c.date,c.tid1 "
				+"from Team as t1,Challenge as c,People as p1 "
				+"where t1.tid=c.tid1 and t1.leaderid=p1.pid and c.state=1 "
				+"and c.tid2="+tid+" "
				+"order by c.date";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getLaunchListByTid(int tid) throws ModelException
	{
		String hql="select c.cid,t2.tname,t2.tpoint,p2.pname,c.date "
				+"from Team as t2,Challenge as c,People as p2 "
				+"where t2.tid=c.tid2 and t2.leaderid=p2.pid and c.state=1 "
				+"and c.tid1="+tid+" "
				+"order by c.date";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getEndListByTid(int tid,int num) throws ModelException
	{
		String hql="select t1.tname,t2.tname,p1.pname,p2.pname,c.date,p.pname,c.place,r.t1_score,r.t2_score "
				+"from Team as t1,Team as t2,Challenge as c,People as p,People as p1,People as p2,Result r"+
			" where t1.tid=c.tid1 and t2.tid=c.tid2 and t1.leaderid=p1.pid and t2.leaderid=p2.pid and c.judgeid=p.pid and r.cid=c.cid and c.state=5 "+
			"and (c.tid1="+tid+" or c.tid2="+tid+" ) order by c.date desc";
		try{
			if(num>0)
				this.getHibernateTemplate().setMaxResults(num);
			List list=this.getHibernateTemplate().find(hql);
			this.getHibernateTemplate().setMaxResults(50);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public long getNumOfEndList(int tid) throws ModelException
	{
		String hql="select count(c.date) "
				+"from Team as t1,Team as t2,Challenge as c,People as p,People as p1,People as p2,Result r"+
			" where t1.tid=c.tid1 and t2.tid=c.tid2 and t1.leaderid=p1.pid and t2.leaderid=p2.pid and c.judgeid=p.pid and r.cid=c.cid and c.state=5 "+
			"and (c.tid1="+tid+" or c.tid2="+tid+" )";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return (Long) list.get(0);
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public Boolean delChallengeByCid(int cid) throws ModelException
	{
		try{
			Challenge c=this.getHibernateTemplate().get(Challenge.class, cid);
			this.getHibernateTemplate().delete(c);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public Boolean UpdateChallenge(Challenge challenge) throws ModelException
	{
		try{
			Challenge c=this.getHibernateTemplate().get(Challenge.class, challenge.getCid());
			c.setState(3);
			c.setJudgeid(challenge.getJudgeid());
			c.setPlace(challenge.getPlace());
			this.getHibernateTemplate().update(c);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public Boolean UpdateChallState(Challenge challenge) throws ModelException
	{
		try{
			Challenge c=this.getHibernateTemplate().get(Challenge.class, challenge.getCid());
			c.setState(2);
			this.getHibernateTemplate().update(c);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public void addChallenge(Challenge challenge) throws ModelException
	{
		try{
			this.getHibernateTemplate().save(challenge);
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public Challenge getChallengeByCid(int cid) throws ModelException
	{
		try{
			Challenge challenge=this.getHibernateTemplate().get(Challenge.class, cid);
			return challenge;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public void UpdateChallengeState(Challenge challenge) throws ModelException
	{
		try{
			this.getHibernateTemplate().update(challenge);
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public boolean checkHaveChallengeByTid(int tid) throws ModelException
	{
		String hql="from Challenge as c "+
				"where c.state in(1,2,3) and ( tid1="+tid+" or tid2="+tid+" ) ";
		try{
			List list=this.getHibernateTemplate().find(hql);
			if(list.size()>0)
				return true;
			else
				return false;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
		
	}
}
