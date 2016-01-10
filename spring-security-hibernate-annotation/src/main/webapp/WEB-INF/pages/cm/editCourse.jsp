<%@page import="com.coursor.app.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="en">
  <head>
  	<%@include file="../fr/header.jsp" %>
	
	<!-- page specific resources/settings -->
	<link href="resources/css/cc/cc.css" rel="stylesheet" />
  </head>
  <body>

    <div class="container-fluid">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" id="COURSE_CODE" value="${courseCode}"/>
		<input type="hidden" id="COURSE_ID" value="${courseId}"/>
		<input type="hidden" id="TOPIC_ID" value=""/>
		<input type="hidden" id="SLIDE_ID" value=""/>
		<input type="hidden" id="SELECTED_SLIDE" value=""/>
		<input type="hidden" id="SELECTED_TOPIC" value=""/>
		
		<!-- NAVBAR START -->
		<%@include file="../fr/navbar.jsp" %>
		
		<!-- CONTENT AREA -->
		<div id="OUTLINE_PANEL" class="outline-panel col-md-3">
			<div class="col-md-12">
				<div class="panel-header">
					<h2> Course Outline </h2>
				</div>
				<div class="panel-body">
				
				
					<div id="ADD_TOPIC_BLOCK" class="topic-block"> 
						<div class="topic-header">
							<button class="btn btn-md add-topic-button" data-toggle="modal" data-target="#TOPIC_MODAL" >
								<span class="glyphicon glyphicon-plus"></span>
								Add topic 
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div id="EDIT_CONTENT_CONTAINER" class="col-md-9">
			<div id="SAMPLE_EDITOR" style="display: none">
				<textarea id="SLIDE_EDITOR">
				</textarea>
				<div class = "btn-bar">
					<button id="SAVE_SLIDE_SUBMIT" type="button" class="btn btn-primary">
						<span class="glyphicon glyphicon-floppy-disk"></span>
						Save
					</button>
					<button id="PREVIEW_SLIDE_SUBMIT" type="button" class="btn btn-primary">
						<span class="glyphicon glyphicon-eye-open"></span>
						Preview
					</button>
					<button id="EDIT_QUIZ_SUBMIT" type="button" class="btn btn-link">
						<span class="glyphicon glyphicon-pencil"></span>
						Go to Quiz Editor
					</button>
				</div>
			</div>
		</div>
		<div>
		</div>
	</div>
	

<div class="modal fade" id="TOPIC_MODAL" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
          		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		<h4 style="color:#337ab7;"><span class="glyphicon glyphicon-plus"></span> Add Topic </h4>
        	</div>
        	<div>
	        	<div class="modal-body">
	        		<div class="">
					    <form:form id="topicForm" onsubmit="return false;" method="POST" class="form-horizontal">
							<div class="form-group">
								<div class="col-md-2">
									<label for="TOPIC_HEADER">
										Header
									</label>
								</div>
								<div class="col-md-10">
									<input id="TOPIC_HEADER" class="col-md-12" type="text" name="topicHeader" placeholder="Enter Topic Header"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-2">
									<label for="TOPIC_DESCRIPTION">
										Description
									</label>
								</div>
								<div class="col-md-10">
									<input id="TOPIC_DESCRIPTION" class="col-md-12" type="text" name="topicDescription" placeholder="Enter Topic Description"/>
								</div>
							</div>
						</form:form>
					</div>
	        	</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default pull-right" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
					<button id="TOPIC_SUBMIT" type="submit" class="btn btn-primary pull-right" ><span class="glyphicon glyphicon-plus"></span> Submit</button>
				</div>
			</div>
		</div>
	</div>	
</div>

<div class="modal fade" id="SLIDE_MODAL" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
          		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		<h4 style="color:#337ab7;"><span class="glyphicon glyphicon-plus"></span> Add Topic </h4>
        	</div>
        	<div>
	        	<div class="modal-body">
	        		<div class="">
					    <form:form id="slideForm" onsubmit="return false;" class="form-horizontal">
							<div class="form-group">
								<div class="col-md-2">
									<label for="SLIDE_HEADER">
										Header
									</label>
								</div>
								<div class="col-md-10">
									<input id="SLIDE_HEADER" class="col-md-12" type="text" name="topicHeader" placeholder="Enter Slide Header"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-2">
									<label for="SLIDE_TYPE">
										Type
									</label>
								</div>
								<div class="col-md-10">
									<select id="SLIDE_TYPE">
										<option value="VIDEO">Video</option>
										<option value="SLIDE">Slide</option>
										<option value="QUIZ">Quiz</option>
									</select>
								</div>
							</div>
						</form:form>
					</div>
	        	</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-default pull-right" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
					<button id="SLIDE_SUBMIT" type="submit" class="btn btn-primary pull-right" ><span class="glyphicon glyphicon-plus"></span> Submit</button>
				</div>
			</div>
		</div>
	</div>	
</div>
	

<div class="modal fade" id="SLIDE_PREVIEW_MODAL">
	<div class="modal-dialog" style="width: 1100px;">
		<div class="modal-content">
        	<div class="modal-body">
       			
			</div> 
			<div class="modal-footer">
		    	<button type="button" class="close btn btn-default" data-dismiss="modal" >&times; Close</button>
			</div>
		</div>
	</div>
</div>	
	
	
	
	
	
	
	
	

	<%@include file="../fr/footer.jsp" %>

    <!-- TEMPLATES HERE -->    
    <script src="resources/js/cc/topicblock.js" type="text/javascript"></script>
    <script src="resources/js/cc/sliderow.js" type="text/javascript"></script>
    
    <!-- PAGE SPECIFIC EXTERNAL SCRIPTS -->
    <script src="resources/js/cc/cc.handlebars.js" type="text/javascript"></script>
    <script src="resources/js/tinymce/tinymce.min.js" type="text/javascript"></script>
    
    <script src="resources/js/cc/courseOutline.js" type="text/javascript"></script>
    <script src="resources/js/cc/cc.js" type="text/javascript"></script>
    
    
    
    <script type="text/javascript">
    /**
     *  Put page specific scripts here or create a new file
     *  and append it to the resource linking
     */
     var courseCode = $("#COURSE_CODE").val();
     $(document).ready(function(){
         initializeOutline(courseCode);
         initializeTinyMceEditor();
     });
     
     function initializeTinyMceEditor(){
		tinymce.init({
			selector: '#SLIDE_EDITOR',  
			plugins: 'code,advlist,image,link,paste,imagetools',  
			toolbar: 'undo redo | fontselect fontsizeselect | styleselect bold italic underline alignleft aligncenter alignright | bullist numlist outdent indent | paste image link code',
			menubar: false,
			
			//editor
			min_height: 500,
			max_height: 500,
			
			//code options
			code_dialog_height: 500,
			
			//list options
			advlist_bullet_styles: 'square circle',
			
			//paste options
			paste_data_images: true,
			
			//image options
			image_caption: true,
			
			//font options
			fontsize_formats: "8pt 9pt 10pt 11pt 12pt 14pt 16pt 18pt 20pt 26pt 36pt"
		});
     }
    </script>
  </body>
</html>