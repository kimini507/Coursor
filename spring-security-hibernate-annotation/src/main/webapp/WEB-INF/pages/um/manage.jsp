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
    <link href="resources/css/um/um.css" rel="stylesheet">
    <link href="resources/css/cm/cm.css" rel="stylesheet">
	
  </head>
  <body onload='document.LOGIN_FORM.username.focus();'>

    <div class="container-fluid">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
		<!-- NAVBAR START -->
		<%@include file="../fr/navbar.jsp" %>
		
		<!-- CONTENT AREA -->
		<div class="row">

			<div class="col-md-12">
				<div class="col-md-2"></div>
				<div id="MANAGEMENT_TAB" class="col-md-8">
					<ul class="nav nav-pills " role="tablist">
					  <li role="presentation" class=""><a href="#USER_TAB" aria-controls="home" role="tab" data-toggle="tab">Users</a></li>
					  <li role="presentation" class="active"><a href="#COURSE_TAB" aria-controls="profile" role="tab" data-toggle="tab">Courses</a></li>
					</ul>
				</div>
			</div>

			<div class="col-md-12">
				<div class="col-md-2"></div>
				<!-- CENTER CONTENT AREA -->
				<div id="CONTENT_OUTER_CONTAINER" class="col-md-8">
				    <!-- USER REGISTRATION FORM -->				    
					<div class="tab-content col-md-12">
				    	<%@include file="../um/umtab.jsp" %>
				    	<%@include file="../cm/cmtab.jsp" %>
				    </div>
				</div>
				<div class="col-md-3">
				</div>
			</div>
		</div>
	</div>
		
	<%@include file="../fr/footer.jsp" %>
    
    <!-- TEMPLATES HERE -->    
    <script src="resources/js/um/userlist.js"></script>
    
    <!-- PAGE SPECIFIC EXTERNAL SCRIPTS -->
    <script src="resources/js/um/um.js"></script>
    <script src="resources/js/cm/cm.js"></script>
    
    <script type="text/javascript">
    /**
     *  Put page specific scripts here or create a new file
     *  and append it to the resource linking
     */
    </script>
  </body>
</html>