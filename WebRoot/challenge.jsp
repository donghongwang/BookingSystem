<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  

<div class="col-md-9">
	<h3>2014深大篮球夏季赛</h3>
<p class="lead">约战说明</p>
<!--随便搞的一段文字-->
     约战须知：　外交部副部长程国平表示，
     日本领导人悍然参拜供奉有二战甲级战犯的靖国神社，
     公然为法西斯和军国主义招魂，
     遭到中国人民以及其他爱好和平的国家人民坚决反对和一致谴责。
     关于中日领导人是否会面问题，中方已明确表达了严正立场。
     在日本领导人彻底纠正其错误立场前，中方不会考虑同他进行任何形式的接触。
     
   <form role="form" action="searchChallengeTeam.action" method="post">
	<label>球队搜索</label>
	<input type="text" placeholder="请输入球队名称" name="team.tname">
	<input type="submit" class="btn-primary" value="搜索">
</form>
<s:if test="#request.challengeTeamList.size()>0">
<table class="table table-hover">
 <thead>
          <tr>
            <th>队伍编号</th>
            <th>球队名称</th>
            <th>队长名称</th>
            <th>球队组别</th>
            <th>积分</th>
            <th>创建时间</th>
            <th>操作选择</th>
           
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.challengeTeamList" id="team" status="status">
          <tr>
          	<td><s:property value="#status.count"/></td>
            <td><s:property value="%{#team[1]}"/></td>
            <td><s:property value="%{#team[2]}"/></td>
            <td><s:property value="%{#team[3]}"/></td>
            <td><s:property value="%{#team[4]}"/></td>
            <td><s:date name="#team[5]" format="yyyy-MM-dd"/></td>
            <s:if test="#session.user.pself==1">
            	<td><a href="toChallengeinfo.action?tid2=<s:property value="%{#team[0]}"/>">发起挑战</a></td>
            </s:if>
            <s:elseif test="#session.user.pself==0">
            	<td>联系队长约战</td>
            </s:elseif>
            <td><a class="detailTeam" title='<s:property value="%{#team[0]}"/>'>队伍信息</a></td>
          </tr>
          <tr>
          	<td colspan="8">
          		<div class='showTeam<s:property value="%{#team[0]}"/>'></div>
          	</td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>查找挑战队伍失败，可能的原因：</h4>
	<ul>
		<li>本队队伍人数不足，必须有4人的队伍才能发起挑战</li>
		<li>没有满足条件的可挑战队伍</li>
	</ul>
</s:else>
</div>

</div>
   
   <%@ include file="footer.jsp" %>  