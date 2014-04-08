<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="../head.jsp" %>
<%@ include file="../left.jsp"%>  
<div class="col-md-9">
<p class="lead">下列是由您执裁的已结束的比赛，各队对裁判您的评价</p>
<s:if test="#request.pjList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
          	<th>比赛编号</th>
            <th>挑战队伍1</th>
            <th>挑战队伍2</th>
            <th>比赛时间</th>
            <th>裁判名称</th>
            <th>比赛场地</th>
            <th>队1评价</th>
            <th>队2评价</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.pjList" id="pj" status="status">
          <tr>
            <td><s:property value="#status.count"/></td>
            <td><s:property value="%{#pj[0]}"/>(<s:property value="%{#pj[2]}"/>队长)</td>
            <td><s:property value="%{#pj[1]}"/>(<s:property value="%{#pj[3]}"/>队长)</td>
            <td><s:date name="#pj[4]" format="yyyy-MM-dd HH:mm:ss"/></td>
            <td><s:property value="%{#pj[5]}"/></td>
            <td><s:property value="%{#pj[6]}"/></td>
            <td>
            	<s:if test="#pj[7]>=0">
            		<s:property value="%{#pj[7]}"/>(分)
            	</s:if>
            	<s:else>尚未评价</s:else>
            </td>
            <td>
            	<s:if test="#pj[8]>=0">
            		<s:property value="%{#pj[8]}"/>(分)
            	</s:if>
            	<s:else>尚未评价</s:else>
            </td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>暂时没有比赛评价</h4>
</s:else>
</div>
</div>
   
   <%@ include file="../footer.jsp" %>  