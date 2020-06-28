
var editorBpt2dpv = null;
var tableBpt2dpv = null;

var BudgetDispatchStatusViewModle = function () {
	var self = this;
	self.grandTotal = ko.observable(0);
	self.planUsed = ko.observable(0);
	self.remain = ko.observable(0);
	self.alertDangerStatus = ko.pureComputed(function () {
		return (this.remain() < 0) ? true : false;
	}, this);
};

var ARR_DIM = [ new DropDownItem("- DIMENSION -", "-"), new DropDownItem("DIGITAL", "DIGITAL"), new DropDownItem("NSO", "NSO") ];
var ARR_STO_DIGI = [ new DropDownItem("- STORE -", "-"), new DropDownItem("NIKE.COM", "NIKE.COM"), new DropDownItem("T-MALL", "T-MALL"), new DropDownItem("HK.COM", "HK.COM") ];
var ARR_DIV = [ new DropDownItem("- DIVISION -", "-"), new DropDownItem("FOOTWEAR", "FOOTWEAR"), new DropDownItem("APPAREL", "APPAREL"), new DropDownItem("EQUIPMENT", "EQUIPMENT") ];

var SelectsViewModle = function () {
	var self = this;
	self.arrayDimension = ko.observableArray(ARR_DIM);
	self.selectedDimension = ko.observable('DIGITAL');
	self.selectedDimensionChange = function (event) {
		if (self.selectedDimension() == "-") {
			self.selectedDimension("DIGITAL");
			self.arrayStore(ARR_STO_DIGI);
			self.selectedDivision("-");
		} else if (self.selectedDimension() == "DIGITAL") {
			self.arrayStore(ARR_STO_DIGI);
			self.selectedDivision("-");
		}
		if (self.selectedDimension() == "DIGITAL") {
			tableBpt2dpv.ajax.url(_contextRoot + "/buyplan/bpt2dpv/rest/api");
			tableBpt2dpv.ajax.reload();
		}
	};
	self.arrayStore = ko.observableArray(ARR_STO_DIGI);
	self.selectedStore = ko.observable('-');
	self.selectedStoreChange = function (event) {
		self.selectedChange(event);
	};
	self.arrayDivision = ko.observableArray(ARR_DIV);
	self.selectedDivision = ko.observable('-');
	self.selectedDivisionChange = function (event) {
		self.selectedChange(event);
	};
	self.selectedChange = function (event) {
		if (self.selectedDimension() == "DIGITAL") {
			if (self.selectedStore() == "-" && self.selectedDivision() == "-") {
				tableBpt2dpv.ajax.url(_contextRoot + "/buyplan/bpt2dpv/rest/api").load();
			} else {
				tableBpt2dpv.ajax.url(_contextRoot + "/buyplan/bpt2dpv/rest/api/filter?platform=" + self.selectedStore() + "&division=" + self.selectedDivision()).load();
				tableBpt2dpv.ajax.url(_contextRoot + "/buyplan/bpt2dpv/rest/api");
			}
		}
	};
};

$(document).ready(function () {

	$("#selCategory").get(0).selectedIndex = 0;
	$("#selCategory").multiselect({ buttonWidth : '100%' });

	var vmBudgetDispatchStatus = new BudgetDispatchStatusViewModle();
	ko.applyBindings(vmBudgetDispatchStatus, $('#statusBarPlanResult').get(0));
	var vmSelects = new SelectsViewModle();
	ko.applyBindings(vmSelects, $('#ddlSelects').get(0));
	assignPlanResultOnPage();
	loadForDivisionTyLyRevsByPlatform("NIKE.COM", "morris-bc-nikecom", "NIKE.com REV$ Growth");
	loadForDivisionTyLyRevsByPlatform("T-MALL", "morris-bc-tmall", "T-Mall REV$ Growth");
	loadForDivisionTyLyRevsByPlatform("HK.COM", "morris-bc-hkcom", "HK.com REV$ Growth");
	loadForDivisionGcTotal("morris-dc-gctotal", "GC Total");

	editorBpt2dpv = new $.fn.dataTable.Editor({
		ajax : _contextRoot + "/buyplan/bpt2dpv/rest/api",
		table : "#tbl-bpt2dpv",
		fields : [
			{ label : "TY Delta%", name : "tyDeltaPercent" },
			{ label : "TY ST%", name : "tyStPercent" }
		]
	});

	$('#tbl-bpt2dpv').on('click', 'tbody tr:not(:nth-child(4),:nth-child(8),:nth-child(12),:nth-child(13),:nth-child(14),:nth-child(15),:nth-child(16)) td:not(:first-child,:nth-child(2),:nth-child(3),:nth-child(5),:nth-child(6),:nth-child(8),:nth-child(9),:nth-child(10),:nth-child(11),:nth-child(12),:nth-child(13),:nth-child(14),:nth-child(15),:nth-child(16),:last-child)', function (e) {
		editorBpt2dpv.inline(this);
	});

	tableBpt2dpv = $('#tbl-bpt2dpv').DataTable({
		scrollX : true,
		scrollY : "480px",
		fixedColumns : { leftColumns : 2 },
		searching : false,
		lengthChange : true,
		lengthMenu : [ [ 16, 4, 8, 12, -1 ], [ 16, 4, 8, 12, "all" ] ],
		pagingType : "full_numbers",
		select : { style : "single" },
		ordering : false,
		display: "envelope",
		keys : true,
		autoFill : { alwaysAsk : true, columns : ':not(:first-child,:nth-child(2),:nth-child(3),:nth-child(5),:nth-child(6),:nth-child(8),:nth-child(9),:nth-child(10),:nth-child(11),:nth-child(12),:nth-child(13),:nth-child(14),:nth-child(15),:nth-child(16),:last-child)' },
		ajax : _contextRoot + "/buyplan/bpt2dpv/rest/api",
		columns : [
			{ data : "platform" }, 
			{ data : "division" }, 
			{ data : "tyRevDolar", render : $.fn.dataTable.render.number(',', '.', 2, '$') }, 
			{ data : "tyDeltaPercent", render : $.fn.dataTable.render.number(',', '.', 2, '', '%') }, 
			{ data : "tySaleUnit" }, 
			{ data : "tyAurDolar", render : $.fn.dataTable.render.number(',', '.', 2, '$') }, 
			{ data : "tyStPercent", render : $.fn.dataTable.render.number(',', '.', 2, '', '%') }, 
			{ data : "tyBuyUnit" }, 
			{ data : "lyRevDolar", render : $.fn.dataTable.render.number(',', '.', 2, '$') }, 
			{ data : "lySaleUnit" }, 
			{ data : "lyAurDolar", render : $.fn.dataTable.render.number(',', '.', 2, '$') }, 
			{ data : "lyMdPercent", render : $.fn.dataTable.render.number(',', '.', 2, '', '%') }, 
			{ data : "lyInSeasonPercent", render : $.fn.dataTable.render.number(',', '.', 2, '', '%') }, 
			{ data : "lyBuyUnit" }, 
			{ data : "lyStPercent", render : $.fn.dataTable.render.number(',', '.', 2, '', '%') }, 
			{ data : "tyRevDolarPercent", render : $.fn.dataTable.render.number(',', '.', 2, '', '%') }, 
			{ data : "lyRevDolarPercent", render : $.fn.dataTable.render.number(',', '.', 2, '', '%') }, 
			{ data : "varRevDolarPercent", render : $.fn.dataTable.render.number(',', '.', 2, '', 'BPM') }
		],
		rowCallback : function (row, data, displayIndex, displayIndexFull) {
			$(row).children().each(function (index, td) {
				switch (index) {
					case 0:
						$(td).css("background-color", "#FAFBFC");
						if (data.platform == "NIKE.COM" || data.platform == "BE") {
							$(td).html("<font color='red'><b>" + $(td).html() + "</font></b>");
						} else if (data.platform == "HK.COM" || data.platform == "CE") {
							$(td).html("<font color='green'><b>" + $(td).html() + "</font></b>");
						} else if (data.platform == "T-MALL" || data.platform == "ES") {
							$(td).html("<font color='blue'><b>" + $(td).html() + "</font></b>");
						} else if (data.platform == "GC TOTAL") {
							$(td).html("<font color='brown'><b>" + $(td).html() + "</font></b>");
						}
						break;
					case 1:
						if (data.division == "FOOTWEAR" || data.division == "APPAREL" || data.division == "EQUIPMENT") {
							$(td).css("background-color", "#DDE7EB");
						} else if (data.division == "TOTAL APP") {
							$(td).css("background-color", "#BCC1C4");
						}
						break;
					case 2: case 4: case 5: case 7:
						if (displayIndex == 3 || displayIndex == 7 || displayIndex == 11) {
							$(td).css("background-color", "#BCC1C4");
						}
						break;
					case 3: case 6:
						if ((displayIndex >= 0 && displayIndex < 3) || (displayIndex >= 4 && displayIndex < 7) || (displayIndex >= 8 && displayIndex < 11)) {
							$(td).css("background-color", "#F5E0D7");
						}
						if (displayIndex == 3 || displayIndex == 7 || displayIndex == 11) {
							$(td).css("background-color", "#BCC1C4");
						}
						break;
					case 15: case 16:
						if ((displayIndex >= 0 && displayIndex < 3) || (displayIndex >= 4 && displayIndex < 7) || (displayIndex >= 8 && displayIndex < 11)) {
							$(td).css("background-color", "#7CF7AB");
						}
						if (displayIndex == 3 || displayIndex == 7 || displayIndex == 11) {
							$(td).css("background-color", "#BCC1C4");
						}
						break;
					case 17:
						if ((displayIndex >= 0 && displayIndex < 3) || (displayIndex >= 4 && displayIndex < 7) || (displayIndex >= 8 && displayIndex < 11)) {
							$(td).css("background-color", "#F7E97C");
						}
						if (displayIndex == 3 || displayIndex == 7 || displayIndex == 11) {
							$(td).css("background-color", "#BCC1C4");
						}
						break;
					default:
						break;
				}
				if (index >= 8 && index < 15) {
					if ((displayIndex >= 0 && displayIndex <= 3) || (displayIndex >= 4 && displayIndex <= 7) || (displayIndex >= 8 && displayIndex <= 11) || (displayIndex >= 12 && displayIndex <= 15)) {
						$(td).html("<b>" + $(td).html() + "</b>");
					}
					if (displayIndex == 3 || displayIndex == 7 || displayIndex == 11) {
						$(td).css("background-color", "#BCC1C4");
					}
				}
				if (displayIndex >= 12 && displayIndex < 15) {
					if (index >= 2 && index < 18) {
						$(td).css("background-color", "#DDE7EB");
					}
				}
				if (displayIndex == 15) {
					if (index >= 2 && index < 18) {
						$(td).css("background-color", "#BCC1C4");
					}
				}
			});
			return row;
		}
	});

	var availableAutoFill = true;

	tableBpt2dpv.on('preAutoFill', function (e, datatable, cells) {
		for (var i = 0; i < cells.length; i++) {
			var rowIndex = cells[i][0].index.row;
			var rowData = tableBpt2dpv.row(rowIndex).data();
			if (rowData.division == "TOTAL APP" || rowData.platform == "GC TOTAL") {
				availableAutoFill = false;
				return false;
			}
		}
	});

	tableBpt2dpv.on('autoFill', function (e, datatable, cells) {
		if (availableAutoFill == false) {
			tableBpt2dpv.ajax.reload();
			availableAutoFill = true;
			return false;
		}
		var setValue = 0;
		var columnIndex = 0;
		var arr = new Array();
		for (var i = 0; i < cells.length; i++) {
			columnIndex = cells[i][0].index.column;
			setValue = cells[i][0].set;
			var rowIndex = cells[i][0].index.row;
			var rowData = tableBpt2dpv.row(rowIndex).data();
			var id = (typeof (rowData.bpTop2DownPlatformId) == "undefined") ? (rowData.bpTop2DownStoreId + 10000) : rowData.bpTop2DownPlatformId;
			arr.push(id);
		}
		var col = null;
		if (columnIndex == 3) {
			col = "deltaPercent";
		} else if (columnIndex == 6) {
			col = "stPercent";
		}
		var formData = { field : col, value : setValue, rows : arr };
		$.ajax({
			url : _contextRoot + '/buyplan/bpt2dpv/rest/api/updateautofill',
			contentType : "application/json",
			dataType : "json",
			type : "POST",
			data : JSON.stringify(formData),
			success : function (data) {
				if (data.status == "Success") {
					tableBpt2dpv.ajax.url(_contextRoot + "/buyplan/bpt2dpv/rest/api");
					tableBpt2dpv.ajax.reload();
				}
			},
			error : function (error) {
				alert("error - " + error.status);
			},
			complete : function () {
				assignPlanResultOnPage();
				loadForDivisionTyLyRevsByPlatform("NIKE.COM", "morris-bc-nikecom", "NIKE.com REV$ Growth");
				loadForDivisionTyLyRevsByPlatform("T-MALL", "morris-bc-tmall", "T-Mall REV$ Growth");
				loadForDivisionTyLyRevsByPlatform("HK.COM", "morris-bc-hkcom", "HK.com REV$ Growth");
				loadForDivisionGcTotal("morris-dc-gctotal", "GC Total");
			}
		});
	});

	var postEditNum = 0;

	editorBpt2dpv.on('postEdit', function (e, json, data) {
		if (postEditNum == 0) {
			tableBpt2dpv.ajax.url(_contextRoot + "/buyplan/bpt2dpv/rest/api");
			tableBpt2dpv.ajax.reload();
			assignPlanResultOnPage();
			loadForDivisionTyLyRevsByPlatform("NIKE.COM", "morris-bc-nikecom", "NIKE.com REV$ Growth");
			loadForDivisionTyLyRevsByPlatform("T-MALL", "morris-bc-tmall", "T-Mall REV$ Growth");
			loadForDivisionTyLyRevsByPlatform("HK.COM", "morris-bc-hkcom", "HK.com REV$ Growth");
			loadForDivisionGcTotal("morris-dc-gctotal", "GC Total");
		}
		if (++postEditNum == json.data.length) {
			postEditNum = 0;
		}
	});

	editorBpt2dpv.on("preSubmit", function (e, o, action) {
		if (action == "edit") {
			for (var key in o.data) {
				var rowId = key;
				var field = o.data[rowId];
				for (var fieldname in field) {
					var objField = this.field(fieldname);
					if (!objField.isMultiValue()) {
						if (!objField.val()) {
							objField.error('Field required.');
						}
						if (isNaN(objField.val())) {
							objField.error('Number Type required.');
						}
						if (this.inError()) {
							return false;
						}
					}
				}
			}
		}
	});

	$("#btnSave").click(function (e) {
		e.preventDefault();
		commitAllBpt2dpvs(false);
		$.prompt({
			state0 : { title : 'Information:', html : '<center>Data is saved.</center>' }
		});
	});

	$("#btnNext").click(function (e) {
		e.preventDefault();
		$.prompt({
			state0 : {
				title : "Information:",
				html : '<center>Are you sure to continue for next step?<br/>(All data in this page will be saved automatically)</center><br/>',
				buttons : { "Yes" : true, "No" : false },
				submit : function (e, v, m, f) {
					if (v) {
						commitAllBpt2dpvs(true);
					}
					e.preventDefault();
					$.prompt.close();
				}
			}
		});
	});

	function assignPlanResultOnPage() {
		$.ajax({
			url : _contextRoot + "/buyplan/bpt2dpv/rest/api/getplannedresult",
			dataType : "json",
			type : "GET",
			contentType : "application/json",
			success : function (data) {
				vmBudgetDispatchStatus.grandTotal(data.grandTotal);
				vmBudgetDispatchStatus.planUsed(data.planUsed);
				vmBudgetDispatchStatus.remain(data.remain);
			},
			error : function (error) {
				alert("error - " + error.status);
			},
			complete : function () {
				
			}
		});
	}

	function highlightDtRow(e, platform) {
		$.each(tableBpt2dpv.rows().data(), function (index, value) {
			if (value.platform == platform && value.division == e.dataPoint.label) {
				tableBpt2dpv.$("tr.selected").removeClass("selected");
				tableBpt2dpv.row(index).select();
				return false;
			}
    	});
	}

	function loadForDivisionTyLyRevsByPlatform(platform, uid, title) {
		$.ajax({
			url : _contextRoot + "/buyplan/bpt2dpv/rest/api/getcjsdivisiontylyrevs?platform=" + platform,
			dataType : "json",
			type : "GET",
			contentType : "application/json",
			success : function (data) {
				var chart = new CanvasJS.Chart(uid, {
					animationEnabled : true,
					title : { text : title, fontSize : 12 },
					toolTip : { shared : true },
					axisY : { title : "$ for Planning" },
					data : [{
						type : "column", name : "TY Rev.$", color : "rgba(40,175,101,0.6)", click : function (e) { highlightDtRow(e, platform); }, dataPoints : data.tyList 
					}, {
						type : "column", name : "LY Rev.$", color : "rgba(0,75,141,0.7)", click : function (e) { highlightDtRow(e, platform); }, dataPoints : data.lyList 
					}]
				});
				chart.render();
			},
			error : function (error) {
				alert("error - " + error.status);
			},
			complete : function () {
				
			}
		});
	}

	function loadForDivisionGcTotal(uid, title) {
		$.ajax({
			url : _contextRoot + "/buyplan/bpt2dpv/rest/api/getcjsdivisiongctotal",
			dataType : "json",
			type : "GET",
			contentType : "application/json",
			success : function (data) {
				var chart = new CanvasJS.Chart(uid, {
					animationEnabled : true,
					title : { text : title, fontSize : 12 },
					legend : { verticalAlign : "bottom", horizontalAlign : "center" },
					data : [{ type : "pie", dataPoints : data }]
				});
				chart.render();
			},
			error : function (error) {
				alert("error - " + error.status);
			},
			complete : function () {
				
			}
		});
	}

	function commitAllBpt2dpvs(needRedirect) {
		var result = false;
		$.ajax({
			url : _contextRoot + "/buyplan/bpt2dpv/rest/api/commitall",
			dataType : "json",
			type : "GET",
			contentType : "application/json",
			success : function (data) {
				if (data.status == "Success") {
					result = true;
				}
			},
			error : function (error) {
				alert("error - " + error.status);
			},
			complete : function () {
				if (needRedirect) {
					if (result) {
						window.location = _contextRoot + "/buyplan/t2d/page?stepid=2";
					}
				}
			}
		});
	}
});