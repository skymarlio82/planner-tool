
package com.nike.app.planner.boot.web.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nike.app.planner.boot.common.constant.WebAppConstant;
import com.nike.app.planner.boot.common.model.JsonBpt2dpvDivisionGcTotal;
import com.nike.app.planner.boot.common.model.JsonBpt2dpvDivisionTyLyRev;
import com.nike.app.planner.boot.common.model.JsonBpt2dpvPlanResult;
import com.nike.app.planner.boot.common.model.JsonCjsLabelYModel;
import com.nike.app.planner.boot.common.model.JsonReturnResult;
import com.nike.app.planner.boot.data.service.Bpt2dpdService;
import com.nike.app.planner.boot.util.convert.SimpleFormater;
import com.nike.app.planner.boot.web.mvc.bean.form.Bpt2dAutofillForm;

@Controller
@RequestMapping("/buyplan/bpt2dpv")
public class Bpt2dpvController {

	@Autowired
	private Bpt2dpdService bpt2dpdService = null;

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/rest/api", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:read")
	public <T> Map<String, List<T>> apiOfBpt2dpv() {
		Map<String, List<T>> result = new HashMap<String, List<T>>();
		result.put("data", (List<T>)bpt2dpdService.getAllBuyPlanTop2DownPlatformViews());
		result.put("options", (List<T>)(new ArrayList<String>()));
		result.put("files", (List<T>)(new ArrayList<String>()));
		return result;
	}
	
	@RequestMapping(value="/rest/api/getplannedresult", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:read")
	public JsonBpt2dpvPlanResult getBpt2dpvPlannedResult() {
		JsonBpt2dpvPlanResult result = new JsonBpt2dpvPlanResult();
		result.setGrandTotal(WebAppConstant.DUMMY_GRAND_TOTAL_BUDGET);
		result.setPlanUsed(SimpleFormater.d2d2(bpt2dpdService.getBpt2dpvPlannedCost()));
		result.setRemain(SimpleFormater.d2d2(result.getGrandTotal() - result.getPlanUsed()));
		return result;
	}
	
	@RequestMapping(value="/rest/api/getcjsdivisiontylyrevs", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:read")
	public Map<String, List<JsonCjsLabelYModel>> fetchCjsDivisionTyLyRevsByPlatform(@RequestParam(required=true, name="platform") String platform) {
		return bpt2dpdService.getCjsDivisionTyLyRevsByPlatform(platform);
	}

	@RequestMapping(value="/rest/api/getcjsdivisiongctotal", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:read")
	public List<JsonCjsLabelYModel> fetchCjsDivisionGCTotalByPlatform() {
		return bpt2dpdService.getCjsDivisionGcTotal();
	}
	
	@RequestMapping(value="/rest/api", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:write")
	public <T> Map<String, List<T>> apiOfBpt2dpv(@RequestBody String requestBody) {
		bpt2dpdService.processActionOfBpt2dpv(requestBody);
		return apiOfBpt2dpv();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/rest/api/filter", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:read")
	public <T> Map<String, List<T>> retrieveBpt2dpvByConditions(@RequestParam(required=true, name="platform") String platform, @RequestParam(required=true, name="division") String division) {
		Map<String, List<T>> result = new HashMap<String, List<T>>();
		result.put("data", (List<T>)bpt2dpdService.getBpt2dpvByCriteria(platform, division));
		result.put("options", (List<T>)(new ArrayList<String>()));
		result.put("files", (List<T>)(new ArrayList<String>()));
		return result;
	}

	@RequestMapping(value="/rest/api/getdivisiontylyrevs", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:read")
	public List<JsonBpt2dpvDivisionTyLyRev> fetchDivisionTyLyRevsByPlatform(@RequestParam(required=true, name="platform") String platform) {
		return bpt2dpdService.getDivisionTyLyRevsByPlatform(platform);
	}

	@RequestMapping(value="/rest/api/getdivisiongctotal", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:read")
	public List<JsonBpt2dpvDivisionGcTotal> fetchDivisionGCTotalByPlatform() {
		return bpt2dpdService.getDivisionGcTotal();
	}

	@RequestMapping(value="/download/excel", method=RequestMethod.GET)
	@RequiresPermissions("suser:read")
    public void downloadBpt2dpvAsExcel(HttpServletResponse response) throws IOException {
		// set MIME type for forcing download
		response.setContentType("application/force-download");
		// set content length (-1) any
		response.setContentLength(-1);
		// set content transfer encode as 'binary'
		response.setHeader("Content-Transfer-Encoding", "binary");
		// attachment download's name
		response.setHeader("Content-Disposition", "attachment; filename=\"" + "BuyPlanTop2DownPlatform.xls\"");
		bpt2dpdService.downloadBpt2dpvAsExcel(response.getOutputStream());
	}

	@RequestMapping(value="/rest/api/commitall", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:write")
	public JsonReturnResult commitAll() {
		bpt2dpdService.commitAllBpt2dpvs();
		return new JsonReturnResult();
	}

	@RequestMapping(value="/rest/api/updateautofill", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("suser:write")
	public JsonReturnResult updateBatchBpt2dpvForAutoFill(@RequestBody @Valid Bpt2dAutofillForm bpt2dpvAutofillForm) {
		bpt2dpdService.processBpt2dpvAutoFillForm(bpt2dpvAutofillForm);
		return new JsonReturnResult();
	}
}