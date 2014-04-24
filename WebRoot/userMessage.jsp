<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">您的所有消息</h3>
		</div>
		<div class="panel-body">
				<table class="table table-hover">
 					<thead>
          				<tr>
            				<th>消息</th>
            				<th>时间</th>
          				</tr>
        			</thead>
        			<tbody>
        				<tr>
            				<td>恭喜你，本队的约战信息已经经过篮协管理员的同意，确定了场地和教练，请准时参加比赛</td>
            				<td>1234931241</td>
          				</tr>
          				<tr>
            				<td>你申请加入xxx球队已经获得队长的同意了，xxx队长恭喜你成为球队的一员</td>
            				<td>51324132</td>
          				</tr>
        			</tbody>
				</table>
				<s:if test="#request.UnpjTid1.size()>0 || #request.UnpjTid2.size()>0 ">
				<h3>未评价列表</h3>
				<table class="table table-hover">
 					<thead>
          				<tr>
            				<th>比赛时间</th>
            				<th>比赛场地</th>
            				<th>执场裁判</th>
            				<th>对战队伍</th>
            				<th>比分</th>
            				<th>操作</th>
          				</tr>
        			</thead>
        			<tbody>
        				<s:iterator value="#request.UnpjTid1" id="t1" status="status">
        				<tr>
            				<td><s:date name="#t1[1]" format="yyyy-MM-dd HH:mm:ss"/></td>
            				<td><s:property value="%{#t1[2]}"/></td>
            				<td><s:property value="%{#t1[3]}"/></td>
            				<td><s:property value="%{#t1[4]}"/></td>
            				<td><s:property value="%{#t1[5]}"/>/<s:property value="%{#t1[6]}"/></td>
            				<td>
            					<s:if test="#session.user.pself==1">
									<a href="toEditPingjia.action?result.cid=<s:property value="%{#t1[0]}"/>&team=1">评价</a>
								</s:if>
								<s:else>由队长评价</s:else>
            				</td>
          				</tr>
          				</s:iterator>
          				<s:iterator value="#request.UnpjTid2" id="t2" status="status">
        				<tr>
            				<td><s:date name="#t2[1]" format="yyyy-MM-dd HH:mm:ss"/></td>
            				<td><s:property value="%{#t2[2]}"/></td>
            				<td><s:property value="%{#t2[3]}"/></td>
            				<td><s:property value="%{#t2[4]}"/></td>
            				<td><s:property value="%{#t1[5]}"/>/<s:property value="%{#t1[6]}"/></td>
            				<td>
            					<s:if test="#session.user.pself==1">
									<a href="toEditPingjia.action?result.cid=<s:property value="%{#t1[0]}"/>&team=1">评价</a>
								</s:if>
								<s:else>由队长评价</s:else>
            				</td>
          				</tr>
          				</s:iterator>
        			</tbody>
				</table>
				</s:if>
        </div>
    </div>       
</div>
</div>
   
<%@ include file="footer.jsp" %>  