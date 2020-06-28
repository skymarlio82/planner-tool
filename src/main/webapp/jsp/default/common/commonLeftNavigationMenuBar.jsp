<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<c:set var="uname" value="${sessionScope.USER_CONFIG.userName}" />
<ul class="nav navbar-nav side-nav">
	<li <c:if test="${MENU_TITLE == 'dashboard'}">class="active"</c:if>><a href="<c:url value="/dashboard/user/home"/>"><i class="fa fa-fw fa-dashboard"></i>&nbsp;Dashboard</a></li>
	<li <c:if test="${MENU_TITLE == 'buyplan'}">class="active"</c:if>>
		<a href="javascript:;" data-toggle="collapse" data-target="#menuLv2BuyPlan"><i class="fa fa-fw fa-table"></i>&nbsp;Buying Plan&nbsp;<i class="fa fa-fw fa-caret-down"></i></a>
		<ul id="menuLv2BuyPlan" class="collapse">
			<li><a href="<c:url value="/buyplan/t2d/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Top to Down</a></li>
			<li><a href="<c:url value="/buyplan/b2u/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Bottom to Up</a></li>
			<li><a href="<c:url value="/buyplan/checkout/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Review & Confirm</a></li>
			<li><a href="<c:url value="/buyplan/soc/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Size Breakdown</a></li>
		</ul>
	</li>
	<li <c:if test="${MENU_TITLE == 'assortment'}">class="active"</c:if>>
		<a href="javascript:;" data-toggle="collapse" data-target="#menuLv2AssortmentPlan"><i class="fa fa-fw fa-cubes"></i>&nbsp;Assortment Plan&nbsp;<i class="fa fa-fw fa-caret-down"></i></a>
		<ul id="menuLv2AssortmentPlan" class="collapse">
			<li><a href="<c:url value="/assortment/template/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;Home</a></li>
		</ul>
	</li>
	<li <c:if test="${MENU_TITLE == 'testbuyplan'}">class="active"</c:if>>
		<a href="javascript:;" data-toggle="collapse" data-target="#menuLv2TestBuyPlan"><i class="fa fa-fw fa-table"></i>&nbsp;Test Buying Plan&nbsp;<i class="fa fa-fw fa-caret-down"></i></a>
		<ul id="menuLv2TestBuyPlan" class="collapse">
			<li><a href="<c:url value="/buyplan/test/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;TEST</a></li>
		</ul>
	</li>
	<li <c:if test="${MENU_TITLE == 'staffmock'}">class="active"</c:if>>
		<a href="javascript:;" data-toggle="collapse" data-target="#menuLv2Staffmock"><i class="fa fa-fw fa-users"></i>&nbsp;Staff Mocking&nbsp;<i class="fa fa-fw fa-caret-down"></i></a>
		<ul id="menuLv2Staffmock" class="collapse">
			<li><a href="<c:url value="/staffmock/template/home"/>"><i class="fa fa-fw fa-edit"></i>&nbsp;TEST</a></li>
		</ul>
	</li>
	<li><a href="<c:url value="/user/default/logout"/>"><i class="fa fa-fw fa-sign-out"></i>&nbsp;Quit for [<c:out value="${fn:toUpperCase(uname)}" />]</a></li>
</ul>