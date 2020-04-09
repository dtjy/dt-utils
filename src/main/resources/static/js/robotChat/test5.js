function sendMsg(){
	
	if($("#msgBox").children().length===8){
		$("#msgBox").children().first().remove();
		var newP = "<p>"+$("#msgIn").val()+"</p>";
		$("#msgBox").append(newP);
	}else{
		var newP = "<p>"+$("#msgIn").val()+"</p>";
		$("#msgBox").append(newP);
	}
	$.ajax({
		url:"/utils/robotChat/send?content="+$("#msgIn").val(),
		type:"post",
		dataType:'json',
		contentType:"application/json",

		success:function(data){
			if($("#msgBox").children().length==10){
				$("#msgBox").children().first().remove();
				var newPs = "<p style='color:red;'>"+data.msg+"</p>";
				$("#msgBox").append(newPs);
			}else{
				var newPs = "<p style='color:red;'>"+data.msg+"</p>";
				$("#msgBox").append(newPs);
			}
		},
		error:function(){
			console.log("error");
		}
	});
}
