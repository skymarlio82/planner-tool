
package com.nike.app.planner.boot.web.mvc.bean.form;

public class StaffSalaryDetailForm {

	private int staffId = 0;
	private String fullName = null;
	private double gross = (double)0;
	private double base = (double)0;
	private double compensation = (double)0;
	private double incentive = (double)0;

	public StaffSalaryDetailForm() {
		
	}

	public String toString() {
		return "staffId = " + staffId + ", fullName = " + fullName + ", gross = " + gross + ", base = " + base + ", compensation = " + compensation + ", incentive = " + incentive;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getGross() {
		return gross;
	}

	public void setGross(double gross) {
		this.gross = gross;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getCompensation() {
		return compensation;
	}

	public void setCompensation(double compensation) {
		this.compensation = compensation;
	}

	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
}