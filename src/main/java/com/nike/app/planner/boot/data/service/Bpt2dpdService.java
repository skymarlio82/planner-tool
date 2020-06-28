
package com.nike.app.planner.boot.data.service;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.nike.app.planner.boot.common.model.JsonCjsLabelYModel;
import com.nike.app.planner.boot.data.entity.BuyPlanTop2DownPlatformView;
import com.nike.app.planner.boot.web.mvc.bean.form.Bpt2dAutofillForm;
import com.nike.app.planner.boot.common.model.JsonBpt2dpvDivisionGcTotal;
import com.nike.app.planner.boot.common.model.JsonBpt2dpvDivisionTyLyRev;

public interface Bpt2dpdService {

	List<BuyPlanTop2DownPlatformView> getAllBuyPlanTop2DownPlatformViews();
	double getBpt2dpvPlannedCost();
	Map<String, List<JsonCjsLabelYModel>> getCjsDivisionTyLyRevsByPlatform(String platform);
	List<JsonCjsLabelYModel> getCjsDivisionGcTotal();
	void processActionOfBpt2dpv(String requestBody);
	List<BuyPlanTop2DownPlatformView> getBpt2dpvByCriteria(String platform, String division);
	List<JsonBpt2dpvDivisionTyLyRev> getDivisionTyLyRevsByPlatform(String platform);
	List<JsonBpt2dpvDivisionGcTotal> getDivisionGcTotal();
	void downloadBpt2dpvAsExcel(OutputStream os);
	void commitAllBpt2dpvs();
	void processBpt2dpvAutoFillForm(Bpt2dAutofillForm bpt2dpvAutofillForm);
}