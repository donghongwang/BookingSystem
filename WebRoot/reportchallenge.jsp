<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="../head.jsp" %>
<%@ include file="../left.jsp"%>  
<div class="col-md-9">
<p class="lead">下列比赛已结束，请裁判及时录入比赛结果</p>
<s:if test="#request.matchedList.size()>0">
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
            <th>操作选择</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.matchedList" id="match" status="status">
          <tr>
          	<td><s:property value="#status.count"/></td>
            <td><s:property value="%{#match[1]}"/>VS<s:property value="%{#match[2]}"/></td>
            <td><s:property value="%{#match[3]}"/>/<s:property value="%{#match[4]}"/></td>
            <td><s:property value="%{#match[5]}"/>/<s:property value="%{#match[6]}"/></td>
            <td><s:date name="#match[7]" format="yyyy-MM-dd HH:mm:ss"/></td>
            <td><s:property value="%{#match[8]}"/></td>
            <td><s:property value="%{#match[9]}"/></td>
           	<td><a href="toEditreport.action?challenge.cid=<s:property value="%{#match[0]}"/>">结果录入</a></td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>暂时没有比赛结果需要录入</h4>
</s:else>
</div>
</div>
   
   <%@ include file="../footer.jsp" %>  