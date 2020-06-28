
package com.nike.app.planner.boot.common.model;

public class JsonBpt2dpvPlanResult {

	private double grandTotal = (double)0.0;
	private double planUsed = (double)0.0;
	private double remain = (double)0.0;

	public JsonBpt2dpvPlanResult() {
		
	}

	public JsonBpt2dpvPlanResult(double grandTotal, double planUsed, double remain) {
		this.grandTotal = grandTotal;
		this.planUsed = planUsed;
		this.remain = remain;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public double getPlanUsed() {
		return planUsed;
	}

	public void setPlanUsed(double planUsed) {
		this.planUsed = planUsed;
	}

	public double getRemain() {
		return remain;
	}

	public void setRemain(double remain) {
		this.remain = remain;
	}
}