<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header">Assortment Plan Template&nbsp;<small>for Making Data</small></h3>
		<p>If you try to manipulate and produce the target data result of Assortment Plan for making data, please firstly download the template <a href="<c:url value="/resources/doc/ASSORTMENT-PLAN-TEMPLATE_1.7.xlsx"/>">[ASSORTMENT_PLAN_TEMPLATE]</a> from the Web Site.</p>
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
					<table id="tbl-assortment" class="display" width="100%" cellspacing="0">
						<thead><tr><th>Image</th><th>Category</th><th>Division</th><th>Season</th><th>Product Id</th><th>Style</th><th>Product Code</th><th>Gender</th><th>Age</th><th>Style Name</th><th>Silhouette</th><th>DTC OMD</th><th>MMX OMD</th><th>Month</th><th>Selling Weeks</th><th>Flow</th><th>Full Color Description</th><th>CN MSRP</th><th>HK MSRP</th><th>TW MSRP</th><th>Attribute 1</th><th>Attribute 2</th><th>Attribute 3</th><th>Blind Buy</th><th>DMCA</th><th>Style Rank</th><th>Color Rank</th><th>Reference Style Name</th><th>Store Count</th><th>Nike.com Flag</th><th>Tmall Flag</th><th>Hk.com Flag</th></tr></thead>
					</table>
				</div>
				<div class="text-right">
					<a href="#">Export as MS Office (97-2003) Excel&nbsp;<i class="fa fa-download"></i></a>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<p><div style="text-align:center"><a href="#" class="btn btn-primary btn-lg" role="button">Commit All</a></div></p>
	</div>
</div>