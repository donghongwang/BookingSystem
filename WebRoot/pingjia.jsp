<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">对XXX教练进行评价</h3>
		</div>
		<div class="panel-body">
			<h4>在本次比赛中，由XXX教练担当裁判，请评价对此裁判的表现以做往后的教练审核，谢谢</h4>
			<form action="updatePingjia.action" method="post" >
				<input type="hidden" name="result.cid" value="<s:property value="%{#request.result.cid}"/>" />
				<input type="hidden" name="teamid" value="<s:property value="%{#parameters.team}"/>" />
				<div>
					<input type="radio" name="appraisalJudge" value="3" id="score3" /><label for="score3">3分，特别满意</label>
				</div>
				<div>
					<input type="radio" name="appraisalJudge" value="2" id="score2" /><label for="score2">2分，满意</label>
				</div>
				<div>
					<input type="radio" name="appraisalJudge" value="1" id="score1" /><label for="score1">1分，无所谓</label>
				</div>
				<div>
					<input type="radio" name="appraisalJudge" value="0" id="score0" /><label for="score0">0分，我抗议</label>
				</div>
				<input type="submit" class="btn btn-lg btn-primary btn-block" value="评价" />
			</form>
        </div>
    </div>       
</div>
</div>
   
<%@ include file="footer.jsp" %>  