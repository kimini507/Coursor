/**
 * 
 */

$(document).ready(function(){
  bindOutlineEvents();
  bindTopicModalEvents();
  bindCreateSlideModalEvents();
  bindEditorEvents();
});

function initializeOutline(code){
  showLoadingCover($("#OUTLINE_PANEL div.panel-body"));
  
  var url = "get/course/outline";
  var data = {
    code:code
  }
  doAjaxRequest(url, data, showCourseOutlineCallback);
}

function showCourseOutlineCallback(data){
  CourseOutline.data = data;
  var topics = buildTemplate("topicblock", {topics:data.topics});

  var addTopicBlock = $("#ADD_TOPIC_BLOCK");
  
  hideLoadingCover($("#OUTLINE_PANEL div.panel-body"));

  addTopicBlock.before(topics);
  $('[data-toggle="tooltip"]').tooltip()
}

function bindOutlineEvents(){
	$("#OUTLINE_PANEL").on("click", ".topic-slide", editSlide);
	$("#OUTLINE_PANEL").on("click", ".topic-block .delete-slide", confirmDeleteSlide);
	$("#OUTLINE_PANEL").on("click", ".topic-block .delete-topic", confirmDeleteTopic);
}

function bindTopicModalEvents(){
  $('#TOPIC_MODAL').on('show.bs.modal',  function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var topicId;
    if(button){
      topicId = button.closest(".topic-block").data('topic-id') // Extract info from data-* attributes
      $("#TOPIC_ID").val(topicId);
      var topic = CourseOutline.getTopic(topicId, "id");
      if(topic){
	      $("#TOPIC_HEADER").val(topic.header);
	      $("#TOPIC_DESCRIPTION").val(topic.description);
      }
    }
  });

  $("#TOPIC_SUBMIT").on("click",saveTopic);
}

function saveTopic(){
  showLoadingCover($("#TOPIC_MODAL div.modal-body"));
  var curTopic = $("#TOPIC_ID").val();
  var url = curTopic?"update/a/topic/":"create/a/topic/";
  var data = {
      "header": $("#TOPIC_HEADER").val(),
      "description": $("#TOPIC_DESCRIPTION").val(),
      "id": curTopic,
      "course": {
       	"id": $("#COURSE_ID").val()
      }
    }
  var topicCallback = curTopic?updateTopicCallback:createTopicCallback;
  doAjaxRequest(url, data, topicCallback);
}

function createTopicCallback(data){
  var topicBlock = buildTemplate("topicblock",{topics:[data]});
  
  var addTopicBlock = $("#ADD_TOPIC_BLOCK");
  
  addTopicBlock.before(topicBlock);
  $('[data-toggle="tooltip"]').tooltip()

  resetCreateTopicModal();
  $("#TOPIC_MODAL").modal('hide');
  CourseOutline.addTopic(data);
  hideLoadingCover($("#TOPIC_MODAL div.modal-body"));
}

function resetCreateTopicModal(){
  $("#TOPIC_HEADER").val("");
  $("#TOPIC_DESCRIPTION").val("");
  $("#TOPIC_ID").val("");
}

function bindCreateSlideModalEvents(){
  $('#SLIDE_MODAL').on('show.bs.modal',  function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var topicId = button.closest(".topic-block").data('topic-id') // Extract info from data-* attributes
    var slideId = button.closest(".topic-slide").data('slide-id') // Extract info from data-* attributes
    var slide = button.closest(".topic-slide") // Extract info from data-* attributes
    var slideHeader = slide.find(".slide-header-text");
    
    if(slideHeader){
      $("#SLIDE_HEADER").val(slideHeader.html());
      var type = slide.data('slide-type');
      type = type? type : "VIDEO";
      $("#SLIDE_TYPE").val(type);
    }
    
    $("#TOPIC_ID").val(topicId);
    $("#SLIDE_ID").val(slideId);
  });


  $("#SLIDE_SUBMIT").on("click", decideSlideAction);
}

function decideSlideAction(e){
  var slideAction = $("#SLIDE_ID").val() ? updateSlide : createSlide;
  slideAction(e);
}

function createSlide(){
  showLoadingCover($("#SLIDE_MODAL div.modal-body"));
  
  var url = "create/a/slide/";
  var data = {
      "header": $("#SLIDE_HEADER").val(),
      "type": $("#SLIDE_TYPE").val(),
      "id": $("#SLIDE_ID").val(),
      "topic":{
    	  "id": $("#TOPIC_ID").val(),
      }
    }
  doAjaxRequest(url, data, createSlideCallback);
}

function createSlideCallback(data){
  var slideRow = buildTemplate("sliderow",data);
  
  var addNewSlide = $("[data-topic-id="+$("#TOPIC_ID").val()+"]").find(".add-new-slide");
  
  addNewSlide.before(slideRow);
  $('[data-toggle="tooltip"]').tooltip()
  
//  resetCreateTopicModal();
  $("#SLIDE_MODAL").modal('hide');
  hideLoadingCover($("#SLIDE_MODAL div.modal-body"));
  $("#SLIDE_ID").val("");
}

function updateSlide(){
  showLoadingCover($("#SLIDE_MODAL div.modal-body"));
  var topicId = $("#TOPIC_ID").val();
  var url = "update/a/slide/";
  var data = {
      "header": $("#SLIDE_HEADER").val(),
      "type": $("#SLIDE_TYPE").val(),
      "id": $("#SLIDE_ID").val(),
      "topic":{
    	  "id": topicId
      }
    }
  doAjaxRequest(url, data, function(data){updateSlideCallback(data, topicId)});
}

function updateSlideCallback(slide, topicId){
  var topic = CourseOutline.getTopic(topicId);
  var slideRow = CourseOutline.getSlide(topic, slide.id);

  slideRow.header = slide.header;
  var slideElem = $(".topic-slide[data-slide-id="+slide.id+"]");
  
  slideElem.find(".slide-header-text").html(slide.header);
  slideElem.attr("data-slide-type", slide.type);
  
  $("#SLIDE_MODAL").modal('hide');
  hideLoadingCover($("#SLIDE_MODAL div.modal-body"));
  $("#SLIDE_ID").val("");
}

function bindEditorEvents(){
  $("#PREVIEW_SLIDE_SUBMIT").on("click", previewSlide);
  $("#SAVE_SLIDE_SUBMIT").on("click", saveSlide);
}

function editSlide(e){
  $("#SAMPLE_EDITOR").show();
  
  var slideId = $(e.currentTarget).attr("data-slide-id");
  var topicId = $($(e.currentTarget).closest(".topic-block")).attr("data-topic-id");

  removeActiveClasses();
  $(e.currentTarget).addClass("active");
  
  $("#SELECTED_SLIDE").val(slideId);
  $("#SELECTED_TOPIC").val(topicId);
  
  var topic = CourseOutline.getTopic(topicId, "id");
  var content = CourseOutline.getSlide(topic, slideId).content;
  
  content = content ? content : false;
  
  tinyMCE.activeEditor.setContent(JSON.parse(content));
//  var content = tinyMCE.activeEditor.getContent()
}


function removeActiveClasses(){
  $("#OUTLINE_PANEL div.panel-body").find(".active").removeClass("active");
}


function previewSlide(e){
  $("#SLIDE_PREVIEW_MODAL .modal-body").html(tinyMCE.activeEditor.getContent());
  $("#SLIDE_PREVIEW_MODAL").modal('show');
  
}

function saveSlide(){
  showLoadingCover($("#SAMPLE_EDITOR"), "Saving Slide");
  var url = "save/a/slide/";
  
  var content = tinyMCE.activeEditor.getContent();
  var topicId = $("#SELECTED_TOPIC").val();
  var slideId = $("#SELECTED_SLIDE").val();
  var data = {
      id: slideId,
      content: JSON.stringify(content),
      topic: {
        id: topicId
      }
    }
  
  doAjaxRequest(url, data, function(data){
    saveSlideCallback(data, topicId, slideId);
  });
}

function saveSlideCallback(data, topicId, slideId){
  hideLoadingCover($("#SAMPLE_EDITOR"));
  CourseOutline.saveSlide(data, topicId, slideId);
}

function confirmDeleteTopic(e){
  var topicId = $(e.currentTarget).closest(".topic-block").attr("data-topic-id");
  
  bootbox.confirm({
    message:"Are you sure you want to delete this item?", 
    callback:function(result){
      if(result){
        deleteTopic(topicId);
      }
    }
  });  
}

function deleteTopic(topicId){
  var url = "delete/a/topic/";
  var data = {
      id: topicId,
      course: {
        id: $("#COURSE_ID").val()
      }
    }
  
  doAjaxRequest(url, data, deleteTopicCallback);
  
}

function deleteTopicCallback(data){
  CourseOutline.removeTopic(data.id, "id");
  
  $("#OUTLINE_PANEL [data-topic-id="+data.id+"]").remove();
}


function confirmDeleteSlide(e){
  var topicId = $(e.currentTarget).closest(".topic-block").attr("data-topic-id");
  var slideId = $(e.currentTarget).closest(".topic-slide").attr("data-slide-id");
  bootbox.confirm({
    message:"Are you sure you want to delete this item?", 
    callback:function(result){
      if(result){
        deleteSlide(topicId, slideId);
      }
    }
  });  
}

function deleteSlide(topicId, slideId){
  var url = "delete/a/slide/";
  var data = {
      id: slideId
    }
  
  doAjaxRequest(url, data, function(data){deleteSlideCallback(data.id, topicId)});
}

function deleteSlideCallback(slideId, topicId){
  CourseOutline.removeSlide(slideId, topicId, "id");
  var slide = $("#OUTLINE_PANEL [data-slide-id="+slideId+"]")
  if(slide.hasClass("active")){
    tinyMCE.activeEditor.setContent("");
    $("#SAMPLE_EDITOR").hide();
  }
  slide.remove();
}

function updateTopicCallback(data){
  var topic = CourseOutline.getTopic(data.id);
  topic.header = data.header;
  var topicheader = $("[data-topic-id="+data.id+"] span.topic-header-text");
  topicheader.html(data.header);
  topicheader.attr("data-original-title",data.header);
  hideLoadingCover($("#TOPIC_MODAL div.modal-body"));
  $("#TOPIC_MODAL").modal('hide');
}

//function updateSlideDetails(e){
//  var slideRow = $(e.target).closest(".topic-slide");
//  var slideId = slideRow.attr("data-slide-id");
//  var slideType = slideRow.attr("data-slide-type");
//  
//  $()
//  
//}
