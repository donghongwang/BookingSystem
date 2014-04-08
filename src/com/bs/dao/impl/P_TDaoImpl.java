package com.bs.dao.impl;

import java.util.List;

import com.bs.dao.P_TDao;
import com.bs.exception.ModelException;
import com.bs.bean.P_T;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class P_TDaoImpl extends HibernateDaoSupport implements P_TDao {
	public void addTeammate(P_T p_t) throws ModelException
	{
		try{
			this.getHibernateTemplate().save(p_t);
	    }catch(Exception e){
	    	e.printStackTrace();
	    	throw new ModelException(1,e.getMessage());  
	    }
	}
	public void delMatesByPid(int pid) throws ModelException
	{
		String hql="from P_T as pt where pt.pid="+pid;
		try{
			List list=this.getHibernateTemplate().find(hql);
			if(list.size()>0)
				this.getHibernateTemplate().deleteAll(list);
	    }catch(Exception e){
	    	e.printStackTrace();
	    	throw new ModelException(1,e.getMessage());  
	    }
	}
	public List getP_TByPid(int pid,int state) throws ModelException
	{
		String hql="from P_T as pt where pt.pid="+pid+" and pt.state="+state;
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
	    }catch(Exception e){
	    	e.printStackTrace();
	    	throw new ModelException(1,e.getMessage());  
	    }
	}
	public boolean addApplyJoin(P_T pt) throws ModelException
	{
		try{
			this.getHibernateTemplate().save(pt);
			return true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    	throw new ModelException(1,e.getMessage());  
	    }
	}
	public void delP_tByTid(int tid,int state) throws ModelException
	{
		String hql="from P_T as pt where pt.tid="+tid+" and pt.state="+state;
		try{
			List list=this.getHibernateTemplate().find(hql);
			if(list.size()>0)
				this.getHibernateTemplate().deleteAll(list);
	    }catch(Exception e){
	    	e.printStackTrace();
	    	throw new ModelException(1,e.getMessage());  
	    }
	}
}
