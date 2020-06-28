
package com.nike.app.planner.boot.data.service;

import java.util.List;
import com.nike.app.planner.boot.data.entity.StaffSalaryDetail;
import com.nike.app.planner.boot.web.mvc.bean.form.StaffSalaryDetailForm;

public interface StaffSalaryService {

	List<StaffSalaryDetail> readAllStaffSalaryDetails();
	StaffSalaryDetail readStaffSalaryDetail(int staffId);
	void saveStaffSalaryDetail(StaffSalaryDetail staffSalaryDetail);
	void synchronizeStaffSalary(int staffId, double salary);
	void applyStaffSalaryChange(StaffSalaryDetailForm staffSalaryDetailForm);
}
