// JavaScript Document

$(document).on("blur","#exampleInputNameR",function(){
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

$(document).on("click",".detailTeam",function(){
	var id=this.title;
	$("div[class*=showTeam]").html("");
	$.post("teamMemMsg.action",{"tid":id}, function(data) {
		$(".showTeam"+id).html("");
		$(".showTeam"+id).append("<table class='table'><tbody>");
		$.each(data.teamMemMsgs,function(i,item){
			$(".showTeam"+id).append("<tr>");
			
			$(".showTeam"+id).append("<td>"+item.pname+"</td>");
			$(".showTeam"+id).append("<td>"+item.prealname+"</td>");			
			$(".showTeam"+id).append("<td>"+item.pxuehao+"</td>");			
			$(".showTeam"+id).append("<td>"+item.phone+"</td>");		
			$(".showTeam"+id).append("<td>"+item.pduanhao+"</td>");			
			$(".showTeam"+id).append("<td>"+item.paddress+"</td>");			
			$(".showTeam"+id).append("<td>"+item.pxueyuan+"</td>");
			
			$(".showTeam"+id).append("</tr>");
		});
		$(".showTeam"+id).append("</tbody></table>");
	},"JSON");
	$(this).text("隐藏信息");
	$(".closeDetail").text("队伍信息");
	$(".closeDetail").addClass("detailTeam");
	$(".closeDetail").removeClass("closeDetail");
	$(this).addClass("closeDetail");
	$(this).removeClass("detailTeam");
});

$(document).on("click",".closeDetail",function(){
	$("div[class*=showTeam]").html("");
	$(this).text("队伍信息");
	$(this).addClass("detailTeam");
	$(this).removeClass("closeDetail");
});


$(document).on("click",".detailTeams",function(){
	var id=this.title;
	var ids=id.split(":");
	$("div[class*=showTeams]").html("");
	$.post("teamMemMsg.action",{"tid":ids[0]}, function(data) {
		$(".showTeams"+id[0]+""+ids[1]).append("<table class='table'><tbody>");
		$.each(data.teamMemMsgs,function(i,item){
			$(".showTeams"+id[0]+""+ids[1]).append("<tr>");
			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.pname+"</td>");
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.prealname+"</td>");			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.pxuehao+"</td>");			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.phone+"</td>");		
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.pduanhao+"</td>");			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.paddress+"</td>");			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.pxueyuan+"</td>");
			
			$(".showTeams"+id[0]+""+ids[1]).append("</tr>");
		});
		$(".showTeams"+id[0]+""+ids[1]).append("</tbody></table>");
	},"JSON");
	$.post("teamMemMsg.action",{"tid":ids[1]}, function(data) {
		$(".showTeams"+id[0]+""+ids[1]).append("<table class='table'><tbody>");
		$.each(data.teamMemMsgs,function(i,item){
			$(".showTeams"+id[0]+""+ids[1]).append("<tr>");
			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.pname+"</td>");
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.prealname+"</td>");			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.pxuehao+"</td>");			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.phone+"</td>");		
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.pduanhao+"</td>");			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.paddress+"</td>");			
			$(".showTeams"+id[0]+""+ids[1]).append("<td>"+item.pxueyuan+"</td>");
			
			$(".showTeams"+id[0]+""+ids[1]).append("</tr>");
		});
		$(".showTeams"+id[0]+""+ids[1]).append("</tbody></table>");
	},"JSON");
	$(this).text("隐藏所有信息");
	//$(this).text(ids[0]+","+ids[1]);
	$(".closeDetails").text("所有队伍信息");
	$(".closeDetails").addClass("detailTeams");
	$(".closeDetails").removeClass("closeDetails");
	$(this).addClass("closeDetails");
	$(this).removeClass("detailTeams");
});

$(document).on("click",".closeDetails",function(){
	$("div[class*=showTeams]").html("");
	$(this).text("所有队伍信息");
	$(this).addClass("detailTeams");
	$(this).removeClass("closeDetails");
});
