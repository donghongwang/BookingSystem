package com.bs.service;
import java.util.List;

import com.bs.bean.P_T;
import com.bs.exception.ModelException;
public interface P_TService {
	public void addTeammate(P_T p_t) throws ModelException;
	public void delMatesByPid(int pid) throws ModelException;
	public List getP_TByPid(int pid,int state) throws ModelException;
	public boolean addApplyJoin(P_T pt) throws ModelException;
	public void delP_tByTid(int tid,int state) throws ModelException;
}
