<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="row">
	<div class="col-lg-6 col-lg-offset-3">
		<form role="form">
			<div class="form-group input-group">
				<input type="text" class="form-control" placeholder="Searching from here ..." />
				<span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i></button></span>
			</div>
		</form>
	</div>
</div>
<!-- System Alert message -->
<div class="row">
<script id="warn-info-tmpl" type="text/html">
<div class="alert alert-danger alert-dismissable">
	<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	<i class="fa fa-info-circle"></i>&nbsp;<strong data-content="content"></strong>&nbsp;Try to check with the&nbsp;<a href="#" class="alert-link">Technical Support</a>&nbsp;for IT Help!
</div>
</script>
	<div id="sys-info-prompt" class="col-lg-12">
	</div>
</div>
<div class="row">
	<div class="col-sm-3">
		<div class="panel panel-red">
			<div class="panel-body"><div id="cj-bc-salesgv" style="height: 200px; width: 100%;"></div></div>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="panel panel-primary">
			<div class="panel-body"><div id="cj-lc-doorsales" style="height: 200px; width: 100%;"></div></div>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="panel panel-green">
			<div class="panel-body"><div id="cj-ac-newwearable" style="height: 200px; width: 100%;"></div></div>
		</div>
	</div>
	<div class="col-sm-3">
		<div class="panel panel-yellow">
			<div class="panel-body"><div id="cj-pc-divisiongv" style="height: 200px; width: 100%;"></div></div>
		</div>
	</div>
</div>
<!-- optional panels -->
<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title"><i class="fa fa-long-arrow-right"></i>&nbsp;Service Runtime Status</h3>
			</div>
			<div class="panel-body">
				<div class="demo-container">
					<div id="placeholderRT" class="demo-placeholder"></div>
				</div>
				<div class="text-right">
					<a href="#">View Details&nbsp;<i class="fa fa-arrow-circle-right"></i></a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="chat-panel panel panel-success">
			<div class="panel-heading"><i class="fa fa-comments"></i>&nbsp;BuyPlan Status in Current Seasonal Gate</div>
			<div class="panel-body">
<script id="userLiveMsg-left-tmpl" type="text/html">
<li class="left clearfix">
	<span class="chat-img pull-left"><img data-src="imgUrl" alt="Img" class="img-circle" /></span>
	<div class="chat-body clearfix">
		<div class="header">
			<strong class="primary-font " data-content="user"></strong><small class="pull-right text-muted label label-info"><i class="fa fa-clock-o"></i>&nbsp;11 mins ago</small>
		</div>
		<br />
		<p><b>[System]:&nbsp;</b><span data-content="content"></span></p>
	</div>
</li>
</script>
<script id="userLiveMsg-right-tmpl" type="text/html">
<li class="right clearfix">
	<span class="chat-img pull-right"><img data-src="imgUrl" alt="Img" class="img-circle" /></span>
	<div class="chat-body clearfix">
		<div class="header">
			<small class="text-muted label label-warning"><i class="fa fa-clock-o"></i>&nbsp;10 mins ago</small><strong class="pull-right primary-font" data-content="user"></strong>
		</div>
		<br />
		<p><b>[System]:&nbsp;</b><span data-content="content"></span></p>
	</div>
</li>
</script>
				<ul id="userLiveMsg-frame" class="chat">
				</ul>
			</div>
			<div class="panel-footer">
				<div class="input-group">
					<input id="btn-input" type="text" class="form-control input-sm" placeholder="Type your comment here..." />
					<span class="input-group-btn">
						<button class="btn btn-success btn-sm" id="btn-chat">Send</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-2">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<div class="row">
					<a href="<c:url value="/buyplan/t2d/home"/>">
						<div class="col-xs-3"><i class="fa fa-table fa-3x"></i></div>
						<div class="col-xs-9 text-right">Quick Start for:<br/><h6>BuyPlan T2D</h6></div>
					</a>
				</div>
			</div>
			<a href="<c:url value="/buyplan/t2d/home"/>">
				<div class="panel-footer">
					<span class="pull-left">View Details</span>&nbsp;<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="row">
					<a href="<c:url value="/buyplan/b2u/home"/>">
						<div class="col-xs-3"><i class="fa fa-table fa-3x"></i></div>
						<div class="col-xs-9 text-right">Quick Start for:<br/><h6>BuyPlan B2U</h6></div>
					</a>
				</div>
			</div>
			<a href="<c:url value="/buyplan/b2u/home"/>">
				<div class="panel-footer">
					<span class="pull-left">View Details</span>&nbsp;<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
		<div class="panel panel-warning">
			<div class="panel-heading">
				<div class="row">
					<a href="<c:url value="/assortment/template/home"/>">
						<div class="col-xs-3"><i class="fa fa-cubes fa-3x"></i></div>
						<div class="col-xs-9 text-right">Quick Start for:<br/><h6>Assortment</h6></div>
					</a>
				</div>
			</div>
			<a href="<c:url value="/assortment/template/home"/>">
				<div class="panel-footer">
					<span class="pull-left">View Details</span>&nbsp;<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
		<div class="panel panel-success">
			<div class="panel-heading">
				<div class="row">
					<a href="#">
						<div class="col-xs-3"><i class="fa fa-question fa-3x"></i></div>
						<div class="col-xs-9 text-right">Quick Start for:<br/><h6>-</h6></div>
					</a>
				</div>
			</div>
			<a href="#">
				<div class="panel-footer">
					<span class="pull-left">View Details</span>&nbsp;<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
</div>
