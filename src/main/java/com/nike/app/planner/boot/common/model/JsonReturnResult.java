
package com.nike.app.planner.boot.common.model;

public class JsonReturnResult {

	public final static String SUCCESS = "Success";
	public final static String FAILURE = "Failure";

	private String status = SUCCESS;
	private String message = null;

	public JsonReturnResult() {
		
	}

	public JsonReturnResult(String status) {
		this.status = status;
	}

	public JsonReturnResult(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}