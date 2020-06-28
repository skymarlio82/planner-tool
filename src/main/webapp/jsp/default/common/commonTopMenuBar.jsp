<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<ul class="nav navbar-right top-nav">
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-question-circle"></i>&nbsp;Help&nbsp;<b class="caret"></b></a>
		<ul class="dropdown-menu">
			<li><a href="#"><i class="fa fa-fw fa-file-pdf-o"></i>&nbsp;Tutorial</a></li>
			<li><a href="#"><i class="fa fa-fw fa-phone"></i>&nbsp;Contact</a></li>
		</ul>
	</li>
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>&nbsp;User&nbsp;<b class="caret"></b></a>
		<ul class="dropdown-menu">
			<li><a href="#"><i class="fa fa-fw fa-user"></i>&nbsp;Profile</a></li>
			<li><a href="#"><i class="fa fa-fw fa-gear"></i>&nbsp;Settings</a></li>
			<li class="divider"></li>
			<li><a href="<c:url value="/user/default/logout"/>"><i class="fa fa-fw fa-sign-out"></i>&nbsp;Logout</a></li>
		</ul>
	</li>
</ul>