<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
<form role="form" action="SearchUnTeamList.action" method="post">
	<label>球队搜索</label>
	<input type="text" placeholder="请输入球队名称" name="team.tname">
	<input type="submit" class="btn-primary" value="搜索">
</form>
<s:if test="#request.unTeamList.size()>0 || #request.unedTeamList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
            <th>球队编号</th>
            <th>球队名称</th>
            <th>球队人数</th>
         	<th>球队组别</th>
            <th>球队积分</th>
            <th>队长名称</th>
            <th>球队创建时间</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.unTeamList" id="unteam" status="status">
          <tr>
            <td><s:property value="#status.count"/></td>
            <td><s:property value="%{#unteam[1]}"/></td>
            <td><s:property value="%{#unteam[2]}"/></td>
            <td><s:property value="%{#unteam[3]}"/></td>
            <td><s:property value="%{#unteam[4]}"/></td>
            <td><s:property value="%{#unteam[5]}"/></td>
            <td><s:date name="#unteam[6]" format="yyyy-MM-dd HH:mm:ss"/></td>
            <td><a href="applyJoin.action?p_t.pid=<s:property value="%{#session.user.pid}"/>&p_t.tid=<s:property value="%{#unteam[0]}"/>">
            	申请加入</a></td>
          </tr>
          </s:iterator>
          <s:iterator value="#request.unedTeamList" id="unedteam" status="status">
          <tr>
            <td><s:property value="#status.count"/></td>
            <td><s:property value="%{#unedteam[1]}"/></td>
            <td><s:property value="%{#unedteam[2]}"/></td>
            <td><s:property value="%{#unedteam[3]}"/></td>
            <td><s:property value="%{#unedteam[4]}"/></td>
            <td><s:property value="%{#unedteam[5]}"/></td>
            <td><s:date name="#unedteam[6]" format="yyyy-MM-dd HH:mm:ss"/></td>
            <td>已提交申请</td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>无符合加入条件的队伍</h4>
</s:else>
</div>
</div>
   
   <%@ include file="footer.jsp" %>  