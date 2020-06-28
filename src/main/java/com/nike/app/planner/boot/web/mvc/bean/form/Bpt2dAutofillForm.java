
package com.nike.app.planner.boot.web.mvc.bean.form;

import org.hibernate.validator.constraints.NotEmpty;

public class Bpt2dAutofillForm {

	@NotEmpty
	private String field = null;

	private double value = (double)0.0;

	@NotEmpty
	private int[] rows = null;

	public Bpt2dAutofillForm() {

	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int[] getRows() {
		return rows;
	}

	public void setRows(int[] rows) {
		this.rows = rows;
	}
}