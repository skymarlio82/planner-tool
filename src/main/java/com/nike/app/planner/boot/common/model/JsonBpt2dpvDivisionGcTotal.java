
package com.nike.app.planner.boot.common.model;

public class JsonBpt2dpvDivisionGcTotal {

	private String label = null;
	private double value = (double)0.0;

	public JsonBpt2dpvDivisionGcTotal() {
		
	}

	public JsonBpt2dpvDivisionGcTotal(String label, double value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}