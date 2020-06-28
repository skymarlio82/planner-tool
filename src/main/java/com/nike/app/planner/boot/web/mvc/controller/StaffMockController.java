
package com.nike.app.planner.boot.web.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.nike.app.planner.boot.common.constant.WebAppConstant;
import com.nike.app.planner.boot.common.model.JsonReturnResult;
import com.nike.app.planner.boot.data.service.StaffSalaryService;
import com.nike.app.planner.boot.data.service.StaffService;
import com.nike.app.planner.boot.util.log.SimpleLogger;
import com.nike.app.planner.boot.web.mvc.bean.form.StaffSalaryDetailForm;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/staffmock")
public class StaffMockController {

	@Autowired
	private StaffService staffService = null;

	@Autowired
	private StaffSalaryService staffSalaryService = null;

	@RequestMapping(value="/template/home", method=RequestMethod.GET)
	@RequiresPermissions("admin:view")
	public String redirectStaffMockHome() {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "start to load staff mock home page ...");
		return WebAppConstant.STAFF_MOCK_TEST_HOME_PAGE;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/rest/api/staff", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@ApiOperation(value="Get all the staff entities.", notes="Get all the staff entities.")
	@RequiresPermissions("admin:read")
	public <T> Map<String, List<T>> apiOfStaff() {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "try to load all the staff entities ...");
		Map<String, List<T>> result = new HashMap<String, List<T>>();
		result.put("data", (List<T>)staffService.readAllStaffDetails());
		result.put("options", (List<T>)(new ArrayList<String>()));
		result.put("files", (List<T>)(new ArrayList<String>()));
		return result;
	}

	@RequestMapping(value="/rest/api/staff", method=RequestMethod.POST, consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("admin:write")
	public <T> Map<String, List<T>> apiOfStaffActions(@RequestBody String requestBody) {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "do the action for staff : " + requestBody);
		return staffService.processStaffDetailAction(requestBody);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/rest/api/staffsalary", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("admin:read")
	public <T> Map<String, List<T>> apiOfStaffSalary() {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "try to load all the staff salary entities ...");
		Map<String, List<T>> result = new HashMap<String, List<T>>();
		result.put("data", (List<T>)staffSalaryService.readAllStaffSalaryDetails());
		result.put("options", (List<T>)(new ArrayList<String>()));
		result.put("files", (List<T>)(new ArrayList<String>()));
		return result;
	}

	@RequestMapping(value="/salary/updatesalarydetailbystaffid", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("admin:write")
	public JsonReturnResult updateSalaryDetailbyStaffId(@RequestParam(required=true, name="staffid") int staffId, @RequestParam(required=true, name="newsalary") double newsalary) {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "update the salary for staff : staffId = " + staffId + ", newsalary = " + newsalary);
		staffSalaryService.synchronizeStaffSalary(staffId, newsalary);
		return new JsonReturnResult(JsonReturnResult.SUCCESS);
	}

	@RequestMapping(value="/staffsalary/applysalarydetailchanged", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequiresPermissions("admin:write")
	public JsonReturnResult applySalaryDetailChangeBackToStaff(@RequestBody StaffSalaryDetailForm staffSalaryDetailForm) {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "apply the salary change for staff : staffSalaryDetailForm = " + staffSalaryDetailForm);
		staffSalaryService.applyStaffSalaryChange(staffSalaryDetailForm);
		return new JsonReturnResult(JsonReturnResult.SUCCESS);
	}

	@RequestMapping(value="/test/uploadfile", method=RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("admin:write")
	public JsonReturnResult uploadFileAndSave(@RequestParam("file") MultipartFile file) throws IOException {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "upload file and save to system for batch processing staff entity ...");
		staffService.uploadStaffDetailsByExcel(file.getInputStream());
		return new JsonReturnResult(JsonReturnResult.SUCCESS);
	}

	@RequestMapping(value="/staffdetail/download", method = RequestMethod.GET)
	@RequiresPermissions("admin:read")
    public void downloadFile(HttpServletResponse response) throws IOException {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "start to download records as excel ...");
		// set MIME type for forcing download
		response.setContentType("application/force-download");
		// set content length (-1) any
		response.setContentLength(-1);
		// set content transfer encode as 'binary'
		response.setHeader("Content-Transfer-Encoding", "binary");
		// attachment download's name
		response.setHeader("Content-Disposition", "attachment; filename=\"" + "StaffDetailTestExport.xls\"");
		staffService.downloadStaffDetailsAsExcel(response.getOutputStream());
	}
}