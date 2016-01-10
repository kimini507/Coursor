
<!-- 	<div id="USER_MANAGEMENT" class="col-md-12 sub-tabs">
		<ul class="nav nav-pills " role="tablist">
		  <li role="presentation" class="active"><a href="#USERS_TAB" aria-controls="home" role="tab" data-toggle="tab">+ Add User</a></li>
		  <li role="presentation" class=""><a href="#COURSES_TAB" aria-controls="profile" role="tab" data-toggle="tab">Courses</a></li>
		</ul>
	</div>
 -->	

<div role="tabpanel" class="tab-pane " id="USER_TAB">
	<div class="col-md-4">
		<h3>Search User</h3>
		<div class="input-group">
			<input type="text" class="form-control" placeholder="Search for...">
			<span class="input-group-btn">
				<button id="SEARCH_USER" class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			</span>
		</div>
	 	<!-- USER LIST -->
		<div id="USER_LIST_CONTAINER">
			<table>
				<tr>
					<td>
						<table>
							<col width="70%"/>
							<col width="30%"/>
							<tr>
								<th>Name</th>
								<th>Role</th>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table id="USER_LIST">
							<col width="70%"/>
							<col width="30%"/>
						</table>
					</td>
				</tr>
			</table>
		</div>
	
	</div>
	<div class="col-md-8">
	
		<h3>${editorHeader}</h3>
	
	
	<!--  -->
		<div class="">
		    <form:form modelAttribute="account" method="POST" action="${userActionUrl}" class="form-horizontal">
		    	<form:errors path="*" />
				<div class="form-group">
					<div class="col-md-2">
						<label for="ROLE">
							Role
						</label>
					</div>
					<div class="col-md-10">
						<form:select path="userRole" items="${roleList}" multiple="false"></form:select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-2">							 
						<label for="USERNAME">
							Username
						</label>
					</div>
					<div class="col-md-10">
						<%if("EDIT".equals(mode)){ %>
							<span class="statictext">${username}</span>
							<form:input type="hidden" path="username" class="form-control" id="USERNAME" placeholder="Username"/>
						<%} else { %>
							<form:input path="username" class="form-control" id="USERNAME" placeholder="Username"/>
						<%} %>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-2">							 
						<label for="PASSWORD">
							Password
						</label>
					</div>
					<div class="col-md-10">
						<form:password path="password" class="form-control" id="PASSWORD" placeholder="Password" style="margin-bottom:15px;"/>
						<input type="password" class="form-control" id="CONFIRM_PASSWORD" name="confirmPassword" placeholder="Confirm Password"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-2">
						<label for="EMAIL">
							Email address
						</label>
					</div>
					<div class="col-md-10">
						<form:input path="email" class="form-control" id="EMAIL" placeholder="Email Address"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-2">
						<label for="FIRST_NAME">
							Name
						</label>
					</div>
					<div class="col-md-4">
						<form:input path="firstName" type="text" class="form-control" id="FIRST_NAME" name="firstName" placeholder="First Name"/>
					</div>
					<div class="col-md-3">
						<form:input path="middleName" type="text" class="form-control" id="MIDDLE_NAME" name="middleName" placeholder="Middle Name"/>
					</div>
					<div class="col-md-3">
						<form:input path="lastName" type="text" class="form-control" id="LAST_NAME" name="lastName" placeholder="Last Name"/>
					</div>
				</div>
				<div class="btn-bar col-md-12" >
					<button type="submit" class="btn btn-primary">
						<%if("EDIT".equals(mode)){ %>
						Save
						<%} else { %>
						Register
						<%} %>
					</button>
				</div>
		    </form:form>
		</div>
	</div>
	
</div>