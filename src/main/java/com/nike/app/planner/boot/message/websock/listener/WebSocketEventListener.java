
package com.nike.app.planner.boot.message.websock.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class WebSocketEventListener {

	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		System.out.println("A new WebSocket connection is connected ...");
	}

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		System.out.println("A WebSocket connection is disconnected ...");
	}

	@EventListener
	public void handleWebSocketSubscribeListener(SessionSubscribeEvent event) {
		System.out.println("A new WebSocket connection is subscribed ...");
	}

	@EventListener
	public void handleWebSocketUnsubscribeListener(SessionUnsubscribeEvent event) {
		System.out.println("A WebSocket connection is unsubscribed ...");
	}
}