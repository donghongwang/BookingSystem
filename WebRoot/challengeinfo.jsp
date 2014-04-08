<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ include file="head.jsp" %>
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

<%@ include file="left.jsp"%>  
<div class="col-md-9">
	<h3>2014深大篮球夏季赛</h3>

<form action="addChallengeinfo.action" class="form-horizontal"  role="form">
		<input type="hidden" name="challenge.tid2" value="<s:property value="#parameters.tid2" /> " />
        <fieldset>
            <legend>选择时间</legend>
            <div class="form-group">
                <label for="dtp_input1" class="col-md-2 control-label">时间</label>
                <div class="input-group date form_datetime col-md-5" data-date="2014-01-21T05:25:07Z" data-date-format="yyyy-MM-dd HH:mm:ss" data-link-field="dtp_input1">
                    <input class="form-control" size="16" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
					<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
				<input type="hidden" id="dtp_input1" value="" name="dateString" /><br/>
            </div>
            <input type="submit" class="btn btn-default btn-lg" value="提交" /> 
			</fieldset>
    </form>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	$('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 0,
		maxView: 1,
		forceParse: 0
    });
</script>
</div>
</div>
   
   <%@ include file="footer.jsp" %>  