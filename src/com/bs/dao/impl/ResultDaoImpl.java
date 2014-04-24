package com.bs.dao.impl;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bs.bean.People;
import com.bs.bean.Result;
import com.bs.dao.ResultDao;
import com.bs.exception.ModelException;
public class ResultDaoImpl extends HibernateDaoSupport implements ResultDao{
	
	public List getPjListByJudgeid(int judgeid) throws ModelException
	{
		String hql="select t1.tname,t2.tname,p1.pname,p2.pname,c.date,p.pname,c.place,r.t1_appraisalJudge,r.t2_appraisalJudge,r.t1_score,r.t2_score "
				+"from Team as t1,Team as t2,Challenge as c,People as p,People as p1,People as p2,Result r"+
			" where t1.tid=c.tid1 and t2.tid=c.tid2 and t1.leaderid=p1.pid and t2.leaderid=p2.pid and c.judgeid=p.pid and r.cid=c.cid and c.state=5 "+
			"and c.judgeid="+judgeid+" order by c.date desc";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getJudgePerformence() throws ModelException
	{
		String hql="select p.pname,count(r.cid),avg(r.t1_appraisalJudge),avg(r.t2_appraisalJudge) "
					+"from People p, Result r "
					+"where p.pself=2 and p.pid=r.judgeid "
					+"group by p.pid order by p.pid";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getJudgeUnperformence() throws ModelException
	{
		String hql="select p.pname from People p "
				+"where p.pself=2 and p.pid not in(select r.judgeid from Result as r)";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public void addResult(Result result) throws ModelException
	{
		try{
			this.getHibernateTemplate().save(result);
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getUnPingjiaByTid1(int tid) throws ModelException
	{
		String hql="select r.cid,c.date,c.place,p.pname,t.tname,r.t1_score,r.t2_score "
					+"from Result as r,Challenge as c,People as p,Team as t "
					+"where r.t1_appraisalJudge<0 and r.cid=c.cid and p.pid=c.judgeid and t.tid=c.tid2 and c.tid1="+tid
					+" order by c.date desc";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public List getUnPingjiaByTid2(int tid) throws ModelException
	{
		String hql="select r.cid,c.date,c.place,p.pname,t.tname,r.t2_score,r.t1_score "
					+"from Result as r,Challenge as c,People as p,Team as t "
					+"where r.t2_appraisalJudge<0 and r.cid=c.cid and p.pid=c.judgeid and t.tid=c.tid1 and c.tid2="+tid
					+" order by c.date desc";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public void updatePingjia(int cid,int pjNum,String teamid) throws ModelException
	{
		try{
			Result r=this.getHibernateTemplate().get(Result.class, cid);
			if(teamid.equals("1"))
				r.setT1_appraisalJudge(pjNum);
			else if(teamid.equals("2"))
				r.setT2_appraisalJudge(pjNum);
			this.getHibernateTemplate().update(r);
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public boolean checkPingjiaByTid(int tid) throws ModelException
	{
		String hql1="select r.cid "
				+"from Result as r,Challenge as c "
				+"where r.t1_appraisalJudge<0 and c.state=5 and r.cid=c.cid and c.tid1="+tid;
		String hql2="select r.cid "
				+"from Result as r,Challenge as c "
				+"where r.t2_appraisalJudge<0 and c.state=5 and r.cid=c.cid and c.tid2="+tid;
		try{
			List list1=this.getHibernateTemplate().find(hql1);
			List list2=this.getHibernateTemplate().find(hql2);
			if(list1.size()>0 || list2.size()>0)
				return false;
			else
				return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
}
