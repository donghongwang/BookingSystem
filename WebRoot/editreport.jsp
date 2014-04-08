<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">比赛结果录入</h3>
		</div>
		<div class="panel-body">
			<h4><s:property value="%{#request.chall[1]}"/> VS <s:property value="%{#request.chall[2]}"/></h4>
			<hr />
			<form action="updateResult.action" method="post">
				<input type="hidden" name="result.cid" value="<s:property value="%{#request.chall[0]}"/>">
				<div>
					<h4>队伍：<s:property value="%{#request.chall[1]}"/></h4>
					<label>得分：</label>
					<input type="text" name="result.t1_score" />
				</div>
				<hr />
				<div>
					<h4>队伍：<s:property value="%{#request.chall[2]}"/></h4>
					<label>得分：</label>
					<input type="text" name="result.t2_score" />
				</div>
				<hr />
				<div>
					<label>胜利球队所得积分</label>
					<input type="text" name="tpoint" />
				</div>
				<input type="submit" class="btn btn-lg btn-primary btn-block" value="结果录入" />
			</form>
        </div>
    </div>       
</div>
</div>
   
<%@ include file="footer.jsp" %>  