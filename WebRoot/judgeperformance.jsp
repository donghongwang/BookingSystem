<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="../head.jsp" %>
<%@ include file="../left.jsp"%>  
<div class="col-md-9">
<p class="lead">下列是各裁判的表现列表</p>
<s:if test="#request.jedgePerformList.size()>0 || #request.jedgeUnperformList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
            <th>裁判名称</th>
            <th>到场次数</th>
            <th>执裁次数</th>
            <th>发起挑战队评价</th>
            <th>接受挑战队评价</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.jedgePerformList" id="perform" status="status">
          <tr>  
            <td><s:property value="%{#perform[0]}"/></td>
            <td><s:property value="%{#perform[1]}"/>(次)</td>
            <td><s:property value="%{#perform[1]}"/>(次)</td>
            <td><s:property value="%{#perform[2]}"/>(分)</td>
            <td><s:property value="%{#perform[3]}"/>(分)</td>
          </tr>
          </s:iterator>
          <s:iterator value="#request.jedgeUnperformList" id="perform" status="status">
          <tr>  
            <td><s:property value="%{#perform}"/></td>
            <td>0(次)</td>
            <td>0(次)</td>
            <td>尚无队伍评价</td>
            <td>尚无队伍评价</td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>暂时没有有关裁判的评价</h4>
</s:else>
</div>
</div>
   
   <%@ include file="../footer.jsp" %>  