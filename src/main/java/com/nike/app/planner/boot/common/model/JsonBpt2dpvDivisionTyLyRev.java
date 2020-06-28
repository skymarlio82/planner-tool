
package com.nike.app.planner.boot.common.model;

public class JsonBpt2dpvDivisionTyLyRev {

	private String division = null;
	private double tyRev = (double)0.0;
	private double lyRev = (double)0.0;

	public JsonBpt2dpvDivisionTyLyRev() {
		
	}

	public JsonBpt2dpvDivisionTyLyRev(String division, double tyRev, double lyRev) {
		this.division = division;
		this.tyRev = tyRev;
		this.lyRev = lyRev;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public double getTyRev() {
		return tyRev;
	}

	public void setTyRev(double tyRev) {
		this.tyRev = tyRev;
	}

	public double getLyRev() {
		return lyRev;
	}

	public void setLyRev(double lyRev) {
		this.lyRev = lyRev;
	}
}