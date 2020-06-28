
package com.nike.app.planner.boot.common.model;

public class JsonCjsLabelYModel {

	private String label = null;
	private double y = (double)0.0;
	private boolean exploded = true;

	public JsonCjsLabelYModel() {
		
	}

	public JsonCjsLabelYModel(String label, double y) {
		this.label = label;
		this.y = y;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isExploded() {
		return exploded;
	}

	public void setExploded(boolean exploded) {
		this.exploded = exploded;
	}
}