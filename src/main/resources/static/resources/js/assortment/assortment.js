
$(document).ready(function() {

//	var editorAssortment = new $.fn.dataTable.Editor({
////		ajax : _contextRoot + "/assortment/rest/api",
//		table : "#tbl-assortment",
//		fields : [
//			{ label : "Image:", name : "image.image" }, 
//			{ label : "Style Name", name : "styleName" }, 
//			{ label : "DTC OMD", name : "dtcOmdTxt", type : "datetime" }, 
//			{ label : "MMX OMD", name : "mmxOmdTxt", type : "datetime" }, 
//			{ label : "Full Color Description", name : "fullColorDescription" }, 
//			{ label : "CN MSRP", name : "cnmsrp" }, 
//			{ label : "Attribute 1", name : "attribute1" }, 
//			{ label : "Attribute 3", name : "attribute3" }, 
//			{ label : "Style Rank", name : "styleRank" }, 
//			{ label : "Reference Style Name", name : "referenceStyleName" }
//		]
//	});
//	$('#tbl-assortment').on('click', 'tbody td:not(:first-child)', function(e) {
//		editorAssortment.inline(this);
//	});
	var tableAssortment = $('#tbl-assortment').DataTable({
		scrollX : true,
		scrollY : "400px",
		rowReorder : true,
		lengthChange : true,
		lengthMenu : [[10, 20, -1], [10, 20, "All"]],
		pagingType : "full_numbers",
		select : { style : "single" },
		display: "envelope",
		ajax : _contextRoot + "/assortment/rest/api",
		columns : [
			{ data : null, render : function (data, type, row) { return '<img class="image_clickable" alt="img" width="40px" height="40px" src="data:image/png;base64,' + data.image.image + '"/>'; } }, 
			{ data : "category" }, 
			{ data : "division" }, 
			{ data : "season" }, 
			{ data : "productId" }, 
			{ data : "style" }, 
			{ data : "productCode" }, 
			{ data : "gender" }, 
			{ data : "age" }, 
			{ data : "styleName" }, 
			{ data : "silhouette" }, 
			{ data : "dtcOmdTxt" }, 
			{ data : "mmxOmdTxt" }, 
			{ data : "month" }, 
			{ data : "sellingWeeks" }, 
			{ data : "flow" }, 
			{ data : "fullColorDescription" }, 
			{ data : "cnmsrp", render : $.fn.dataTable.render.number(',', '.', 2, '$') }, 
			{ data : "hkmsrp", render : $.fn.dataTable.render.number(',', '.', 2, '$') }, 
			{ data : "twmsrp", render : $.fn.dataTable.render.number(',', '.', 2, '$') }, 
			{ data : "attribute1" }, 
			{ data : "attribute2" }, 
			{ data : "attribute3" }, 
			{ data : "blindBuy" }, 
			{ data : "dmca" }, 
			{ data : "styleRank" }, 
			{ data : "colorRank" }, 
			{ data : "referenceStyleName" }, 
			{ data : "storeCount" }, 
			{ data : "nikeComFlag" }, 
			{ data : "tmallFlag" }, 
			{ data : "hkComFlag" } 
		],
		rowCallback : function(row, data, displayIndex, displayIndexFull) {
			$(row).children().each(function(index, td) {
				switch (index) {
					case 0:
						$(td).css("background-color", "white");
						break;
					default:
						break;
				}
			});
			return row;
		}
	});
//	new $.fn.dataTable.Buttons(tableAssortment, [{
//			extend : "create", editor : editorAssortment
//		}, {
//			extend : "edit", editor : editorAssortment
//		}, {
//			extend : "remove", editor : editorAssortment
//		}]
//	);
//	tableAssortment.buttons().container().prependTo($('div.fg-toolbar:eq(0)', tableAssortment.table().container()));

});