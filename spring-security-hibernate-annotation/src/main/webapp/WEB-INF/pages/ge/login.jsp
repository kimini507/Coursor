<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Coursera :: Login</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/general.css" rel="stylesheet">

  </head>
  <body onload='document.LOGIN_FORM.username.focus();'>

	<div class="container-fluid">

		<!-- NAVBAR START -->
		<%@include file="../fr/navbar.jsp" %>
	
		<!-- CONTENT AREA -->
		<%@include file="../fr/login.jsp" %>
		
		<div class="row">
			<div class="col-md-12">
			</div>
		</div>
	</div>
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/scripts.js"></script>
  </body>
</html>