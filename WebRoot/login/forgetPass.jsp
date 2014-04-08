<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>


<div class="row">
 <div class="col-md-4"></div>
       <div class="col-md-4">
        <div class="jumbotron">
  <form role="form" action="#" method="post">
  
  <div class="form-group">
    <label for="exampleInputName">姓名</label>
    <input type="text" class="form-control" id="exampleInputName" placeholder="请输入姓名" name="user.username">
  </div>
  <div class="form-group">
    <label for="exampleInputPasskey">安全码</label>
    <input type="text" class="form-control" id="exampleInputPasskey" placeholder="请输入修改密码所需的安全码" name="user.psecurity">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">新密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入新密码">
  </div>
   <div class="form-group">
    <label for="exampleInputPassword1">确认新密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请再次输入新密码">
  </div>
  <button type="submit" class="btn btn-lg btn-primary btn-block">修改新密码</button>

  <button type="reset" class="btn btn-lg btn-primary btn-block">重置</button>
   
  </form>
  <p>
      <a href="<%=basePath%>/login/main.jsp">返回登录</a>
  </p>
       </div>     
<%@ include file="footer.jsp" %>