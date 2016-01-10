<%@page import="com.coursor.app.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>

<%
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
		<%@include file="../fr/login.jsp" %>
		
		
	</div>


    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/scripts.js"></script>
    <script src="resources/js/jquery.bootstrap.wizard.js"></script>
    <script src="resources/js/prettify.js"></script>
	
	<!-- Page specific external scripts -->    
    <script src="resources/js/um/um.js"></script>    
    
    <script type="text/javascript">
    /**
     *  Put page specific scripts here or create a new file
     *  and append it to the resource linking
     */
    
    
    </script>
  </body>
</html>