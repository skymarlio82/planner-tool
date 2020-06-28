<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title><tiles:getAsString name="PageTitle" ignore="true" /></title>
	<link rel="shortcut icon" href="<c:url value="/resources/nike.ico"/>" />
	<!-- Bootstrap Core CSS -->
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/plugin/bootstrap-3.3.7/css/bootstrap.min.css"/>" />
	<!-- Customized CSS -->
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/login/login.css"/>" />
</head>
<body>
	<tiles:insertAttribute name="BodyContent" />
</body>
<!-- jQuery -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery-1.12.4.min.js"/>"></script>
<!-- Bootstrap Core JavaScript -->
<script type="text/javascript" src="<c:url value="/resources/plugin/bootstrap-3.3.7/js/bootstrap.min.js"/>"></script>
<!-- JS Implementing Plugins -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.backstretch-2.0.3/js/jquery.backstretch.min.js"/>"></script>
<!-- jQuery validate -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jquery.validate-1.16.0/js/jquery.validate.min.js"/>"></script>
<!-- MVVM Knockout -->
<script type="text/javascript" src="<c:url value="/resources/plugin/knockout-3.4.2/js/knockout.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/knockout.mapping-2.4.1/js/knockout.mapping.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/plugin/knockout.validation-1.0.1/js/knockout.validation.min.js"/>"></script>
<!-- APP Script -->
<script type="text/javascript" src="<c:url value="/resources/js/login/login.js"/>"></script>
<script type="text/javascript">var _contextRoot = '<%=request.getContextPath() %>';</script>
</html>
