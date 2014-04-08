<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<div class="row">
 <div class="col-md-4"></div>
       <div class="col-md-4">
        <div class="jumbotron">
  <form role="form" action="login.action" method="post">
  
  <div class="form-group">
    <label for="exampleInputName">用户名</label>
    <input type="text" class="form-control" id="exampleInputName" placeholder="请输入用户名" name="people.pname">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">密码</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="people.password">
  </div>
  <div> 
    <p>
      <a href="<%=basePath%>/login/forgetPass.jsp">忘记密码?</a>
    </p>
  </div>
  <button type="submit" class="btn btn-lg btn-primary btn-block">登录</button>

  <button type="reset" class="btn btn-lg btn-primary btn-block">重置</button>
   
  </form>
       </div>
<%@ include file="register.jsp" %>
<%@ include file="footer.jsp" %>
