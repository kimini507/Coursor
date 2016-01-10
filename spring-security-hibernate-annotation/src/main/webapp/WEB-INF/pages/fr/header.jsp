	<c:set var="req" value="${pageContext.request}" />
	<c:set var="url">${req.requestURL}</c:set>
	<c:set var="uri" value="${req.requestURI}"/>
 
    <meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">

    <title>Coursor</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/prettify.css" rel="stylesheet">
    <link href="resources/css/general.css" rel="stylesheet">
    <link href="resources/css/ge/loadingcover.css" rel="stylesheet">
