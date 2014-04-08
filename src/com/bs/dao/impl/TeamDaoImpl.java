package com.bs.dao.impl;

import java.util.List;
import com.bs.dao.TeamDao;
import com.bs.exception.ModelException;
import com.bs.bean.Team;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class TeamDaoImpl extends HibernateDaoSupport implements TeamDao {
	public int teamRegister(Team team) throws ModelException
	{
		try{
    		 return ((Integer)this.getHibernateTemplate().save(team)).intValue();
    	}catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }
	}
	public List getUnTeamList(String tname,String psex,int pid) throws ModelException
	{
		String hql;
		if(tname.equals(""))
			hql="select distinct t.tid,t.tname,t.tnumbers,t.tsex,t.tpoint,p.pname,t.createtime"
				+" from Team as t,People as p,P_T as pt "
				+"where pt.tid=t.tid and t.leaderid=p.pid and t.tnumbers<4 and t.tsex='"+psex+"' " 
				+"and pt.tid not in(select pt1.tid from P_T as pt1 where pt1.pid="+pid+")";
		else
			hql="select distinct t.tid,t.tname,t.tnumbers,t.tsex,t.tpoint,p.pname,t.createtime"
					+" from Team as t,People as p,P_T as pt "
					+"where t.tname like '%"+tname+"%' and pt.tid=t.tid and t.leaderid=p.pid and t.tnumbers<4 and t.tsex='"+psex+"' "
					+"and pt.tid not in(select pt1.tid from P_T as pt1 where pt1.pid="+pid+")";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
        	e.printStackTrace();
        	throw new ModelException(1,e.getMessage());  
        }
	}
	public List getUnedTeamList(String tname,String psex,int pid) throws ModelException
	{
		String hql;
		if(tname.equals("") || tname==null)
			hql="select distinct t.tid,t.tname,t.tnumbers,t.tsex,t.tpoint,p.pname,t.createtime"
				+" from Team as t,People as p,P_T as pt "
				+"where pt.tid=t.tid and pt.pid="+pid+" and t.leaderid=p.pid and t.tnumbers<4 and t.tsex='"+psex+"'";
		else
			hql="select distinct t.tid,t.tname,t.tnumbers,t.tsex,t.tpoint,p.pname,t.createtime"
					+" from Team as t,People as p,P_T as pt "
					+"where t.tname like '%"+tname+"%' and pt.tid=t.tid and pt.pid="+pid+" and t.leaderid=p.pid and t.tnumbers<4 and t.tsex='"+psex+"'";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}	
	}
	public List getScoreSortList(String tname) throws ModelException
	{
		String hql;
		if(tname.equals("") || tname==null)
			hql="select t.tid,t.tname,p.pname,t.tsex,t.tpoint,t.createtime"
				+" from Team as t,People as p "
				+"where t.leaderid=p.pid and t.tnumbers=4 order by t.tpoint desc";
		else
			hql="select t.tid,t.tname,p.pname,t.tsex,t.tpoint,t.createtime"
					+" from Team as t,People as p "
					+"where t.tname like '%"+tname+"%' and t.leaderid=p.pid and t.tnumbers=4 order by t.tpoint desc";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}	
	}
	public List getChallengeTeamList(String tname,int tid) throws ModelException
	{
		String hql;
		if(tname.equals("") || tname==null)
			hql="select t.tid,t.tname,p.pname,t.tsex,t.tpoint,t.createtime"
				+" from Team as t,People as p "
				+"where t.leaderid=p.pid and t.tnumbers=4 and t.tid!="+tid+" "
				+"order by t.tpoint desc";
		else
			hql="select t.tid,t.tname,p.pname,t.tsex,t.tpoint,t.createtime"
					+" from Team as t,People as p "
					+"where t.tname like '%"+tname+"%' and t.leaderid=p.pid and t.tnumbers=4 and t.tid!="+tid+" "
					+"order by t.tpoint desc";
		try{
			List list=this.getHibernateTemplate().find(hql);
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}	
	}
	public Team getTeamByTid(int tid) throws ModelException
	{
		try{
			Team team=this.getHibernateTemplate().get(Team.class, tid);
			return team;
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public void updateTeamNumber(int tid,int num) throws ModelException
	{
		try{
			Team team=this.getHibernateTemplate().get(Team.class, tid);
			team.setTnumbers(team.getTnumbers()+num);
			this.getHibernateTemplate().update(team);
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public void deleteTeamByTid(int tid) throws ModelException
	{
		try{
			Team team=this.getHibernateTemplate().get(Team.class, tid);
			this.getHibernateTemplate().delete(team);
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public void updateTeamLeader(int tid,int leaderid) throws ModelException
	{
		try{
			Team team=this.getHibernateTemplate().get(Team.class, tid);
			team.setLeaderid(leaderid);
			this.getHibernateTemplate().update(team);
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
	public void updateTeam(Team team) throws ModelException
	{
		try{
			this.getHibernateTemplate().update(team);
		}catch(Exception e){
			e.printStackTrace();
			throw new ModelException(1,e.getMessage());  
		}
	}
}
