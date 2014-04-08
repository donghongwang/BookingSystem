<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
<s:if test="#request.matesList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
            <th>名字</th>
            <th>学号</th>
            <th>手机号码</th>
            <th>学院</th>
            <th>简介</th>
            <th>选择状态</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.matesList" id="mate" status="status">
          <s:if test="#mate.pid!=#session.user.pid">
          <tr>
            <td><s:property value="%{#mate.pname}"/></td>
            <td><s:property value="%{#mate.pxuehao}"/></td>
            <td><s:property value="%{#mate.phone}"/></td>
            <td><s:property value="%{#mate.pxueyuan}"/></td>
            <td><s:property value="%{#mate.pjianjie}"/></td> 
            <td> <a href="updateTeamLeader.action?team.leaderid=<s:property value="%{#mate.pid}"/>">任命为新队长</a></td>
          </tr>
          </s:if>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>当前没有其他球员加入</h4>
</s:else>
</div>
</div>
   
   <%@ include file="footer.jsp" %>  