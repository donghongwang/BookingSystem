<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-5">
	<div class="panel panel-info">
	<div class="panel-heading">
		<h3 class="panel-title">个人信息编辑</h3>
	</div>
	<div class="panel-body">
	<div class="well">
			<form role="form" action="updateUserInfo.action" method="post">
				<input type="hidden" name="people.pid" value="<s:property value="%{#session.user.pid}" />" />
				<div class="form-group">
					<label for="exampleInputRealName">姓名</label>
					<input type="text" class="form-control" id="exampleInputRealName" placeholder="请输入真实姓名" name="people.prealname">
				</div>
  				<div class="form-group">
    				<label for="exampleInputXuehao">学号</label>
    				<input type="text" class="form-control" id="exampleInputXuehao" placeholder="请输入学号" name="people.pxuehao">
  				</div>
  				<div class="form-group">
    				<label>性别</label>
    				<input type="radio" class="form-control" id="exampleInputPsex1" name="people.psex" value="男">
    				<label for="exampleInputPsex1">男</label>
    				<input type="radio" class="form-control" id="exampleInputPsex2" name="people.psex" value="女">
    				<label for="exampleInputPsex2">女</label>
  				</div>
  				<div class="form-group">
    				<label for="exampleInputTelephone">手机号码</label>
    				<input type="text" class="form-control" id="exampleInputTelephone" placeholder="请输入手机号码" name="people.phone">
  				</div>
  				<div class="form-group">
    				<label for="exampleInputDuanhao">手机短号</label>
    				<input type="text" class="form-control" id="exampleInputDuanhao" placeholder="请输入手机短号" name="people.pduanhao">
  				</div>
  				<div class="form-group">
    				<label for="exampleInputXueyuan">所属学院</label>
    				<input type="text" class="form-control" id="exampleInputXueyuan" placeholder="请输入所属学院" name="people.pxueyuan">
  				</div>
  				<div class="form-group">
    				<label for="exampleInputAddress">宿舍地址</label>
    				<input type="text" class="form-control" id="exampleInputAddress" placeholder="请输入宿舍地址" name="people.paddress">
  				</div>
  				<div class="form-group">
    				<label for="exampleInputJianjie">简介</label>
    				<textarea class="form-control" id="exampleInputJianjie" placeholder="请输入简介..." name="people.pjianjie"></textarea>
  				</div>
  				<button type="submit" class="btn btn-lg btn-primary btn-block">保存（一经保存将不可修改）</button>
  				<button type="reset" class="btn btn-lg btn-primary btn-block">重置</button>
  			</form>
    </div>
    </div>
    </div>
</div>
</div>
<%@ include file="footer.jsp" %>  