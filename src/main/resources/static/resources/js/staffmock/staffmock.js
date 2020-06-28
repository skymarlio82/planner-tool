
$(document).ready(function() {

	var editorTableStaff = new $.fn.dataTable.Editor({
		ajax : _contextRoot + "/staffmock/rest/api/staff",
		table : "#tbl-staff",
		fields : [{
			label: "First name:", name : "firstName"
		}, {
			label: "Last name:", name : "lastName"
		}, {
			label: "Image", name : "image"
		}, {
			label: "Gender", name : "gender", type : "select", options: [ { label : "M", value : "M" }, { label : "F", value : "F" } ]
		}, {
			label: "Position:", name : "position"
		}, {
			label: "Office:", name : "office"
		}, {
			label: "Extn.:", name : "extn"
		}, {
			label: "Age:", name : "age"
		}, {
			label: "Start date:", name : "startDateStr", type : "datetime"
		}, {
			label: "Salary:", name : "salary"
		}, {
			label: "Email:", name : "email"
		}]
	});
	$('#tbl-staff').on('click', 'tbody td:not(:first-child)', function(e) {
		editorTableStaff.inline(this);
	});
	$('#tbl-staff').on('click', 'a.editor_apply_tbl_staff', function(e) {
		e.preventDefault();
		var rowdata = tableStaff.row($(this).closest('tr')).data();
		$.ajax({
			url : _contextRoot + "/staffmock/salary/updatesalarydetailbystaffid?staffid=" + rowdata.staffId + "&newsalary=" + rowdata.salary,
			dataType : "json",
			type : "GET",
			contentType : "application/json",
			success : function(data) {
				
			},
			error : function(error) {
				alert("error - " + error.status);
			},
			complete : function() {
				tableStaffSalary.ajax.reload();
			}
		});
	});
	// Setup - add a text input to each footer cell
	$("#tbl-staff tfoot th").each(function() {
		var title = $(this).text();
		if (title != "Full name" && title != "Image" && title != "Action") {
			$(this).html('<input type="text" style="width: 60px;" placeholder="' + title + '" />');
		}
	});
	$("#tbl-staff").on('click', 'img.image_clickable', function (e) {
		var image = $(this);
		$.prompt({
			state0 : {
				title : 'Image Detail:',
				html : '<center><img alt="img" width="120px" height="120px" src="' + image.attr("src") + '"/></center>'
			}
		});
	});
	var tableStaff = $('#tbl-staff').DataTable({
		scrollX : true,
		lengthChange : true,
		lengthMenu : [[10, 20, 30, 40, -1], [10, 20, 30, 40, "All"]],
		pagingType : "full_numbers",
		select : {style : "single"},
		display: "envelope",
		ajax : _contextRoot + "/staffmock/rest/api/staff",
		columns : [
		    {data : null, render : function(data, type, row) {return data.firstName + ' ' + data.lastName;}},
		    {data : null, render : function(data, type, row) {return '<img class="image_clickable" alt="img" width="30px" height="30px" src="data:image/png;base64,' + data.image + '"/>';}},
		    {data : null, render : function(data, type, row) {return data.lastName;}},
		    {data : "gender"},
		    {data : null, render : function(data, type, row) {return data.position;}},
		    {data : null, render : function(data, type, row) {return data.office;}},
		    {data : null, render : function(data, type, row) {return data.extn;}},
		    {data : null, render : function(data, type, row) {return data.age;}},
		    {data : "startDateStr"},
		    {data : "salary", render : $.fn.dataTable.render.number(',', '.', 2, '$')},
		    {data : "email"},
		    {data: null, className : "center", defaultContent : '<a href="#" class="editor_apply_tbl_staff">apply</a>'}
		]
	});
	// Apply the search
	tableStaff.columns().every(function() {
		var that = this;
		$('input', this.footer()).on('keyup change', function() {
			if (that.search() !== this.value) {
				that.search(this.value).draw();
			}
		});
	});
	var columnsVisibilities = [true, true, true, true, true];
	var columnsNames = ["Surname", "Position", "Offcie", "Extn.", "Age"];
	var columnsValues = [2, 4, 5, 6, 7];
	function tagMasterTableColumnVisibilty(datatable, status) {
		var displayTxt = "";
		for (var i = 0; i < 5; i++) {
			var str1 = "<label><input type='checkbox' name='c";
			var str2 = (i + 1) + "";
			var str3 = "' value='" + columnsValues[i] + "' ";
			var str4 = (!status) ? (!columnsVisibilities[i] ? 'checked disabled' : '') : (columnsVisibilities[i] ? 'checked disabled' : '');
			var str5 = ">&nbsp;" + columnsNames[i] + "</label>&nbsp;&nbsp;";
			var str6 = str1 + str2 + str3 + str4 + str5;
			displayTxt += str6;
		}
		$.prompt({
			state0 : {
				title : 'Please select the colums to be ' + ((status) ? 'shown' : 'hiden') + ':',
				html : displayTxt,
				buttons : { "Confirm" : true, "Cancel" : false },
				submit : function(e, v, m, f) {
					if (v) {
						for (var i = 1; i <=5; i++) {
							if (typeof f['c' + i] != "undefined") {
								var column = datatable.column(parseInt(f['c' + i]));
						        column.visible(status);
						        columnsVisibilities[i - 1] = status;
							}
				    	}
					}
					e.preventDefault();
					$.prompt.close();
				}
			}
		});
	}
	new $.fn.dataTable.Buttons(tableStaff, [
		{extend : "create", editor : editorTableStaff}, 
		{extend : "edit", editor : editorTableStaff}, 
		{extend : "remove", editor : editorTableStaff}, 
		{text : 'Hide Columns', action : function(e, dt, node, config) { tagMasterTableColumnVisibilty(dt, false); }}, 
		{text : 'Show Columns', action : function(e, dt, node, config) { tagMasterTableColumnVisibilty(dt, true); }}
	]);
	tableStaff.buttons().container().prependTo($('div.fg-toolbar:eq(0)', tableStaff.table().container()));

	var editorStaffSalary = new $.fn.dataTable.Editor({
//		ajax : _contextRoot + "/staffmock/rest/api/staffsalary",
		table : "#tbl-staffsalary",
		fields : [
		    {name : "base"},
		    {name : "compensation"},
		    {name : "incentive"}
		]
	});
	$('#tbl-staffsalary').on('click', 'tbody td:not(:first-child)', function(e) {
		editorStaffSalary.inline(this);
	});
	$('#tbl-staffsalary').on('click', 'a.editor_apply_tbl_staffsalary', function(e) {
		e.preventDefault();
		var rowdata = tableStaffSalary.row($(this).closest('tr')).data();
		var staffSalaryDetailForm = {
			staffId : rowdata.staffSalaryId, fullName : rowdata.fullName, gross : rowdata.gross, base : rowdata.base, compensation : rowdata.compensation, incentive : rowdata.incentive
		};
		$.ajax({
			url : _contextRoot + "/staffmock/staffsalary/applysalarydetailchanged",
			data : JSON.stringify(staffSalaryDetailForm),
			dataType : "json",
			type : "POST",
			contentType : "application/json",
			success : function(data) {
				
			},
			error : function(error) {
				alert("error - " + error.status);
			},
			complete : function() {
				tableStaffSalary.ajax.reload();
				tableStaff.ajax.reload();
			}
		});
	});
	var tableStaffSalary = $('#tbl-staffsalary').DataTable({
		scrollX : true,
		lengthChange : false,
		select : {style : "single"},
		searching : false,
		ajax : _contextRoot + "/staffmock/rest/api/staffsalary",
		columns : [
		    {data : "fullName"},
		    {data : null, render : function(data, type, row) {return '<img alt="img" width="30px" height="30px" src="data:image/png;base64,' + data.image + '"/>';}},
		    {data : "gross", render : $.fn.dataTable.render.number(',', '.', 2, '$')},
		    {data : "base", render : $.fn.dataTable.render.number(',', '.', 2, '$')},
		    {data : "compensation", render : $.fn.dataTable.render.number(',', '.', 2, '$')},
		    {data : "incentive", render : $.fn.dataTable.render.number(',', '.', 2, '$')},
		    {data: null, className: "center", defaultContent: '<a href="#" class="editor_apply_tbl_staffsalary">apply</a>'}
		]
	});
//	new $.fn.dataTable.Buttons(tableStaffSalary, [{
//		text : 'Remove', action : function(e, dt, node, config) {
//			dt.rows({selected : true}).remove().draw(false);
//		}}, {
//		text : 'Save All', action : function(e, dt, node, config) {
//	    	var list = new Array();
//	    	var rows = dt.rows().data();
//	    	rows.each(function(value, index) {
//	    	    list.push({rowId : value.DT_RowId, firstName : value.first_name, lastName : value.last_name, salary : value.salary, base : value.base, compensation : value.compensation, incentive : value.incentive});
//	    	});
//	    	var submitedResult = {dataList : list};
//	    	$.ajax({
//				url : _contextRoot + "/buyplan/entity/staffsalary/submitsalaryinfo",
//				data : JSON.stringify(submitedResult),
//				dataType : "json",
//				type : "POST",
//				contentType : "application/json",
//				success : function(data) {
//					
//				},
//				error : function(error) {
//					alert("error - " + error.status);
//				},
//				complete : function() {
//					
//				}
//			});
//	    }}
//	]);
	tableStaffSalary.buttons().container().prependTo($('div.fg-toolbar:eq(0)', tableStaffSalary.table().container()));

	$('input[type=file]').change(function() {
		$(this).simpleUpload(_contextRoot + "/staffmock/test/uploadfile", {
			start : function(file) {
				// upload started
				console.log("filename: " + file.name);
				$('#progressbar').attr("aria-valuenow", "0");
				$('#progressbar').attr("style", "0%");
			},
			progress: function(progress) {
				// received progress
				$('#progressbar').attr("aria-valuenow", Math.round(progress) + "");
				$('#progressbar').attr("style", "width: " + Math.round(progress) + "%;");
				$("#pbResult").html("  (" + Math.round(progress) + "%)");
			},
			success: function(data) {
				tableStaff.ajax.reload();
				// upload successful
				$("#pbResult").html("  (100% Successful)");
				console.log("Success! Data : " + JSON.stringify(data));
			},
			error: function(error) {
				// upload failed
				alert("error - " + error.name + ": " + error.message);
			}
		});
	});
	
});