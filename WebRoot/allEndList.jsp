<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="../head.jsp" %>
<%@ include file="../left.jsp"%>  
<div class="col-md-9">

<p class="lead">以往所有比赛</p>

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
          <s:iterator value="#request.allEndList" id="match" status="status">
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

</div>
</div>
   
   <%@ include file="../footer.jsp" %>  