<%@page import="com.coursor.app.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>

<%
	String mode = (String)request.getAttribute("manageMode");
%>

<!DOCTYPE html>
<html lang="en">
  <head>
  	<%@include file="../fr/header.jsp" %>
	
	<!-- page specific resources/settings -->
    <link href="resources/css/style.css" rel="stylesheet">
	
  </head>
  <body onload='document.LOGIN_FORM.username.focus();'>

    <div class="container-fluid">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
		<!-- NAVBAR START -->
		<%@include file="../fr/navbar.jsp" %>
		
		<!-- CONTENT AREA -->
		<div class="row">
			<div class="col-md-12">
				<div class="row">
				
					<!-- LEFT SIDE PANEL -->
					<%@include file="../um/usercoursetab.jsp" %>					
					<!-- CENTER CONTENT AREA -->
					<div class="col-md-6">
					    <!-- USER REGISTRATION FORM -->
					    <div><h2>${editorHeader}</h2></div>
					    
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
									<form:input path="username" class="form-control" id="USERNAME" placeholder="Username"/>
									<form:errors path="username" />
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
									Register
								</button>
							</div>
					    </form:form>
					</div>
					<div class="col-md-3">
					</div>
				</div>
			</div>
		</div>
	</div>
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/scripts.js"></script>
    <script src="resources/js/jquery.bootstrap.wizard.js"></script>
    <script src="resources/js/prettify.js"></script>
    
    <script src="resources/js/um/um.js"></script>
    
    <script type="text/javascript">
    /**
     *  Put page specific scripts here or create a new file
     *  and append it to the resource linking
     */
    
    
    </script>
  </body>
</html>