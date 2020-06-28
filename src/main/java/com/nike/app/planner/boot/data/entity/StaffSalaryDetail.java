
package com.nike.app.planner.boot.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="PT_STAFF_SALARY_DETAIL_TEST_TAB")
public class StaffSalaryDetail implements Serializable {

	private static final long serialVersionUID = 1011913318958063199L;

	private int staffSalaryId = 0;
	private String fullName = null;
	private String image = null;
	private double gross = (double)0;
	private double base = (double)0;
	private double compensation = (double)0;
	private double incentive = (double)0;
	@JsonProperty("DT_RowId")
	private String dt_rowid = null;

	public StaffSalaryDetail() {
		
	}

	public StaffSalaryDetail(int staffSalaryId, String fullName, double gross, double base, double compensation, double incentive) {
		this.staffSalaryId = staffSalaryId;
		this.fullName = fullName;
		this.gross = gross;
		this.base = base;
		this.compensation = compensation;
		this.incentive = incentive;
	}

	public String toString() {
		return "staffSalaryId=" + staffSalaryId + ", fullName=" + fullName + " gross=" + gross + ", base=" + base + ", compensation=" + compensation + ", incentive=" + incentive;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="STAFF_SALARY_ID")
	public int getStaffSalaryId() {
		return staffSalaryId;
	}

	public void setStaffSalaryId(int staffSalaryId) {
		this.staffSalaryId = staffSalaryId;
	}

	@Column(name="FULL_NAME")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name="IMAGE_B64")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name="GROSS")
	public double getGross() {
		return gross;
	}

	public void setGross(double gross) {
		this.gross = gross;
	}

	@Column(name="BASE")
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	@Column(name="COMPENSATION")
	public double getCompensation() {
		return compensation;
	}

	public void setCompensation(double compensation) {
		this.compensation = compensation;
	}

	@Column(name="INCENTIVE")
	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}

	@Transient
	public String getDt_rowid() {
		return "row_" + staffSalaryId;
	}

	public void setDt_rowid(String dt_rowid) {
		this.dt_rowid = dt_rowid;
	}
}