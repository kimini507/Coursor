<div role="tabpanel" class="tab-pane active" id="COURSE_TAB">

	<!-- TODO make this collapsible -->
	<div>
		<div class="input-group">
			<span class="input-group-btn">
				<button id="SEARCH_COURSE" class="btn btn-default" type="button"><span class="" aria-hidden="true">Search</span></button>
			</span>
			<input type="text" class="form-control" placeholder="for...">
			<span class="input-group-btn">
				<button id="CREATE_COURSE" data-toggle="modal" data-target="#CREATE_COURSE_MODAL" class="btn btn-primary" type="button"><span class="" aria-hidden="true">Create +</span></button>
			</span>
		</div>
		
		<div id="COURSE_LIST" >
			<div class="course-block col-md-3">
				<div class="course-container">
					<div class="course-code">CMSC 21</div>
					<div class="course-title">Introduction to Computer Science and the Internet</div>
				</div>
			</div>
		
			<div class="course-block col-md-3">
				<div class="course-container">
					<div class="course-code">CMSC 21</div>
					<div class="course-title">Introduction to Computer Science and the Internet</div>
				</div>
			</div>
	
			<div class="course-block col-md-3">
				<div class="course-container">
					<div class="course-code">CMSC 21</div>
					<div class="course-title">Introduction to Computer Science and the Internet</div>
				</div>
			</div>
	
			<div class="course-block col-md-3">
				<div class="course-container">
					<div class="course-code">CMSC 21</div>
					<div class="course-title">Introduction to Computer Science and the Internet</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="">
		<div>
		</div>
	</div>	

</div>



<div class="modal fade" id="CREATE_COURSE_MODAL" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
          		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		<h4 style="color:#337ab7;"><span class="glyphicon glyphicon-plus"></span> Create Course</h4>
        	</div>
        	<div>
        	<div class="modal-body">
        		<div class="">
				    <form:form id="courseform" method="POST" class="form-horizontal">
						<div class="form-group ">
							<div class="col-md-2">
								<label for="COURSE_TITLE">
									Title
								</label>
							</div>
							<div class="col-md-10">
								<input id="COURSE_TITLE" class="col-md-12" type="text" name="courseTitle" placeholder="Enter Course Title"/>
							</div>
						</div>
						<div class="form-group ">
							<div class="col-md-2">
								<label for="COURSE_CODE">
									Code
								</label>
							</div>
							<div class="col-md-10">
								<input id="COURSE_CODE" class="col-md-12" type="text" name="courseCode" placeholder="Enter Course Code"/>
							</div>
						</div>					
					</form:form>
				</div>
        	</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-default pull-right" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
				<button id="CREATE_COURSE_SUBMIT" type="submit" class="btn btn-primary pull-right" ><span class="glyphicon glyphicon-plus"></span> Submit</button>
			</div>
			
		</div>
	</div>
</div>