
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
@Table(name="PT_ASSORTMENT_IMAGE_TAB")
public class AssortmentImage implements Serializable {

	private static final long serialVersionUID = -7164372483694763636L;

	private int assortmentImageId = 0;
	private String division = null;
	private String attribute1 = null;
	private String attribute3 = null;
	private String styleName = null;
	private int styleRank = 0;
	private String image = null;
	@JsonProperty("DT_RowId")
	private String dt_rowid = null;

	public AssortmentImage() {
		
	}

	public AssortmentImage(int assortmentImageId, String division, String attribute1, String attribute3, String styleName, int styleRank, String image) {
		this.assortmentImageId = assortmentImageId;
		this.division = division;
		this.attribute1 = attribute1;
		this.attribute3 = attribute3;
		this.styleName = styleName;
		this.styleRank = styleRank;
		this.image = image;
	}

	public String toString() {
		return "assortmentImageId=" + assortmentImageId + ", division=" + division + ", attribute1=" + attribute1 + ", attribute3=" + attribute3 + ", styleName=" + styleName + ", styleRank=" + styleRank + ", image=" + image;
	}

	public void toSyn(AssortmentImage ai) {
		this.division = (ai.getDivision() != null && !ai.getDivision().equals("")) ? ai.getDivision() : this.division;
		this.attribute1 = (ai.getAttribute1() != null && !ai.getAttribute1().equals("")) ? ai.getAttribute1(): this.attribute1;
		this.attribute3 = (ai.getAttribute3() != null && !ai.getAttribute3().equals("")) ? ai.getAttribute3() : this.attribute3;
		this.styleName = (ai.getStyleName() != null && !ai.getStyleName().equals("")) ? ai.getStyleName() : this.styleName;
		this.styleRank = (ai.getStyleRank() != 0) ? ai.getStyleRank() : this.styleRank;
		this.image = (ai.getImage() != null && !ai.getImage().equals("")) ? ai.getImage() : this.image;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ASSORTMENT_IMAGE_ID")
	public int getAssortmentImageId() {
		return assortmentImageId;
	}

	public void setAssortmentImageId(int assortmentImageId) {
		this.assortmentImageId = assortmentImageId;
	}

	@Column(name="DIVISION")
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Column(name="ATTRIBUTE_1")
	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	@Column(name="ATTRIBUTE_3")
	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	@Column(name="STYLE_NAME")
	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	@Column(name="STYLE_RANK")
	public int getStyleRank() {
		return styleRank;
	}

	public void setStyleRank(int styleRank) {
		this.styleRank = styleRank;
	}

	@Column(name="IMAGE_B64")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Transient
	public String getDt_rowid() {
		return "row_" + assortmentImageId;
	}

	public void setDt_rowid(String dt_rowid) {
		this.dt_rowid = dt_rowid;
	}
}