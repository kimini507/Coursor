$(document).ready(function(){

	bindCreateModalEvents();
});

function bindCreateModalEvents(){
  $("#CREATE_COURSE_SUBMIT").on("click",function(){
    var course = {
        "code": $("#COURSE_CODE").val(),
        "title": $("#COURSE_TITLE").val()
      }
    
    showLoadingCover($("#CREATE_COURSE_MODAL div.modal-body"));
    doAjaxRequest('manage/a/course/', course, createCourseCallback);
  });
}

function createCourseCallback(data){
  if(data.status == "OK"){
    window.location = "manage/a/course/"+data.course.code;
  } else {
    console.log("SHOW ERROR HERE")
  }
}