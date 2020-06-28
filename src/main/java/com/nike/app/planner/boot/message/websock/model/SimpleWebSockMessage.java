
package com.nike.app.planner.boot.message.websock.model;

public class SimpleWebSockMessage {

	private MessageType type = null;
	private String user      = null;
	private String content   = null;

	public enum MessageType {
		FATAL, WARNING, SAFE
	}

	public SimpleWebSockMessage() {
		
	}

	public SimpleWebSockMessage(MessageType type, String user, String content) {
		this.type = type;
		this.user = user;
		this.content = content;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}