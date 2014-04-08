<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>

  <!-- 注册模块-->
         <div >
<button class="btn btn-lg btn-primary btn-block" data-toggle="modal" data-target="#myModal">
  注册
</button>
<!-- 弹出-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">注册页面</h4>
      </div>
      <div class="modal-body">
         <form role="form" action="register.action" method="post">
  
  <div class="form-group">
    <label for="exampleInputName">用户名</label>
    <input type="text" class="form-control" id="exampleInputName" placeholder="请输入用户名" name="people.pname" />
    <span id="pnameError"></span>
  </div>
  <script>
  		$(document).on("blur","#exampleInputName",function(){
			if(this.value=="")
				$("#pnameError").text("(用户名不能为空)");
			else
			{
				$.post("checkUsername.action",{"people.pname":this.value}, function(data) {
        			$("#pnameError").html("");
        			if(data.used=="no")
        				$("#pnameError").html("用户名可以使用");
        			else
        				$("#pnameError").html("用户名已被使用，请重新填写");
				},"JSON");
			}
		});
  </script>
  <div class="form-group">
    <label for="exampleInputPassword1">密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="people.password" />
  </div>
   <div class="form-group">
    <label for="exampleInputPassword2">确认密码</label>
    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="请再次输入密码" name="passwordAgain" />
  </div>
   
  <button type="submit" class="btn btn-lg btn-primary btn-block">提交</button>

  <button type="reset" class="btn btn-lg btn-primary btn-block">重置</button>
   
  </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
       
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>