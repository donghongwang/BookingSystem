<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">个人信息</h3>
		</div>
		<div class="panel-body">
			<div class="well">
				<p><span>用户名：</span>
					<span><s:property value="%{#session.user.pname}" /></span>
				</p>
				<p><span>姓名：</span>
					<span>
						<s:if test='%{#session.user.prealname==null || #session.user.prealname==""}'>尚未填写</s:if>
                		<s:else><s:property value="%{#session.user.prealname}" /></s:else>
					</span>
				</p>
				<p><span>学号：</span>
					<span>
						<s:if test='%{#session.user.pxuehao==null || #session.user.pxuehao==""}'>尚未填写</s:if>
                		<s:else><s:property value="%{#session.user.pxuehao}" /></s:else>
					</span>
				</p>
				<p><span>性别：</span>
					<span>
						<s:if test='%{#session.user.psex==null || #session.user.psex==""}'>尚未填写</s:if>
                		<s:else><s:property value="%{#session.user.psex}" /></s:else>
					</span>
				</p>
				<p><span>手机号码：</span>
					<span>
						<s:if test='%{#session.user.phone==null || #session.user.phone==""}'>尚未填写</s:if>
                		<s:else><s:property value="%{#session.user.phone}" /></s:else>
					</span>
				</p>
				<p><span>手机短号：</span>
					<span>
						<s:if test='%{#session.user.pduanhao==null || #session.user.pduanhao==""}'>尚未填写</s:if>
                		<s:else><s:property value="%{#session.user.pduanhao}" /></s:else>
					</span>
				</p>
				<p><span>宿舍地址：</span>
					<span>
						<s:if test='%{#session.user.paddress==null || #session.user.paddress==""}'>尚未填写</s:if>
                		<s:else><s:property value="%{#session.user.paddress}" /></s:else>
					</span>
				</p>
				<p><span>所属学院：</span>
					<span>
						<s:if test='%{#session.user.pxueyuan==null || #session.user.pxueyuan==""}'>尚未填写</s:if>
                		<s:else><s:property value="%{#session.user.pxueyuan}" /></s:else>
					</span>
				</p>
				<p><span>简介：</span>
					<span>
						<s:if test='%{#session.user.pjianjie==null || #session.user.pjianjie==""}'>尚未填写</s:if>
                		<s:else><s:property value="%{#session.user.pjianjie}" /></s:else>
					</span>
				</p>
				<p><span>身份：</span>
					<span>
						<s:if test='%{#session.user.pself==-1}'>普通用户</s:if>
                		<s:elseif test='%{#session.user.pself==0}'>普通球员</s:elseif>
                		<s:elseif test='%{#session.user.pself==1}'>球队队长</s:elseif>
                		<s:elseif test='%{#session.user.pself==2}'>裁判</s:elseif>
                		<s:elseif test='%{#session.user.pself==3}'>篮协管理员</s:elseif>
					</span>
				</p>
            </div>
        </div>
    </div>       
</div>
</div>
   
<%@ include file="footer.jsp" %>  