<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
<s:if test="#request.myTeam.isEmpty()">
	<h4>获取球队信息失败，可能的原因为：</h4>
	<ul>
		<li>还未加入 球队</li>
		<li>操作频繁，数据获取错误，请稍后重试</li>
	</ul>
</s:if>
<s:else>
<h3>队名：<s:property value="%{#request.myTeam.tname}"/></h3>
<p class="lead">球队简介：<s:property value="%{#request.myTeam.tjianjie}"/></p>
<p class="lead">球员信息：</p>
<table class="table table-hover">
 <thead>
          <tr>
            <th>名字</th>
            <th>学号</th>
            <th>手机号码</th>
            <th>学院</th>
            <th>简介</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.matesList" id="mate" status="status">
          <tr>
            <td><s:property value="%{#mate.pname}"/></td>
            <td><s:property value="%{#mate.pxuehao}"/></td>
            <td><s:property value="%{#mate.phone}"/></td>
            <td><s:property value="%{#mate.pxueyuan}"/></td>
            <td><s:property value="%{#mate.pjianjie}"/></td> 
            <td> 
            <s:if test="%{#mate.pid==#request.myTeam.leaderid}">
            	队长
            </s:if>
            <s:else>
            	<s:if test="#session.user.pself==0">球员</s:if>
            	<s:else><a href="delTeammate.action?p_t.pid=<s:property value="%{#mate.pid}"/>&p_t.tid=<s:property value="%{#request.myTeam.tid}"/>">移出该球队</a></s:else>
            </s:else>
            </td>
          </tr>
          </s:iterator>
        </tbody>
</table>
<s:if test="#request.applyList.size()>0">
<hr />
<p class="lead">申请信息：</p>
<table class="table table-hover">
 <thead>
          <tr>
            <th>名字</th>
            <th>学号</th>
            <th>手机号码</th>
            <th>学院</th>
            <th>简介</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.applyList" id="applyer" status="status">
          <tr>
            <td><s:property value="%{#applyer.pname}"/></td>
            <td><s:property value="%{#applyer.pxuehao}"/></td>
            <td><s:property value="%{#applyer.phone}"/></td>
            <td><s:property value="%{#applyer.pxueyuan}"/></td>
            <td><s:property value="%{#applyer.pjianjie}"/></td>  
            <td>
            	<s:if test="#session.user.pself==1">
					<a href="addTeammate.action?p_t.tid=<s:property value="%{#request.myTeam.tid}"/>&p_t.pid=<s:property value="%{#applyer.pid}"/>">允许加入</a>
				</s:if>
				<s:else>队长决定是否允许加入</s:else>
			</td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
</s:else>
</div>
</div>
   
   <%@ include file="footer.jsp" %>  