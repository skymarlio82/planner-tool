
package com.nike.app.planner.boot.common.model;

import java.util.List;

public class JsonLogonResult extends JsonReturnResult {

	private List<String> errors = null;

	public JsonLogonResult() {
		
	}

	public JsonLogonResult(String status) {
		super(status);
	}

	public JsonLogonResult(String status, List<String> errors) {
		super(status);
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}