<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">比赛场地和裁判分配</h3>
		</div>
		<div class="panel-body">
			<form action="allowChallenge.action" method="post">
				<input type="hidden" name="challenge.cid" value="<s:property value="#parameters.cid"/>">
				<div>
					<label for="court">分配场地</label>
					<select name="challenge.place" id="court">
						<option value="场地1">场地1</option>
						<option value="场地2">场地2</option>
					</select>
				</div>
				<div>
					<label for="judge">分配裁判</label>
					<select name="challenge.judgeid" id="judge">
						<s:iterator value="#request.judgeList" id="judge" status="status">
							<option value="<s:property value="%{#judge.pid}"/>"><s:property value="%{#judge.pname}"/></option>
						</s:iterator>
						<s:if test="#request.judgeList.size()<1">
							<option value="0"/>没有裁判可选，请撤销比赛</option>
						</s:if>
					</select>
				</div>
				
				<input type="submit" class="btn btn-lg btn-primary btn-block" value="分配" />
			</form>
        </div>
    </div>       
</div>
</div>
   
<%@ include file="footer.jsp" %>  