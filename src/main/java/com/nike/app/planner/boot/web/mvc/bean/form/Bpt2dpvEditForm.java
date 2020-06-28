
package com.nike.app.planner.boot.web.mvc.bean.form;

@UrlEncodedForm("BPT2DPV_EDIT_FORM")
public class Bpt2dpvEditForm implements UrlEncodedFormBean {

	private String actionName = null;
	private int id = 0;
	private String tyDeltaPercent = null;
	private String tyStPercent = null;

	public Bpt2dpvEditForm() {
		
	}

	public int getId() {
		return id;
	}

	@UrlEncodedFormFieldMapping("id")
	public void setId(int id) {
		this.id = id;
	}

	public String getTyDeltaPercent() {
		return tyDeltaPercent;
	}

	@UrlEncodedFormFieldMapping("tyDeltaPercent")
	public void setTyDeltaPercent(String tyDeltaPercent) {
		this.tyDeltaPercent = tyDeltaPercent;
	}

	public String getTyStPercent() {
		return tyStPercent;
	}

	@UrlEncodedFormFieldMapping("tyStPercent")
	public void setTyStPercent(String tyStPercent) {
		this.tyStPercent = tyStPercent;
	}

	@Override
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Override
	public String getActionName() {
		return actionName;
	}
}