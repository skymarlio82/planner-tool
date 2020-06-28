$(document).ready(function() {
	'use strict';
	$.addTemplateFormatter({
		ImgUrlCombFormatter : function (value, template) {
			var result = null;
			result = (_contextRoot + "/resources/image/avatar_" + value + ".png");
			return result;
		}
	});
	var stompClient = null;
	function connect() {
		var socket = new SockJS(_contextRoot + '/ws');
		stompClient = Stomp.over(socket);
		stompClient.debug = null;
		stompClient.connect({}, onConnected, onError);
	}
	function onConnected() {
		// Subscribe to the Public Topic
		stompClient.subscribe('/topic/public', onMessageReceived);
		var req = { user : _username, content : 'request server status', type : 'SAFE' };
		console.log(">>>> WebSocket is sent to server:", req);
		stompClient.send("/app/status.getServerMessage", {}, JSON.stringify(req));
	}
	function onError(error) {
		console.log('Could not connect to WebSocket server. Please refresh this page to try again!');
	}
	function onMessageReceived(payload) {
		var message = JSON.parse(payload.body);
		if (message.type == 'WARNING') {
			console.log("<<<< requested message (server status):", message);
			$("#sys-info-prompt").loadTemplate($("#warn-info-tmpl"), message);
		} else if (message.type == 'SAFE') {
			console.log("<<<< pushed message (password):", message.content);
			if (message.userInfo.userId%2 == 1) {
				$("#userLiveMsg-frame").loadTemplate($("#userLiveMsg-left-tmpl"), message, { append : true, elemPerPage : 20 });
			} else {
				$("#userLiveMsg-frame").loadTemplate($("#userLiveMsg-right-tmpl"), message, { append : true, elemPerPage : 20 });
			}
		}
	}
	connect();
});