<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-5">
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">球队注册</h3>
	</div>
	<div class="panel-body">
			<form role="form" action="teamReged.action" method="post">
  				<div class="form-group">
    				<label for="exampleInputTname">球队名称</label>
    				<input type="text" class="form-control" id="exampleInputTname" placeholder="请输入球队名称" name="team.tname">
  				</div>
  				<div class="form-group">
    				<label for="exampleInputTjianjie">球队简介</label>
    				<textarea class="form-control" id="exampleInputTjianjie" placeholder="请输入球队的相关介绍，为自己的球队设计一句霸气的口号" name="team.tjianjie"></textarea>
  				</div>
  				
  				<button type="submit" class="btn btn-lg btn-primary btn-block">注册球队</button>
  				<button type="reset" class="btn btn-lg btn-primary btn-block">重置</button>
  			</form>
    </div>
    </div>
</div>
</div>
<%@ include file="footer.jsp" %>  