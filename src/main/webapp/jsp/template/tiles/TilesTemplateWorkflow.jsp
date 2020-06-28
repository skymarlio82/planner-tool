<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

	<tiles:insertAttribute name="PageCss" />

</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<div id="toggleMenubar"></div>
				<a id="leftMenuBarSwitcher" href="#" class="navbar-brand"><b>NIKE JUST SMARTER</b></a>
			</div>
			<!-- Top Menu Bar -->
			<tiles:insertAttribute name="TopMenuBar" />
			<!-- Navigation Menu Bar - These collapse to the responsive navigation menu on small screens -->
			<div id="leftMenuBar" class="collapse navbar-collapse navbar-mainmenu-collapse"></div>
		</nav>
		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row">
					<tiles:insertAttribute name="PageHeader" />
				</div>
				<!-- Page Level navigation and panel bar -->
				<div class="row">
					<tiles:insertAttribute name="LaunchPad" />
					<tiles:insertAttribute name="WorkflowTabPanel" />
				</div>
				<tiles:insertAttribute name="PageBody" />
				<a id="back-to-top" href="#" class="btn btn-primary btn-lg back-to-top" role="button" title="Click to return on the top page" data-toggle="tooltip" data-placement="left"><span class="glyphicon glyphicon-chevron-up"></span></a>
			</div>
		</div>
	</div>
	<div id="footer">
		<p>&copy;&nbsp;NIKE.COM&nbsp;2017.06&nbsp;&nbsp;ALL COPYRIGHTS RESERVED&nbsp;(Created by Skymarlio)</p>
	</div>
<script id="tmplleftMenuContent" type="text/html">
<c:set var="uname" value="${sessionScope.USER_CONFIG.userName}" />
<ul class="nav navbar-nav side-nav">
	<li id="lmi_dashboard"><a href="<c:url value="/dashboard/user/home"/>"><i class="fa fa-fw fa-dashboard"></i>&nbsp;Dashboard</a></li>
	<li id="lmi_buyplan">
		<a href="javascript:;" data-toggle="collapse" data-target="#menuLv2BuyPlan"><i class="fa fa-fw fa-table"></i>&nbsp;Buying Plan&nbsp;<i class="fa fa-fw fa-caret-down"></i></a>
		<ul id="menuLv2BuyPlan" class="collapse">
			<li><a href="<c:url value="/buyplan/t2d/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Top to Down</a></li>
			<li><a href="<c:url value="/buyplan/b2u/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Bottom to Up</a></li>
			<li><a href="<c:url value="/buyplan/checkout/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Review & Confirm</a></li>
			<li><a href="<c:url value="/buyplan/soc/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Size Breakdown</a></li>
		</ul>
	</li>
	<li id="lmi_assortment">
		<a href="javascript:;" data-toggle="collapse" data-target="#menuLv2AssortmentPlan"><i class="fa fa-fw fa-cubes"></i>&nbsp;Assortment Plan&nbsp;<i class="fa fa-fw fa-caret-down"></i></a>
		<ul id="menuLv2AssortmentPlan" class="collapse">
			<li><a href="<c:url value="/assortment/template/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Home</a></li>
		</ul>
	</li>
	<li id="lmi_testbuyplan">
		<a href="javascript:;" data-toggle="collapse" data-target="#menuLv2TestBuyPlan"><i class="fa fa-fw fa-table"></i>&nbsp;Test Buying Plan&nbsp;<i class="fa fa-fw fa-caret-down"></i></a>
		<ul id="menuLv2TestBuyPlan" class="collapse">
			<li><a href="<c:url value="/buyplan/test/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;TEST</a></li>
		</ul>
	</li>
	<li id="lmi_staffmock">
		<a href="javascript:;" data-toggle="collapse" data-target="#menuLv2Staffmock"><i class="fa fa-fw fa-users"></i>&nbsp;Staff Mocking&nbsp;<i class="fa fa-fw fa-caret-down"></i></a>
		<ul id="menuLv2Staffmock" class="collapse">
			<li><a href="<c:url value="/staffmock/template/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;TEST</a></li>
		</ul>
	</li>
	<li><a href="<c:url value="/user/default/logout"/>"><i class="fa fa-fw fa-sign-out"></i>&nbsp;Quit for [<c:out value="${fn:toUpperCase(uname)}" />]</a></li>
</ul>
</script>
</body>

<tiles:insertAttribute name="PageJs" />

</html>
