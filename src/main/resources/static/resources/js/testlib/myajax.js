
var Ajax = function () {
	var xhr = null;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest(); // key point : used for do the asynchronized http request with server-side program
	} else if (window.ActiveXObject) {
		xhr = new ActiveXObject("Microsoft.XMLHTTP"); // only for MS IE6 and below version
	}
	if (xhr == null || xhr == undefined) {
		alert("Browser not supported for XMLHTTP request.");
		return false;
	}
	Ajax.prototype.get = function (url, callBack, failback, complete) {
		var xHR = xhr;
		xhr.onreadystatechange = function () {
			switch (xHR.readyState) {
				case 0:
					console.log("not initialized ...");
					break;
				case 1:
					console.log("open() called ...");
					break;
				case 2:
					console.log("send() called ...");
					break;
				case 3:
					console.log("http response headers received ...");
					break;
				case 4:
					// HTTP 200 - OK, HTTP 304 - CACHED
					if (xHR.status == 200 || xHR.status == 304) {
						if (xHR.getResponseHeader("Content-Type").startsWith("application/json")) {
							callBack(JSON.parse(xHR.responseText));
						}
					} else {
						failback(xHR.status, xHR.responseText);
					}
					complete();
					break;
				default:
					break;
			}
		};
		xhr.open("GET", url, true);
		xhr.send();
	};
	Ajax.prototype.post = function (url, headers, data, callBack, failback, complete) {
		var xHR = xhr;
		xhr.onreadystatechange = function () {
			switch (xHR.readyState) {
				case 0:
					console.log("not initialized ...");
					break;
				case 1:
					console.log("open() called ...");
					break;
				case 2:
					console.log("send() called ...");
					break;
				case 3:
					console.log("http response headers received ...");
					break;
				case 4:
					// HTTP 200 - OK, HTTP 304 - CACHED
					if (xHR.status == 200 || xHR.status == 304) {
						if (xHR.getResponseHeader("Content-Type").startsWith("application/json")) {
							callBack(JSON.parse(xHR.responseText));
						}
					} else {
						failback(xHR.status, xHR.responseText);
					}
					complete();
					break;
				default:
					break;
			}
		};
		xhr.open("POST", url, true);
		for (var key in headers) {
			xhr.setRequestHeader(key, headers[key]);
		}
		xhr.send(data);
	};
}

var ajax = new Ajax();
var headers = { "Content-Type" : "application/json" };
//ajax.post('http://localhost:8082/nikeplanner/buyplan/bpt2dpv/rest/api', headers);
ajax.get("http://localhost:8082/nikeplanner/buyplan/bpt2dpv/rest/api");
