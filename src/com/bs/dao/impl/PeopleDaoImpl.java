package com.bs.dao.impl;


import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.bs.bean.People;
import com.bs.dao.PeopleDao;
import com.bs.exception.ModelException;


public class PeopleDaoImpl extends HibernateDaoSupport implements PeopleDao{
	
	public People selectByName(final String pname,final String password) throws ModelException
	{
		String hql="from People as p where p.pname='"+pname+"' and p.password=MD5('"+password+"')";
		try{
			List list=this.getHibernateTemplate().find(hql);
			if(list.size()>0)
				return (People)list.get(0);
			else return null;
		}catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }
	}
	
	public People registerUser(People people) throws ModelException
	{
		String hql="from People as p where p.pname='"+people.getPname()+"'";
		try{
    		this.getHibernateTemplate().save(people);
    		List list=this.getHibernateTemplate().find(hql);
    		if(list.size()>0)
				return (People)list.get(0);
			else return null;
    	}catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }	
	}
	
	public People updateUserInfo(People people) throws ModelException
	{
		People peo= (People) this.getHibernateTemplate().get(People.class, people.getPid());
		try{
			peo.setPrealname(people.getPrealname());
        	peo.setPxuehao(people.getPxuehao());
        	peo.setPsex(people.getPsex());
        	peo.setPhone(people.getPhone());
        	peo.setPduanhao(people.getPduanhao());
        	peo.setPaddress(people.getPaddress());
        	peo.setPxueyuan(people.getPxueyuan());
        	peo.setPjianjie(people.getPjianjie());
         
		 this.getHibernateTemplate().saveOrUpdate(peo);
        }catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }
		return peo;
	}
	public void updateUserSelf(People people) throws ModelException
	{
		try{
		 this.getHibernateTemplate().saveOrUpdate(people);
        }catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }
	}
	public People getUserByPid(int pid) throws ModelException
	{
		try{
			 People people=(People)this.getHibernateTemplate().get(People.class,pid);
			 return people;
	    }catch(Exception e){
	        e.printStackTrace();
	        throw new ModelException(1,e.getMessage());  
	    }
	}
	public List getTeammatesByTid(int tid) throws ModelException
	{
		String hql="from People as p where p.pid in(select pt.pid from P_T as pt where pt.state=1 and pt.tid="+tid+")";
		try{
    		List list=this.getHibernateTemplate().find(hql);
			return list;
    	}catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }	
	}
	
	public List getApplyersByTid(int tid) throws ModelException
	{
		String hql="from People as p where p.pid in(select pt.pid from P_T as pt where pt.state=0 and pt.tid="+tid+")";
		try{
    		List list=this.getHibernateTemplate().find(hql);
			return list;
    	}catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }	
	}
	public List getJudgeList() throws ModelException
	{
		String hql="from People as p where p.pself=2";
		try{
    		List list=this.getHibernateTemplate().find(hql);
			return list;
    	}catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }	
	}
	public People checkByName(final String pname) throws ModelException
	{
		String hql="from People as p where p.pname='"+pname+"'";
		try{
			List list=this.getHibernateTemplate().find(hql);
			if(list.size()>0)
				return (People)list.get(0);
			else return null;
		}catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }
	}
	
	public List getTeamMemMsg(int tid) throws ModelException
	{
		String hql="from People as p where pid in(select pid from P_T as pt where state=1 and tid="+tid+")";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }
	}
	
}
