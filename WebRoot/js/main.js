$(document).on("blur","#exampleInputName",function(){
	if(this.value=="")
		$("#pnameError").text("(用户名不能为空)");
	else
	{
		$.getJSON("checkUsername", function(data) {
        	$("#pnameError").html("");
        	if(data.used=="no")
        		$("#pnameError").html("用户名可以使用");
        	else
        		$("#pnameError").html("用户名已被使用，请重新填写");
		});
	}
});