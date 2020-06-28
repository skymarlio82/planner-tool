
package com.nike.app.planner.boot.message.websock.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.nike.app.planner.boot.message.websock.model.SimpleWebSockMessage;
import com.nike.app.planner.boot.message.websock.model.SimpleWebSockMessage.MessageType;

@Controller
public class WebSockStatusController {

	@MessageMapping("/status.getServerMessage")
	@SendTo("/topic/public")
	public SimpleWebSockMessage sendMessage(@Payload SimpleWebSockMessage message) {
		System.out.println("WebSocket received message = " + message);
		message.setType(MessageType.WARNING);
		message.setContent("Server balance is over loaded by the new committed records, WARNING!!!");
		return message;
	}
}