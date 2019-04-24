/**
 * 
 */

function InitData(url){
	$.ajax({
		url: url,
		type: "GET",
		success:function(result) {
			alert(result);
		}
	})
	window.location.href = url;
}

function imageOnclick(url){
	window.location.href = url;
}