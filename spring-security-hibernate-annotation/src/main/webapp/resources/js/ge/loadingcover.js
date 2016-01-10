
$(document).ready(function(){
	$.extend(window, {lcover : $("#LOADING_COVER")});
});

function showLoadingCover(element, label){
	var list = [];
	if(element instanceof Array){
		list = element;
	}else{
		list.push($(element));
	}
	
	if(!label){
		label = "Loading"
	}

	for(var key in list){
		_showLoadingCover(list[key], label);
	}
	
	
	function _showLoadingCover(elem, label){
		elem.find("*").hide();
		var loader = lcover.clone();
		loader.find(".sk-text h4").html(label);
		loader.appendTo(elem);
	}
}

function hideLoadingCover(element){
	var list = [];
	if(element instanceof Array){
		list = element;
	}else{
		list.push($(element));
	}
	
	for(var key in list){
		_hideLoadingCover(list[key]);
	}
	
	function _hideLoadingCover(elem){
		elem.find("*").show();
		elem.find("#LOADING_COVER").remove();
	}

}