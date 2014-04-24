<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf8">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
     <link href="<%=basePath%>/css/theme.css" rel="stylesheet">
    <link href="<%=basePath%>/css/sticky-footer.css" rel="stylesheet">
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
   
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
  	<script src="js/ajaxJS.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
 
     <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.action">约战系统</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" >个人信息<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="lookUserInfo.action">查看个人信息</a></li>
                <li><a href="editUserInfo.action">编辑个人信息</a></li>
                <li><a href="toUserMsg.action">查看所有消息</a></li>
              </ul>
            </li> 
            <li><a href="unTeamList.action">加入球队</a></li>
            <li><a href="teamReging.action">球队注册</a></li>
           	<li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" >队长/球员选项<b class="caret"></b></a>
              <ul class="dropdown-menu">
                
                <li><a href="allowList.action">查看约战信息</a></li>
                <li><a href="challengeTeam.action">发起挑战</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">球队管理</li>              
                <li><a href="teamMessage.action">球队信息</a></li>
                <li><a href="regNewLeader.action">重新任命队长</a></li>
                <li><a href="quitOfTeam.action">退出球队</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" >篮协管理员选项<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="unAllowList.action">比赛审核</a></li>
                <li><a href="judgePerformList.action">裁判表现</a></li>
              </ul>
            </li> 
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" >裁判选项<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="matchingList.action">即将进行的比赛</a></li>
                <li><a href="matchedList.action">比赛结果录入</a></li>
                <li><a href="pingjiaList.action">比赛评价</a></li>
              </ul>
            </li> 
            <li><a href="scoreSort.action">积分排名</a></li>
            <li><a href="about.action">关于我们</a></li>
            <li><a href="exit.action">退出</a></li>
          </ul>
        </div>
        <!--/.nav-collapse -->
      </div>
    </div>
 