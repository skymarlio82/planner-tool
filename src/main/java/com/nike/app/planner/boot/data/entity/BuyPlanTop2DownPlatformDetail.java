
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
@Table(name="PT_BP_T2D_PLATFORM_DETAIL_TAB")
public class BuyPlanTop2DownPlatformDetail implements Serializable {

	private static final long serialVersionUID = 4899790161008832297L;

	private int bpTop2DownPlatformId = 0;
	private String platform = null;
	private String division = null;
	private double revDolar = (double)0.0;
	private double deltaPercent = (double)0.0;
	private int saleUnit = 0;
	private double aurDolar = (double)0.0;
	private double mdPercent = (double)0.0;
	private double inSeasonPercent = (double)0.0;
	private double stPercent = (double)0.0;
	private int buyUnit = 0;
	private int yearNum = 0;
	@JsonProperty("DT_RowId")
	private String dt_rowid = null;

	public BuyPlanTop2DownPlatformDetail() {
		
	}

	public BuyPlanTop2DownPlatformDetail(int bpTop2DownPlatformId, String platform, String division, double revDolar, double deltaPercent, int saleUnit, double aurDolar, double mdPercent, double inSeasonPercent, double stPercent, int buyUnit, int yearNum) {
		this.bpTop2DownPlatformId = bpTop2DownPlatformId;
		this.platform = platform;
		this.division = division;
		this.revDolar = revDolar;
		this.deltaPercent = deltaPercent;
		this.saleUnit = saleUnit;
		this.aurDolar = aurDolar;
		this.mdPercent = mdPercent;
		this.inSeasonPercent = inSeasonPercent;
		this.stPercent = stPercent;
		this.buyUnit = buyUnit;
		this.yearNum = yearNum;
	}

	public String toString() {
		return "bpTop2DownPlatformId=" + bpTop2DownPlatformId + ", platform=" + platform + ", division=" + division + ", revDolar=" + revDolar + ", deltaPercent=" + deltaPercent + ", saleUnit=" + saleUnit + ", aurDolar=" + aurDolar + ", mdPercent=" + mdPercent + ", inSeasonPercent=" + inSeasonPercent + ", stPercent=" + stPercent + ", buyUnit=" + buyUnit + ", yearNum=" + yearNum;
	}

	public void toSyn(BuyPlanTop2DownPlatformDetail bpt2dpd) {
		this.platform = (bpt2dpd.getPlatform() != null && !bpt2dpd.getPlatform().equals("")) ? bpt2dpd.getPlatform() : this.platform;
		this.division = (bpt2dpd.getDivision() != null && !bpt2dpd.getDivision().equals("")) ? bpt2dpd.getDivision() : this.division;
		this.revDolar = (bpt2dpd.getRevDolar() != (double)0.0) ? bpt2dpd.getRevDolar() : this.revDolar;
		this.deltaPercent = (bpt2dpd.getDeltaPercent() != (double)0.0) ? bpt2dpd.getDeltaPercent() : this.deltaPercent;
		this.saleUnit = (bpt2dpd.getSaleUnit() != 0) ? bpt2dpd.getSaleUnit() : this.saleUnit;
		this.aurDolar = (bpt2dpd.getAurDolar() != (double)0.0) ? bpt2dpd.getAurDolar() : this.aurDolar;
		this.mdPercent = (bpt2dpd.getMdPercent() != (double)0.0) ? bpt2dpd.getMdPercent() : this.mdPercent;
		this.inSeasonPercent = (bpt2dpd.getInSeasonPercent() != (double)0.0) ? bpt2dpd.getInSeasonPercent() : this.inSeasonPercent;
		this.stPercent = (bpt2dpd.getStPercent() != (double)0.0) ? bpt2dpd.getStPercent() : this.stPercent;
		this.buyUnit = (bpt2dpd.getBuyUnit() != 0) ? bpt2dpd.getBuyUnit() : this.buyUnit;
		this.yearNum = (bpt2dpd.getYearNum() != 0) ? bpt2dpd.getYearNum() : this.yearNum;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BP_T2D_PLATFORM_ID")
	public int getBpTop2DownPlatformId() {
		return bpTop2DownPlatformId;
	}

	public void setBpTop2DownPlatformId(int bpTop2DownPlatformId) {
		this.bpTop2DownPlatformId = bpTop2DownPlatformId;
	}

	@Column(name="PLATFORM")
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Column(name="DIVISION")
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Column(name="REV_DOLAR")
	public double getRevDolar() {
		return revDolar;
	}

	public void setRevDolar(double revDolar) {
		this.revDolar = revDolar;
	}

	@Column(name="DELTA_PERCENT")
	public double getDeltaPercent() {
		return deltaPercent;
	}

	public void setDeltaPercent(double deltaPercent) {
		this.deltaPercent = deltaPercent;
	}

	@Column(name="SALE_UNIT")
	public int getSaleUnit() {
		return saleUnit;
	}

	public void setSaleUnit(int saleUnit) {
		this.saleUnit = saleUnit;
	}

	@Column(name="AUR_DOLAR")
	public double getAurDolar() {
		return aurDolar;
	}

	public void setAurDolar(double aurDolar) {
		this.aurDolar = aurDolar;
	}

	@Column(name="MD_PERCENT")
	public double getMdPercent() {
		return mdPercent;
	}

	public void setMdPercent(double mdPercent) {
		this.mdPercent = mdPercent;
	}

	@Column(name="IN_SEA_PERCENT")
	public double getInSeasonPercent() {
		return inSeasonPercent;
	}

	public void setInSeasonPercent(double inSeasonPercent) {
		this.inSeasonPercent = inSeasonPercent;
	}

	@Column(name="ST_PERCENT")
	public double getStPercent() {
		return stPercent;
	}

	public void setStPercent(double stPercent) {
		this.stPercent = stPercent;
	}

	@Column(name="BUY_UNIT")
	public int getBuyUnit() {
		return buyUnit;
	}

	public void setBuyUnit(int buyUnit) {
		this.buyUnit = buyUnit;
	}

	@Column(name="YEAR_NUM")
	public int getYearNum() {
		return yearNum;
	}

	public void setYearNum(int yearNum) {
		this.yearNum = yearNum;
	}

	@Transient
	public String getDt_rowid() {
		return "row_" + bpTop2DownPlatformId;
	}

	public void setDt_rowid(String dt_rowid) {
		this.dt_rowid = dt_rowid;
	}
}