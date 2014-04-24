<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="../head.jsp" %>
<%@ include file="../left.jsp"%>  
<div class="col-md-9">
<p class="lead">下列的比赛将由教练你来充当裁判，请准时到达比赛场地</p>
<s:if test="#request.matchingList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
          	<th>比赛编号</th>
            <th>比赛队名</th>
            <th>球队积分</th>
            <th>队长名称</th>
            <th>比赛时间</th>
            <th>裁判名称</th>
            <th>比赛场地</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.matchingList" id="match" status="status">
          <tr>
          	<td><s:property value="#status.count"/></td>
            <td><s:property value="%{#match[0]}"/>VS<s:property value="%{#match[1]}"/></td>
            <td><s:property value="%{#match[2]}"/>/<s:property value="%{#match[3]}"/></td>
            <td><s:property value="%{#match[4]}"/>/<s:property value="%{#match[5]}"/></td>
            <td><s:date name="#match[6]" format="yyyy-MM-dd HH:mm:ss"/></td>
            <td><s:property value="%{#match[7]}"/></td>
            <td><s:property value="%{#match[8]}"/></td>
            <td><a class="detailTeams" title='<s:property value="%{#match[9]}"/>:<s:property value="%{#match[10]}"/>'>所有队伍信息</a></td>
          </tr>
          <tr>
          	<td colspan="8">
          		<div class='showTeams<s:property value="%{#match[9]}"/><s:property value="%{#match[10]}"/>'></div>
          	</td>
          </tr>
          </s:iterator> 
        </tbody>
</table>
</s:if>
<s:else>
	<h4>暂时没有比赛需要您的执裁</h4>
</s:else>
</div>
</div>
   
   <%@ include file="../footer.jsp" %>  