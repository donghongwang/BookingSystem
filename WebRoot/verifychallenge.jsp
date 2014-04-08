<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<%@ include file="left.jsp"%>  
<div class="col-md-9">
	<h3>2014深大篮球夏季赛-约战审核</h3>
<p class="lead">约战说明</p>
<!--随便搞的一段文字-->
     约战须知：　外交部副部长程国平表示，
     日本领导人悍然参拜供奉有二战甲级战犯的靖国神社，
     公然为法西斯和军国主义招魂，
     遭到中国人民以及其他爱好和平的国家人民坚决反对和一致谴责。
     关于中日领导人是否会面问题，中方已明确表达了严正立场。
     在日本领导人彻底纠正其错误立场前，中方不会考虑同他进行任何形式的接触。   
<s:if test="#request.unallowList.size()>0"> 
<table class="table table-hover">
 <thead>
          <tr>
            <th>约战编号</th>
            <th>约战队名</th>
            <th>球队积分</th>
            <th>队长名称</th>
            <th>约战时间</th>
            <th>操作选择</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator value="#request.unallowList" id="match" status="status">
          <tr>
            <td><s:property value="#status.count"/></td>
            <td><s:property value="%{#match[1]}"/>VS<s:property value="%{#match[2]}"/></td>
            <td><s:property value="%{#match[3]}"/>/<s:property value="%{#match[4]}"/></td>
            <td><s:property value="%{#match[5]}"/>/<s:property value="%{#match[6]}"/></td>
            <td><s:date name="#match[7]" format="yyyy-MM-dd HH:mm:ss"/></td>
            <td>
            	<a href="toAllowChallenge.action?cid=<s:property value="%{#match[0]}"/>">批准</a>
            	<a href="rejectChallenge.action?challenge.cid=<s:property value="%{#match[0]}"/>">撤销</a>
            </td>
          </tr>
          </s:iterator>
        </tbody>
</table>
</s:if>
<s:else>
	<h4>暂时没有比赛需要审核</h4>
</s:else>
</div>
</div>
   
   <%@ include file="footer.jsp" %>  