
package com.nike.app.planner.boot.data.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.nike.app.planner.boot.data.entity.StaffDetail;

public interface StaffService {

	List<StaffDetail> readAllStaffDetails();
	StaffDetail readStaffDetailById(int staffId);
	void saveStaffDetail(StaffDetail staffDetail);
	<T> Map<String, List<T>> processStaffDetailAction(String requestBody);
	void uploadStaffDetailsByExcel(InputStream is);
	void downloadStaffDetailsAsExcel(OutputStream os);
}
