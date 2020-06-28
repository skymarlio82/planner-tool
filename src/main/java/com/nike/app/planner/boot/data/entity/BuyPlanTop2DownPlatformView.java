
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
@Table(name="PT_BP_T2D_PLATFORM_LY_TY_CMP_ALL_V")
public class BuyPlanTop2DownPlatformView implements Serializable {

	private static final long serialVersionUID = -4495113599757518715L;

	private int bpTop2DownPlatformId = 0;
	private String platform = null;
	private String division = null;
	private double tyRevDolar = (double)0.0;
	private double tyDeltaPercent = (double)0.0;
	private int tySaleUnit = 0;
	private double tyAurDolar = (double)0.0;
	private double tyStPercent = (double)0.0;
	private int tyBuyUnit = 0;
	private double lyRevDolar = (double)0.0;
	private int lySaleUnit = 0;
	private double lyAurDolar = (double)0.0;
	private double lyMdPercent = (double)0.0;
	private double lyInSeasonPercent = (double)0.0;
	private int lyBuyUnit = 0;
	private double lyStPercent = (double)0.0;
	private double tyRevDolarPercent = (double)0.0;
	private double lyRevDolarPercent = (double)0.0;
	private double varRevDolarPercent = (double)0.0;
	@JsonProperty("DT_RowId")
	private String dt_rowid = null;

	public BuyPlanTop2DownPlatformView() {
		
	}

	public String toString() {
		return "bpTop2DownPlatformId=" + bpTop2DownPlatformId + ", platform=" + platform + ", division=" + division + ", tyRevDolar=" + tyRevDolar + ", tyDeltaPercent=" + tyDeltaPercent + ", tySaleUnit=" + tySaleUnit + ", tyAurDolar=" + tyAurDolar + ", tyStPercent=" + tyStPercent + ", tyBuyUnit=" + tyBuyUnit + ", lyRevDolar=" + lyRevDolar + ", lySaleUnit=" + lySaleUnit + ", lyAurDolar=" + lyAurDolar + ", lyMdPercent=" + lyMdPercent + ", lyInSeasonPercent=" + lyInSeasonPercent + ", lyBuyUnit=" + lyBuyUnit + ", lyStPercent=" + lyStPercent + ", tyRevDolarPercent=" + tyRevDolarPercent + ", lyRevDolarPercent=" + lyRevDolarPercent + ", varRevDolarPercent=" + varRevDolarPercent;
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

	@Column(name="TY_REV_DOLAR")
	public double getTyRevDolar() {
		return tyRevDolar;
	}

	public void setTyRevDolar(double tyRevDolar) {
		this.tyRevDolar = tyRevDolar;
	}

	@Column(name="TY_DELTA_PERCENT")
	public double getTyDeltaPercent() {
		return tyDeltaPercent;
	}

	public void setTyDeltaPercent(double tyDeltaPercent) {
		this.tyDeltaPercent = tyDeltaPercent;
	}

	@Column(name="TY_SALE_UNIT")
	public int getTySaleUnit() {
		return tySaleUnit;
	}

	public void setTySaleUnit(int tySaleUnit) {
		this.tySaleUnit = tySaleUnit;
	}

	@Column(name="TY_AUR_DOLAR")
	public double getTyAurDolar() {
		return tyAurDolar;
	}

	public void setTyAurDolar(double tyAurDolar) {
		this.tyAurDolar = tyAurDolar;
	}

	@Column(name="TY_ST_PERCENT")
	public double getTyStPercent() {
		return tyStPercent;
	}

	public void setTyStPercent(double tyStPercent) {
		this.tyStPercent = tyStPercent;
	}

	@Column(name="TY_BUY_UNIT")
	public int getTyBuyUnit() {
		return tyBuyUnit;
	}

	public void setTyBuyUnit(int tyBuyUnit) {
		this.tyBuyUnit = tyBuyUnit;
	}

	@Column(name="LY_REV_DOLAR")
	public double getLyRevDolar() {
		return lyRevDolar;
	}

	public void setLyRevDolar(double lyRevDolar) {
		this.lyRevDolar = lyRevDolar;
	}

	@Column(name="LY_SALE_UNIT")
	public int getLySaleUnit() {
		return lySaleUnit;
	}

	public void setLySaleUnit(int lySaleUnit) {
		this.lySaleUnit = lySaleUnit;
	}

	@Column(name="LY_AUR_DOLAR")
	public double getLyAurDolar() {
		return lyAurDolar;
	}

	public void setLyAurDolar(double lyAurDolar) {
		this.lyAurDolar = lyAurDolar;
	}

	@Column(name="LY_MD_PERCENT")
	public double getLyMdPercent() {
		return lyMdPercent;
	}

	public void setLyMdPercent(double lyMdPercent) {
		this.lyMdPercent = lyMdPercent;
	}

	@Column(name="LY_IN_SEA_PERCENT")
	public double getLyInSeasonPercent() {
		return lyInSeasonPercent;
	}

	public void setLyInSeasonPercent(double lyInSeasonPercent) {
		this.lyInSeasonPercent = lyInSeasonPercent;
	}

	@Column(name="LY_BUY_UNIT")
	public int getLyBuyUnit() {
		return lyBuyUnit;
	}

	public void setLyBuyUnit(int lyBuyUnit) {
		this.lyBuyUnit = lyBuyUnit;
	}

	@Column(name="LY_ST_PERCENT")
	public double getLyStPercent() {
		return lyStPercent;
	}

	public void setLyStPercent(double lyStPercent) {
		this.lyStPercent = lyStPercent;
	}

	@Column(name="TY_REV_DOLAR_PERCENT")
	public double getTyRevDolarPercent() {
		return tyRevDolarPercent;
	}

	public void setTyRevDolarPercent(double tyRevDolarPercent) {
		this.tyRevDolarPercent = tyRevDolarPercent;
	}

	@Column(name="LY_REV_DOLAR_PERCENT")
	public double getLyRevDolarPercent() {
		return lyRevDolarPercent;
	}

	public void setLyRevDolarPercent(double lyRevDolarPercent) {
		this.lyRevDolarPercent = lyRevDolarPercent;
	}

	@Column(name="VAR_REV_DOLAR_PERCENT")
	public double getVarRevDolarPercent() {
		return varRevDolarPercent;
	}

	public void setVarRevDolarPercent(double varRevDolarPercent) {
		this.varRevDolarPercent = varRevDolarPercent;
	}

	@Transient
	public String getDt_rowid() {
		return "row_" + bpTop2DownPlatformId;
	}

	public void setDt_rowid(String dt_rowid) {
		this.dt_rowid = dt_rowid;
	}
}