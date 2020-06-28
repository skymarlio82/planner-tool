<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header">Staff Detail Template <small>from Top to Down</small></h3>
		<p>If you try to manipulate and produce the target data result of Buying Plan from Top to Down, please firstly download the template <a href="<c:url value="/resources/doc/StaffDetailTestTemplate.xls"/>">[StaffDetailTestTemplate]</a> from the Web Site.</p>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title"><i class="fa fa-table fa-fw"></i>&nbsp;Template for Top to Down<small id="pbResult"></small></h3>
				<div class="progress mini progress-striped active">
					<div id="progressbar" class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>
				</div>
				<input type="file" name="file">
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<div class="dialog"></div>
					<table id="tbl-staff" class="display" width="100%" cellspacing="0">
						<thead><tr><th>Full name</th><th>Image</th><th>Surname</th><th>Gender</th><th>Position</th><th>Office</th><th>Extn.</th><th>Age</th><th>Start date</th><th>Salary</th><th>Email</th><th>Action</th></tr></thead>
						<tfoot><tr><th>Full name</th><th>Image</th><th>Surname</th><th>Gender</th><th>Position</th><th>Office</th><th>Extn.</th><th>Age</th><th>Start date</th><th>Salary</th><th>Email</th><th>Action</th></tr></tfoot>
					</table>
				</div>
				<div class="text-right">
					<a href="<c:url value="/staffmock/staffdetail/download"/>">Export as MS Office (97-2003) Excel&nbsp;<i class="fa fa-download"></i></a>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header">Staff Salary Detail Template <small>from Bottom to Up</small></h3>
		<p>Flot is a pure JavaScript plotting library for jQuery, <strike>with a focus on simple usage</strike>, attractive looks and interactive features. For full usage instructions and documentation for Flot Charts, visit <a href="#">http://www.flotcharts.org/</a>.</p>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-yellow">
			<div class="panel-heading">
				<h3 class="panel-title"><i class="fa fa-long-arrow-right fa-fw"></i>&nbsp;Template for Bottom to Up</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table id="tbl-staffsalary" class="display" width="100%" cellspacing="0">
						<thead><tr><th>Full name</th><th>Image</th><th>Total</th><th>Base</th><th>Compensation</th><th>Incentive</th><th>Action</th></tr></thead>
						<tfoot><tr><th>Full name</th><th>Image</th><th>Total</th><th>Base</th><th>Compensation</th><th>Incentive</th><th>Action</th></tr></tfoot>
					</table>
				</div>
				<div class="text-right">
					<a href="#">Save as snapshot&nbsp;<i class="fa fa-save"></i></a>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<p><div style="text-align:center"><button id="btnSave" type="button" style="width:200px;" class="btn btn-primary btn-lg">Save temporary&nbsp;&nbsp;&raquo;</button>&nbsp;<button id="btnCommit" type="button" style="width:200px;" class="btn btn-primary btn-lg">Commit permanent</button></div></p>
	</div>
</div>