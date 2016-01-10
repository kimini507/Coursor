function doAjaxRequest(url, data, callback){
  $.ajax({
    url: url,
    data: JSON.stringify(data),
    type: "POST",
    beforeSend: function(xhr) {
      xhr.setRequestHeader("Accept", "application/json");
      xhr.setRequestHeader("Content-Type", "application/json");
      xhr.setRequestHeader("X-CSRF-TOKEN", getCSRFToken());
    },
    success: callback,
    fail: showError
  });
}

function showError(data){
  console.log("AjaxFail: ")
  console.log(data);
  
}

function getCSRFToken(){
	return $("[name=_csrf]").val();
}
