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
  </head>
  <body>

    <div class="container-fluid">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
		<!-- NAVBAR START -->
		<%@include file="../fr/navbar.jsp" %>
		
		<!-- CONTENT AREA -->
		<div>
		
		</div>
		
	</div>
	
	
	
	
	

	<%@include file="../fr/footer.jsp" %>

    <!-- TEMPLATES HERE -->    
    
    <!-- PAGE SPECIFIC EXTERNAL SCRIPTS -->
    <script src="resources/js/tinymce/tinymce.min.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    </script>
  </body>
</html>