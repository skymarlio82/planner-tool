<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="row">
	<div class="col-lg-12">
		<h3 class="page-header">Buying Plan Template about Store Assignment <small>from Top to Down</small></h3>
		<p>The <span style="color:red;font-weight:bold;background-color:yellow;">1st step</span> of manipulating and producing the target data results for <b><u><i>BUYING PLAN</i></u></b> from <span style="color:blue;font-weight:bold;background-color:yellow;">Top to Down</span> methodology about Budget Dispatch on <span style="color:blue;font-weight:bold;background-color:yellow;">Store Level</span> in this Work Flow chain, please kindly just edit in the below table and review from its above report charts.</p>
		<small><ul>
			<li>The DropDown List UI control used to do the filtering behave for the DataTable by Dimention, Store, Gender, Category, Division.</li>
			<li>The Status Bar used to show: Total Granted Budget (Upstream System), Dispatched Amount (Step 01), Remained Money.</li>
			<li>The Column Bar Charts used to display revenue growth by Stores, and handle interaction with below DataTable.</li>
			<li>The DataTable used to show data set and provide operations for the Buying Plan at step 01, and exported as Excel format</li>
		</ul></small>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title"><i class="fa fa-table fa-fw"></i>&nbsp;Template for Top to Down</h3>
			</div>
			<div class="panel-body">
				<div id="ddlSelects" class="row">
					<div class="col-sm-2">
						<div class="panel panel-default">
							<div class="panel-body">
								<select id="selDimension" class="form-control dropdown-search" data-bind="options: arrayDimension, optionsText: 'name', optionsValue: 'value', value: selectedDimension, event: { change: selectedDimensionChange }"></select>
							</div>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="panel panel-default">
							<div class="panel-body">
								<select id="selPlatform" class="form-control dropdown-search" data-bind="options: arrayStore, optionsText: 'name', optionsValue: 'value', value: selectedStore, event: { change: selectedStoreChange }"></select>
							</div>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="panel panel-default">
							<div class="panel-body">
								<select id="selGender" class="form-control">
									<option value="-" selected="selected">- GENDER -</option>
									<option value="MALE">MALE</option>
									<option value="FEMALE">FEMALE</option>
									<option value="UNISEX">UNISEX</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="panel panel-default">
							<div class="panel-body">
								<select id="selCategory" multiple="multiple" class="form-control">
									<option value="-">- CATEGORY -</option>
									<option value="NIKE SB">NIKE SB</option>
									<option value="MNSW">MNSW</option>
									<option value="WNSW">WNSW</option>
								</select>
							</div>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="panel panel-default">
							<div class="panel-body">
								<select id="selDivision" class="form-control dropdown-search" data-bind="options: arrayDivision, optionsText: 'name', optionsValue: 'value', value: selectedDivision, event: { change: selectedDivisionChange }"></select>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div id="statusBarPlanResult" class="col-lg-12">
						<ol data-bind="css : { 'breadcrumb' : true, 'alert-danger' : alertDangerStatus }">
							<li><i class="fa fa-usd"></i>&nbsp;OTB Grand Total : $<span id="valGrandTotal" data-bind="text : grandTotal" style="color:green;font-weight:bold;">0</span></li>
							<li><i class="fa fa-tags"></i>&nbsp;Plan Used : $<span id="valPlanUsed" data-bind="text : planUsed" style="color:blue;font-weight:bold;">0</span></li>
							<li><i class="fa fa-share"></i>&nbsp;Remaining : $<span id="valRemain" data-bind="text : remain" style="color:brown;font-weight:bold;">0</span></li>
						</ol>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<div class="panel panel-red">
							<div class="panel-body"><div id="morris-bc-nikecom"></div></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="panel panel-primary">
							<div class="panel-body"><div id="morris-bc-tmall"></div></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="panel panel-green">
							<div class="panel-body"><div id="morris-bc-hkcom"></div></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="panel panel-yellow">
							<div class="panel-body"><div id="morris-dc-gctotal"></div></div>
						</div>
					</div>
				</div>
				<div class="table-responsive">
					<table id="tbl-bpt2dpv" class="display" width="100%" cellspacing="0">
						<thead><tr><th>STORE</th><th>DIVISION</th><th>TY REV$</th><th>TY DELTA%</th><th>TY SALE UNIT</th><th>TY AUR$</th><th>TY ST%</th><th>TY BUY UNIT</th><th>LY REV$</th><th>LY SALE UNIT</th><th>LY AUR$</th><th>LY MD%</th><th>LY IN-SEA%</th><th>LY BUY UNIT</th><th>LY ST%</th><th>TY REV.$%</th><th>LY REV.$%</th><th>VAR%</th></tr></thead>
					</table>
				</div>
				<div class="text-right">
					<a href="<c:url value="/buyplan/bpt2dpv/download/excel"/>">Exported as MS OFFICE EXCEL (97-2003)&nbsp;<i class="fa fa-download"></i></a>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<p><div style="text-align:center"><button id="btnSave" type="button" style="width:180px;" class="btn btn-primary btn-lg">Save</button>&nbsp;<button id="btnNext" type="button" style="width:180px;" class="btn btn-primary btn-lg">Next&nbsp;&nbsp;&raquo;</button></div></p>
	</div>
</div>