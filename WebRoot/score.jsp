<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
	<h3>2014深大篮球夏季赛-积分排名</h3>
	<form role="form" action="searchScoreSort.action" method="post">
		<label>球队搜索</label>
		<input type="text" placeholder="请输入球队名称" name="team.tname">
		<input type="submit" class="btn-primary" value="搜索">
		</form>
<s:if test="#request.scoreSortList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
            <th>积分排名</th>
            <th>球队名称</th>
            <th>队长名称</th>
            <th>球队组别</th>
            <th>积分</th>
            <th>创建时间</th>
            <th>场次</th>
            <th>胜</th>
            <th>负</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.scoreSortList" id="soteam" status="status">
          <tr>
            <td><s:property value="#status.count"/></td>
            <td><s:property value="%{#soteam[1]}"/></td>
            <td><s:property value="%{#soteam[2]}"/></td>
            <td><s:property value="%{#soteam[3]}"/></td>        
            <td><s:property value="%{#soteam[4]}"/></td>
            <td><s:date name="#soteam[5]" format="yyyy-MM-dd"/></td>
            <td>4</td>
            <td>4</td>
            <td>0</td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>搜索不到符合条件的队伍</h4>
</s:else>
</div>
</div>
   
   <%@ include file="footer.jsp" %>  