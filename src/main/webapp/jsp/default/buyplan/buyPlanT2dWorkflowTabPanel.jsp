<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="col-lg-12">
	<ul class="nav nav-tabs">
		<li<c:if test="${BUYPLAN_T2D_STEP_ID == 1}"> class="active"</c:if>>
			<a href="#"><i class="fa fa-fw fa-arrow-down"></i>&nbsp;<b>STEP 01 - TOP TO DOWN</b></a>
		</li>
		<li<c:if test="${BUYPLAN_T2D_STEP_ID == 2}"> class="active"</c:if>>
			<a href="#"><i class="fa fa-fw fa-arrow-down"></i>&nbsp;<b>STEP 02 - TOP TO DOWN</b></a>
		</li>
		<li<c:if test="${BUYPLAN_T2D_STEP_ID == 3}"> class="active"</c:if>>
			<a href="#"><i class="fa fa-fw fa-arrow-down"></i>&nbsp;<b>STEP 03 - TOP TO DOWN</b></a>
		</li>
	</ul>
</div>