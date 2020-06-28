
$(function() {

	var chartSalesGV = new CanvasJS.Chart("cj-bc-salesgv", {
		title : { text : "NIKE GLOBAL SALES VIEW by COUNTRIES" },
		animationEnabled : true,
		axisY : { title : "$ for REV." },
		legend : { verticalAlign : "bottom", horizontalAlign : "center" },
		data : [{
			type : "column",
			showInLegend : true,
			legendMarkerColor : "grey",
			legendText : "2016 FINANCE YEAR",
			dataPoints : [ { y : 297571, label : "USA" }, { y : 267017, label : "CHINA" }, { y : 175200, label : "JAPAN" }, { y : 154580, label : "GERMANY" }, { y : 116000, label : "UK" }, { y : 97800, label : "FRENCH" }, { y : 20682, label : "RUSSIA" }]
		}]
	});
	chartSalesGV.render();

	var chartDoorSales = new CanvasJS.Chart("cj-lc-doorsales", {
		title : { text : "NIKE DOOR SALES" },
		animationEnabled : true,
		axisX : { gridColor : "Silver", tickColor : "silver", valueFormatString : "DD/MMM" },
		toolTip : { shared : true },
		axisY : { gridColor : "Silver", tickColor : "silver" },
		legend : { verticalAlign : "center", horizontalAlign : "right" },
		data : [{
			type : "line",
			showInLegend : true,
			lineThickness : 1,
			name : "$",
			markerType : "square",
			color : "#F08080",
			dataPoints : [ { x : new Date(2016, 7, 1), y : 650 }, { x : new Date(2016, 8, 1), y : 650 }, { x : new Date(2016, 9, 1), y : 700 }, { x : new Date(2016, 10, 1), y : 710 }, { x : new Date(2016, 11, 1), y : 658 }, { x : new Date(2017, 0, 1), y : 734 }, { x : new Date(2017, 1, 1), y : 963 }, { x : new Date(2017, 2, 1), y : 847 }, { x : new Date(2017, 3, 1), y : 853 }, { x : new Date(2017, 4, 1), y : 869 }, { x : new Date(2017, 5, 1), y : 943 }, { x : new Date(2017, 6, 1), y : 970 }]
		}]
	});
	chartDoorSales.render();

	var chartNewWearable = new CanvasJS.Chart("cj-ac-newwearable", {
		title : { text : "GROWTH of NEW WEARABLE DEVICE SALES" },
		animationEnabled : true,
		axisX : { valueFormatString : "DD-MMM", interval : 10, intervalType : "day", labelAngle : -50, labelFontColor : "rgb(0,75,141)", minimum : new Date(2017, 06, 10) },
		axisY : { title : "Sales on Door", interlacedColor : "#F0FFFF", tickColor : "azure", titleFontColor : "rgb(0,75,141)", valueFormatString : "# Millions,,.", interval : 100000000 },
		data : [{
			indexLabelFontColor : "darkSlateGray",
			name : 'views',
			type : "area",
			color : "rgba(0,75,141,0.7)",
			markerSize : 8,
			dataPoints : [
			    { x : new Date(2017, 06, 15), y : 0, indexLabel : "Release", indexLabelOrientation : "vertical", indexLabelFontColor : "orangered", markerColor : "orangered" }, 
			    { x : new Date(2017, 06, 18), y : 2000000 }, 
			    { x : new Date(2017, 06, 23), y : 6000000 }, 
			    { x : new Date(2017, 07, 01), y : 10000000, indexLabel : "10" }, 
			    { x : new Date(2017, 07, 11), y : 21000000 }, 
			    { x : new Date(2017, 07, 23), y : 50000000 }, 
			    { x : new Date(2017, 07, 31), y : 75000000 }, 
			    { x : new Date(2017, 08, 04), y : 100000000, indexLabel : "100" }, 
			    { x : new Date(2017, 08, 10), y : 125000000 }, 
			    { x : new Date(2017, 08, 13), y : 150000000 }, 
			    { x : new Date(2017, 08, 16), y : 175000000 }, 
			    { x : new Date(2017, 08, 18), y : 200000000, indexLabel : "200" }
			]
		}]
	});
	chartNewWearable.render();
	
	
	var chartDivisionGV = new CanvasJS.Chart("cj-pc-divisiongv", {
		title : { text : "SALES for DIVISIONS VIEW" },
		animationEnabled : true,
		legend : {
			verticalAlign : "bottom",
			horizontalAlign : "center"
		},
		data : [{
			type : "pie",
			showInLegend : true,
			toolTipContent : "{name} : <strong>{y}</strong>",
			indexLabel : "{name} {y}",
			dataPoints : [ { y : 243000, name : "FOOTWEAR", exploded : true }, { y : 80000, name : "APPAREL", exploded : true }, { y : 120000, name : "EQUIPMENT", exploded : true }, { y : 100000, name : "DIGITAL", exploded : true }, { y : 90000, name : "AIRFLIGHT", exploded : true } ]
		}]
	});
	chartDivisionGV.render();
	
});
