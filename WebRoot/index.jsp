<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
	<h3>2014深大篮球夏季赛-今日比赛</h3>
	<s:if test="#request.todayMatchList.size()>0">
<table class="table table-hover">
 <thead>
 		
          <tr>
            <th>比赛编号</th>
            <th>比赛球队</th>
            <th>当值裁判</th>
            <th>场地</th>
            <th>比赛时间</th>
          </tr>
        </thead>
        <tbody>
          
          <s:iterator value="#request.todayMatchList" id="tmatch" status="status">
          <tr>
            <td><s:property value="#status.count"/></td>
            <td><s:property value="%{#tmatch[0]}"/>VS<s:property value="%{#tmatch[1]}"/></td>
            <td><s:property value="%{#tmatch[2]}"/></td>
            <td><s:property value="%{#tmatch[3]}"/></td>
            <td><s:date name="#tmatch[4]" format="yyyy-MM-dd HH:mm:ss"/></td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>今天没有比赛</h4>
</s:else>
</div>
</div>
   
   <%@ include file="footer.jsp" %>  