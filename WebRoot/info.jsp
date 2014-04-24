<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="../head.jsp" %>
<%@ include file="../left.jsp"%>  
<div class="col-md-9">

<p class="lead">正式比赛</p>
<s:if test="#request.allowList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
            <th>挑战队名</th>
            <th>球队积分</th>
            <th>队长名称</th>
            <th>比赛时间</th>
            <th>裁判名称</th>
            <th>比赛场地</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.allowList" id="match" status="status">
          <tr>
            <td><s:property value="%{#match[0]}"/>VS<s:property value="%{#match[1]}"/></td>
            <td><s:property value="%{#match[2]}"/>/<s:property value="%{#match[3]}"/></td>
            <td><s:property value="%{#match[4]}"/>/<s:property value="%{#match[5]}"/></td>
            <td><s:date name="#match[6]" format="yyyy-MM-dd HH:mm:ss"/></td>
            <td><s:property value="%{#match[7]}"/></td>
            <td><s:property value="%{#match[8]}"/></td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h5>暂时没有约战信息</h5>
</s:else>
<hr />

<p class="lead">等待审核</p>
<s:if test="#request.unallowList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
            <th>挑战队名</th>
            <th>球队积分</th>
            <th>队长名称</th>
            <th>比赛时间</th>
 			<th>当前状态</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.unallowList" id="match" status="status">
          <tr>
            <td><s:property value="%{#match[0]}"/>VS<s:property value="%{#match[1]}"/></td>
            <td><s:property value="%{#match[2]}"/>/<s:property value="%{#match[3]}"/></td>
            <td><s:property value="%{#match[4]}"/>/<s:property value="%{#match[5]}"/></td>
            <td><s:date name="#match[6]" format="yyyy-MM-dd HH:mm:ss"/></td>
			<td>正在审核当中...</td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h5>暂时没有约战信息</h5>
</s:else>
<hr />

<p class="lead">等待接受</p>
<s:if test="#request.waitAcceptList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
            <th>挑战队名</th>
            <th>球队积分</th>
            <th>队长名称</th>
            <th>比赛时间</th>
            <th>选择状态</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.waitAcceptList" id="match" status="status">
          <tr>
            <td><s:property value="%{#match[1]}"/></td>
            <td><s:property value="%{#match[2]}"/></td>
            <td><s:property value="%{#match[3]}"/></td>
            <td><s:date name="#match[4]" format="yyyy-MM-dd HH:mm:ss"/></td>
			<td>
				<s:if test="#session.user.pself==1">
					<a href="allowMatch.action?challenge.cid=<s:property value="%{#match[0]}"/>">接受</a> 
					<a href="rejectMatch.action?challenge.cid=<s:property value="%{#match[0]}"/>">拒绝</a>
				</s:if>
				<s:else>队长决定接受或拒绝</s:else>
			</td>
			<td><a class="detailTeam" title='<s:property value="%{#match[5]}"/>'>队伍信息</a></td>
          </tr>
          <tr>
          	<td colspan="6">
          		<div class='showTeam<s:property value="%{#match[5]}"/>'></div>
          	</td>
          </tr>
          </s:iterator>     
        </tbody>
</table>
</s:if>
<s:else>
	<h5>暂时没有约战信息</h5>
</s:else>
<hr />

<p class="lead">已发起的挑战</p>
<s:if test="#request.launchList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
            <th>挑战队名</th>
            <th>球队积分</th>
            <th>队长名称</th>
            <th>比赛时间</th>
            <th>选择状态</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.launchList" id="match" status="status">
          <tr>
            <td><s:property value="%{#match[1]}"/></td>
            <td><s:property value="%{#match[2]}"/></td>
            <td><s:property value="%{#match[3]}"/></td>
            <td><s:date name="#match[4]" format="yyyy-MM-dd HH:mm:ss"/></td>
			<td>
				<s:if test="#session.user.pself==1">
					<a href="rejectMatch.action?challenge.cid=<s:property value="%{#match[0]}"/>">撤销</a>
				</s:if>
				<s:else>队长决定是否撤销</s:else>
			</td>
          </tr>
          </s:iterator>     
        </tbody>
</table>
</s:if>
<s:else>
	<h5>暂时没有发起挑战信息</h5>
</s:else>
<hr />

<p class="lead">
	以往比赛
	<s:if test="#request.isMore=='yes'">
		<a href="getAllEndList.action">查看更多</a>
	</s:if>
</p>
<s:if test="#request.endList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
          	<th>比赛编号</th>
            <th>挑战队伍1</th>
            <th>挑战队伍2</th>
            <th>比赛时间</th>
            <th>裁判名称</th>
            <th>比赛场地</th>
            <th>队1得分</th>
            <th>队2得分</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.endList" id="match" status="status">
          <tr>
            <td><s:property value="#status.count"/></td>
            <td><s:property value="%{#match[0]}"/>(<s:property value="%{#match[2]}"/>队长)</td>
            <td><s:property value="%{#match[1]}"/>(<s:property value="%{#match[3]}"/>队长)</td>
            <td><s:date name="#match[4]" format="yyyy-MM-dd HH:mm:ss"/></td>
            <td><s:property value="%{#match[5]}"/></td>
            <td><s:property value="%{#match[6]}"/></td>
            <td><s:property value="%{#match[7]}"/></td>
            <td><s:property value="%{#match[8]}"/></td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>暂时没有以往比赛</h4>
</s:else>

</div>
</div>
   
   <%@ include file="../footer.jsp" %>  