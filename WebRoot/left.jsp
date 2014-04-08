<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>


<div class="container">
    <div class="col-md-3">
      <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">体育项目</h3>
            </div>
            <div class="panel-body">
             <select class="form-control">
             <option>3对3篮球</option>
             <option>5对5篮球</option>
             <option>羽毛球单打</option>
             <option>羽毛球双打</option>
             <option>游泳</option>
             </select>
            </div>
          </div>
           <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">个人信息</h3>
            </div>
            <div class="panel-body">
              <div class="well">
                <p>用户名：<s:property value="%{#session.user.pname}" /></p>
                <p>姓名：
                	<s:if test='%{#session.user.prealname==null || #session.user.prealname==""}'>尚未填写</s:if>
                	<s:else><s:property value="%{#session.user.prealname}" /></s:else>
                </p>
                <p>身份：
                	<s:if test='%{#session.user.pself==-1}'>普通用户</s:if>
                	<s:elseif test='%{#session.user.pself==0}'>普通球员</s:elseif>
                	<s:elseif test='%{#session.user.pself==1}'>球队队长</s:elseif>
                	<s:elseif test='%{#session.user.pself==2}'>裁判</s:elseif>
                	<s:elseif test='%{#session.user.pself==3}'>篮协管理员</s:elseif>
                </p>
                <p>所属学院：
                	<s:if test='%{#session.user.pxueyuan==null || #session.user.pxueyuan==""}'>尚未填写</s:if>
                	<s:else><s:property value="%{#session.user.pxueyuan}" /></s:else>
                </p>
              </div>
            </div>
          </div>
           <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">流程说明</h3>
            </div>
            <div class="panel-body">
             
                <h4>系统流程</h4>
                        <ul>
                          <li>1、注册</li>
                            <li>2、联系</li>
                            <li>3、提交约战</li>
                            <li>4、对手确认</li>
                            <li>5、管理员确认</li>
                            <li>6、按时比赛</li>
                        </ul>
                
             
            </div>
          </div>
        </div>
  