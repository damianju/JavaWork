var depth = 1;
var parent = 0;


$(document).ready(function(){
	loadPage(depth, parent);
	
$("#mycate span:nth-child(1) select").change(function(){
	if(depth == 1 && $(this).val() != ""){
		window.depth ++;
		window.parent = $(this).val();
		loadPage(depth, parent);
	} else if($(this).val() == "") {
		disable1();
	} else {
		window.parent = $(this).val();
		disable2();
	}
});

$("#mycate span:nth-child(2) select").change(function(){
	if(depth == 2 && $(this).val() != ""){
		window.depth ++;
		window.parent = $(this).val();
		loadPage(depth, parent);
	} else if($(this).val() == "") {
		disable3();
	} else {
		window.parent = $(this).val();
		disable4();
	}
});
	
});

function loadPage(depth, parent){
	$.ajax({
		url: "cate_list.ajax"
		, type: "POST"
		, cache: false
		, data : {
			'depth' : depth
			, 'parent': parent
		}
		, success: function(data, status){
			if(status == "success"){
				updateList(data)
			}
		}
	});
} // end loadPage()

function updateList(jsonObj){
	
	result="";

	if(jsonObj.status == "OK"){
		 
			var count = jsonObj.count;
			
			var i;
			var items = jsonObj.data;
			
			//result+= "<option value='' disabled selected data-default>--선택하세요--</option>"
			result+= "<option value='' selected data-default>--선택하세요--</option>"
				for(i=0; i<count; i++){
					result += "<option value='" + items[i].uid + "'>" + items[i].name + "</option>"
				}
			$("#mycate span:nth-child("+depth+") select").attr("disabled", false);
			$("#mycate span:nth-child("+depth+") select").html(result);

			//window.depth ++;
			//alert(depth);
		//return true;
	} else{
		//alert("에러1");
		alert(jsonObj.message);
		//return false;
	} 
	//return false;
} // end updateList()


function disable1(){
	result= "<option value='' selected data-default>--선택하세요--</option>"
	$("#mycate span:nth-child(2) select").html(result);
	$("#mycate span:nth-child(2) select").attr("disabled", true);
	
	result= "<option value='' selected data-default>--선택하세요--</option>"
	$("#mycate span:nth-child(3) select").html(result);
	$("#mycate span:nth-child(3) select").attr("disabled", true);
	
};

function disable2(){
	window.depth = 2;
	loadPage(depth, parent);
	
	result= "<option value='' selected data-default>--선택하세요--</option>"
	$("#mycate span:nth-child(3) select").html(result);
	$("#mycate span:nth-child(3) select").attr("disabled", true);
	
};

function disable3(){
	result= "<option value='' selected data-default>--선택하세요--</option>"
	$("#mycate span:nth-child(3) select").html(result);
	$("#mycate span:nth-child(3) select").attr("disabled", true);
	
};

function disable4(){
	window.depth = 3;
	loadPage(depth, parent);
	
};
