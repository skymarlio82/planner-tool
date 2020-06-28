
package com.nike.app.planner.boot.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nike.app.planner.boot.util.convert.SimpleFormater;

@Entity
@Table(name="PT_ASSORT_PLAN_DETAIL_TAB")
public class AssortmentDetail implements Serializable {

	private static final long serialVersionUID = 63103661182969719L;

	private int assortmentPlanId = 0;
	private AssortmentImage image = null;
	private String category = null;
	private String division = null;
	private String season = null;
	private int productId = 0;
	private String style = null;
	private String productCode = null;
	private String gender = null;
	private String age = null;
	private String styleName = null;
	private String silhouette = null;
	private Date dtcOmd = null;
	private String dtcOmdTxt = null;
	private Date mmxOmd = null;
	private String mmxOmdTxt = null;
	private String month = null;
	private int sellingWeeks = 0;
	private String flow = null;
	private String fullColorDescription = null;
	private double cnmsrp = (double)0;
	private double hkmsrp = (double)0;
	private double twmsrp = (double)0;
	private String attribute1 = null;
	private String attribute2 = null;
	private String attribute3 = null;
	private String blindBuy = null;
	private String dmca = null;
	private int styleRank = 0;
	private int colorRank = 0;
	private String referenceStyleName = null;
	private int storeCount = 0;
	private int nikeComFlag = 0;
	private int tmallFlag = 0;
	private int hkComFlag = 0;
	@JsonProperty("DT_RowId")
	private String dt_rowid = null;

	public AssortmentDetail() {
		
	}

	public AssortmentDetail(int assortmentPlanId, AssortmentImage image, String category, String division, String season, int productId, String style, String productCode, String gender, String age, String styleName, String silhouette, Date dtcOmd, Date mmxOmd, String month, int sellingWeeks, String flow, String fullColorDescription, double cnmsrp, double hkmsrp, double twmsrp, String attribute1, String attribute2, String attribute3, String blindBuy, String dmca, int styleRank, int colorRank, String referenceStyleName, int storeCount, int nikeComFlag, int tmallFlag, int hkComFlag) {
		this.assortmentPlanId = assortmentPlanId;
		this.image = image;
		this.category = category;
		this.division = division;
		this.season = season;
		this.productId = productId;
		this.style = style;
		this.productCode = productCode;
		this.gender = gender;
		this.age = age;
		this.styleName = styleName;
		this.silhouette = silhouette;
		this.dtcOmd = dtcOmd;
		this.mmxOmd = mmxOmd;
		this.month = month;
		this.sellingWeeks = sellingWeeks;
		this.flow = flow;
		this.fullColorDescription = fullColorDescription;
		this.cnmsrp = cnmsrp;
		this.hkmsrp = hkmsrp;
		this.twmsrp = twmsrp;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.blindBuy = blindBuy;
		this.dmca = dmca;
		this.styleRank = styleRank;
		this.colorRank = colorRank;
		this.referenceStyleName = referenceStyleName;
		this.storeCount = storeCount;
		this.nikeComFlag = nikeComFlag;
		this.tmallFlag = tmallFlag;
		this.hkComFlag = hkComFlag;
	}

	public String toString() {
		return "assortmentPlanId=" + assortmentPlanId + ", image=" + image + ", category=" + category + ", division=" + division + ", season=" + season + ", productId=" + productId + ", style=" + style + ", productCode=" + productCode + ", gender=" + gender + ", age=" + age + ", styleName=" + styleName + ", silhouette=" + silhouette + ", dtcOmd=" + dtcOmdTxt + ", mmxOmd=" + mmxOmdTxt + ", month=" + month + ", sellingWeeks=" + sellingWeeks + ", flow=" + flow + ", fullColorDescription=" + fullColorDescription + ", cnmsrp=" + cnmsrp + ", hkmsrp=" + hkmsrp + ", twmsrp=" + twmsrp + ", attribute1=" + attribute1 + ", attribute2=" + attribute2 + ", attribute3=" + attribute3 + ", blindBuy=" + blindBuy + ", dmca=" + dmca + ", styleRank=" + styleRank + ", colorRank=" + colorRank  + ", referenceStyleName=" + referenceStyleName + ", storeCount=" + storeCount + ", nikeComFlag = " + nikeComFlag + ", tmallFlag = " + tmallFlag + ", hkComFlag = " + hkComFlag;
	}

	public void toSyn(AssortmentDetail ad) {
		this.image = (ad.getImage() != null) ? ad.getImage() : this.image;
		this.category = (ad.getCategory() != null && !ad.getCategory().equals("")) ? ad.getCategory() : this.category;
		this.division = (ad.getDivision() != null && !ad.getDivision().equals("")) ? ad.getDivision() : this.division;
		this.season = (ad.getSeason() != null && !ad.getSeason().equals("")) ? ad.getSeason() : this.season;
		this.productId = (ad.getProductId() != 0) ? ad.getProductId() : this.productId;
		this.style = (ad.getStyle() != null && !ad.getStyle().equals("")) ? ad.getStyle() : this.style;
		this.productCode = (ad.getProductCode() != null && !ad.getProductCode().equals("")) ? ad.getProductCode() : this.productCode;
		this.gender = (ad.getGender() != null && !ad.getGender().equals("")) ? ad.getGender() : this.gender;
		this.age = (ad.getAge() != null && !ad.getAge().equals("")) ? ad.getAge() : this.age;
		this.styleName = (ad.getStyleName() != null && !ad.getStyleName().equals("")) ? ad.getStyleName() : this.styleName;
		this.silhouette = (ad.getSilhouette() != null && !ad.getSilhouette().equals("")) ? ad.getSilhouette() : this.silhouette;
		this.dtcOmd = (ad.getDtcOmd() != null) ? ad.getDtcOmd() : this.dtcOmd;
		this.mmxOmd = (ad.getMmxOmd() != null) ? ad.getMmxOmd() : this.mmxOmd;
		this.month = (ad.getMonth() != null && !ad.getMonth().equals("")) ? ad.getMonth() : this.month;
		this.sellingWeeks = (ad.getSellingWeeks() != 0) ? ad.getSellingWeeks() : this.sellingWeeks;
		this.flow = (ad.getFlow() != null && !ad.getFlow().equals("")) ? ad.getFlow() : this.flow;
		this.fullColorDescription = (ad.getFullColorDescription() != null && !ad.getFullColorDescription().equals("")) ? ad.getFullColorDescription() : this.fullColorDescription;
		this.cnmsrp = (ad.getCnmsrp() != (double)0) ? ad.getCnmsrp() : this.cnmsrp;
		this.hkmsrp = (ad.getHkmsrp() != (double)0) ? ad.getHkmsrp() : this.hkmsrp;
		this.twmsrp = (ad.getTwmsrp() != (double)0) ? ad.getTwmsrp() : this.twmsrp;
		this.attribute1 = (ad.getAttribute1() != null && !ad.getAttribute1().equals("")) ? ad.getAttribute1(): this.attribute1;
		this.attribute2 = (ad.getAttribute2() != null && !ad.getAttribute2().equals("")) ? ad.getAttribute2() : this.attribute2;
		this.attribute3 = (ad.getAttribute3() != null && !ad.getAttribute3().equals("")) ? ad.getAttribute3() : this.attribute3;
		this.blindBuy = (ad.getBlindBuy() != null && !ad.getBlindBuy().equals("")) ? ad.getBlindBuy() : this.blindBuy;
		this.dmca = (ad.getDmca() != null && !ad.getDmca().equals("")) ? ad.getDmca() : this.dmca;
		this.styleRank = (ad.getStyleRank() != 0) ? ad.getStyleRank() : this.styleRank;
		this.colorRank = (ad.getColorRank() != 0) ? ad.getColorRank() : this.colorRank;
		this.referenceStyleName = (ad.getReferenceStyleName() != null && !ad.getReferenceStyleName().equals("")) ? ad.getReferenceStyleName() : this.referenceStyleName;
		this.storeCount = (ad.getStoreCount() != 0) ? ad.getStoreCount() : this.storeCount;
		this.nikeComFlag = (ad.getNikeComFlag() != 0) ? ad.getNikeComFlag() : this.nikeComFlag;
		this.tmallFlag = (ad.getTmallFlag() != 0) ? ad.getTmallFlag() : this.tmallFlag;
		this.hkComFlag = (ad.getHkComFlag() != 0) ? ad.getHkComFlag() : this.hkComFlag;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ASSORT_PLAN_ID")
	public int getAssortmentPlanId() {
		return assortmentPlanId;
	}

	public void setAssortmentPlanId(int assortmentPlanId) {
		this.assortmentPlanId = assortmentPlanId;
	}

	@ManyToOne
	@JoinColumn(name="ASSORTMENT_IMAGE_ID", nullable=false)
	public AssortmentImage getImage() {
		return image;
	}

	public void setImage(AssortmentImage image) {
		this.image = image;
	}

	@Column(name="CATEGORY")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name="DIVISION")
	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Column(name="SEASON")
	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	@Column(name="PRODUCT_ID")
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name="PRODUCT_CODE")
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name="STYLE")
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Column(name="GENDER")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="AGE")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Column(name="STYLE_NAME")
	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	@Column(name="SILHOUETTE")
	public String getSilhouette() {
		return silhouette;
	}

	public void setSilhouette(String silhouette) {
		this.silhouette = silhouette;
	}

	@Column(name="DTC_OMD")
	public Date getDtcOmd() {
		return dtcOmd;
	}

	public void setDtcOmd(Date dtcOmd) {
		this.dtcOmd = dtcOmd;
	}

	@Column(name="MMX_OMD")
	public Date getMmxOmd() {
		return mmxOmd;
	}

	public void setMmxOmd(Date mmxOmd) {
		this.mmxOmd = mmxOmd;
	}

	@Column(name="MONTH")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name="SELLING_WEEKS")
	public int getSellingWeeks() {
		return sellingWeeks;
	}

	public void setSellingWeeks(int sellingWeeks) {
		this.sellingWeeks = sellingWeeks;
	}

	@Column(name="FLOW")
	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	@Column(name="FULL_COLOR_DESCRIPTION")
	public String getFullColorDescription() {
		return fullColorDescription;
	}

	public void setFullColorDescription(String fullColorDescription) {
		this.fullColorDescription = fullColorDescription;
	}

	@Column(name="CN_MSRP")
	public double getCnmsrp() {
		return cnmsrp;
	}

	public void setCnmsrp(double cnmsrp) {
		this.cnmsrp = cnmsrp;
	}

	@Column(name="HK_MSRP")
	public double getHkmsrp() {
		return hkmsrp;
	}

	public void setHkmsrp(double hkmsrp) {
		this.hkmsrp = hkmsrp;
	}

	@Column(name="TW_MSRP")
	public double getTwmsrp() {
		return twmsrp;
	}

	public void setTwmsrp(double twmsrp) {
		this.twmsrp = twmsrp;
	}

	@Column(name="ATTRIBUTE_1")
	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	@Column(name="ATTRIBUTE_2")
	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	@Column(name="ATTRIBUTE_3")
	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	@Column(name="BLIND_BUY")
	public String getBlindBuy() {
		return blindBuy;
	}

	public void setBlindBuy(String blindBuy) {
		this.blindBuy = blindBuy;
	}

	@Column(name="DMCA")
	public String getDmca() {
		return dmca;
	}

	public void setDmca(String dmca) {
		this.dmca = dmca;
	}

	@Column(name="STYLE_RANK")
	public int getStyleRank() {
		return styleRank;
	}

	public void setStyleRank(int styleRank) {
		this.styleRank = styleRank;
	}

	@Column(name="COLOR_RANK")
	public int getColorRank() {
		return colorRank;
	}

	public void setColorRank(int colorRank) {
		this.colorRank = colorRank;
	}

	@Column(name="REFERENCE_STYLE_NAME")
	public String getReferenceStyleName() {
		return referenceStyleName;
	}

	public void setReferenceStyleName(String referenceStyleName) {
		this.referenceStyleName = referenceStyleName;
	}

	@Column(name="STORE_COUNT")
	public int getStoreCount() {
		return storeCount;
	}

	public void setStoreCount(int storeCount) {
		this.storeCount = storeCount;
	}

	@Column(name="NIKECOM_FLAG")
	public int getNikeComFlag() {
		return nikeComFlag;
	}

	public void setNikeComFlag(int nikeComFlag) {
		this.nikeComFlag = nikeComFlag;
	}

	@Column(name="TMALL_FLAG")
	public int getTmallFlag() {
		return tmallFlag;
	}

	public void setTmallFlag(int tmallFlag) {
		this.tmallFlag = tmallFlag;
	}

	@Column(name="HKCOM_FLAG")
	public int getHkComFlag() {
		return hkComFlag;
	}

	public void setHkComFlag(int hkComFlag) {
		this.hkComFlag = hkComFlag;
	}

	@Transient
	public String getDt_rowid() {
		return "row_" + assortmentPlanId;
	}

	public void setDt_rowid(String dt_rowid) {
		this.dt_rowid = dt_rowid;
	}

	@Transient
	public String getDtcOmdTxt() {
		return SimpleFormater.simpleFormate(dtcOmd);
	}

	public void setDtcOmdTxt(String dtcOmdTxt) {
		this.dtcOmdTxt = dtcOmdTxt;
	}

	@Transient
	public String getMmxOmdTxt() {
		return SimpleFormater.simpleFormate(mmxOmd);
	}

	public void setMmxOmdTxt(String mmxOmdTxt) {
		this.mmxOmdTxt = mmxOmdTxt;
	}
}