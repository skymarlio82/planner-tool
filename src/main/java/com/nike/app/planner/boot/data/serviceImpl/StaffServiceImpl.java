
package com.nike.app.planner.boot.data.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nike.app.planner.boot.common.constant.WebAppConstant;
import com.nike.app.planner.boot.data.dao.StaffDetailDao;
import com.nike.app.planner.boot.data.entity.StaffDetail;
import com.nike.app.planner.boot.data.service.StaffService;
import com.nike.app.planner.boot.util.convert.SimpleFormater;
import com.nike.app.planner.boot.util.convert.UrlEncodedFormFactory;
import com.nike.app.planner.boot.util.log.SimpleLogger;
import com.nike.app.planner.boot.web.mvc.bean.form.StaffDetailForm;

import jxl.Image;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Number;

@CacheConfig(cacheNames="staffServiceCache")
@Service("staffService")
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDetailDao staffDetailDao = null;

	@Cacheable
	@Transactional(readOnly=true)
	@Override
	public List<StaffDetail> readAllStaffDetails() {
		List<StaffDetail> list = staffDetailDao.findAll();
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "readAllStaffDetails : result.size = " + list.size());
		return list;
	}

	@Cacheable
	@Transactional(readOnly=true)
	@Override
	public StaffDetail readStaffDetailById(int staffId) {
		SimpleLogger.log(SimpleLogger.INFO, getClass(), "readStaffDetailById : staffId = " + staffId);
		StaffDetail sd = staffDetailDao.findOne(staffId);
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "readStaffDetailById : sd = " + sd);
		return sd;
	}

	@CacheEvict(allEntries=true)
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	@Override
	public void saveStaffDetail(StaffDetail staffDetail) {
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "saveStaffDetail : staffDetail = " + staffDetail);
		staffDetailDao.saveAndFlush(staffDetail);
	}

	@CacheEvict(allEntries=true)
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	@Override
	public <T> Map<String, List<T>> processStaffDetailAction(String requestBody) {
		Map<String, List<T>> result = new HashMap<String, List<T>>();
		StaffDetailForm sdf = null;
		try {
			sdf = (StaffDetailForm)UrlEncodedFormFactory.getInstance().generate(WebAppConstant.URL_ENCODED_STAFF_DETAIL_FORM, requestBody);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return result;
		}
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "processStaffDetailAction : parsed sdf = " + sdf);
		List<StaffDetail> dataList = new ArrayList<StaffDetail>();
		if (sdf.getActionName().equals("edit")) {
			StaffDetail sd = staffDetailDao.findOne(sdf.getId());
			sd.toSynForm(sdf);
			staffDetailDao.saveAndFlush(sd);
			dataList.add(sd);
			result.put("data", (List<T>)dataList);
		} else if (sdf.getActionName().equals("remove")) {
			StaffDetail sd = staffDetailDao.findOne(sdf.getId());
			staffDetailDao.delete(sd);
			result.put("data", new ArrayList<T>());
		} else if (sdf.getActionName().equals("create")) {
			StaffDetail sd = new StaffDetail();
			sd.toSynForm(sdf);
			StaffDetail staffSaved = staffDetailDao.saveAndFlush(sd);
			dataList.add(staffSaved);
			result.put("data", (List<T>)dataList);
		}
		return result;
	}

	@CacheEvict(allEntries=true)
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	@Override
	public void uploadStaffDetailsByExcel(InputStream is) {
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(is);
			Sheet sheet = wb.getSheet(0);
			int rowNum = sheet.getRows();
			boolean newflag = false;
			for (int i = 1; i <= rowNum - 1; i++) {
				String staffIdStr = sheet.getCell(0, i).getContents();
				if (staffIdStr == null || staffIdStr.trim().equals("")) {
					newflag = true;
				}
				int staffId = (newflag) ? 0 : Integer.valueOf(staffIdStr.trim());
				String firstName = sheet.getCell(2, i).getContents().trim();
				if (firstName.equals("") && newflag) {
					newflag = false;
					continue;
				}
				String lastName = sheet.getCell(3, i).getContents().trim();
				String gender = sheet.getCell(4, i).getContents().trim();
				String position = sheet.getCell(5, i).getContents().trim();
				String email = sheet.getCell(6, i).getContents().trim();
				String office = sheet.getCell(7, i).getContents().trim();
				String extn = sheet.getCell(8, i).getContents().trim();
				String ageStr = sheet.getCell(9, i).getContents().trim();
				int age = (ageStr.equals("")) ? 0 : Integer.valueOf(ageStr);
				String salaryStr = sheet.getCell(10, i).getContents().trim();
				double salary = (salaryStr.equals("")) ? (long)0 : Double.valueOf(salaryStr);
				String startDateStr = sheet.getCell(11, i).getContents().trim();
				Date startDate = (startDateStr.equals("")) ? null : SimpleFormater.simpleFormate(startDateStr);
				String imageFlag = sheet.getCell(1, i).getContents().trim();
				String imageB64 = null;
				if (imageFlag.equals("Y")) {
					Image img = sheet.getDrawing(i - 1);
					byte[] encodedBytes = Base64.encodeBase64(img.getImageData());
					imageB64 = new String(encodedBytes);
				}
				StaffDetail staffDetail = new StaffDetail(staffId, firstName, lastName, imageB64, gender, position, email, office, extn, age, salary, startDate, (long)0);
				if (newflag) {
					staffDetailDao.saveAndFlush(staffDetail);
				} else {
					StaffDetail sd = staffDetailDao.findOne(staffId);
					sd.toSyn(staffDetail);
					staffDetailDao.saveAndFlush(sd);
				}
				newflag = false;
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (wb != null) {
				wb.close();
			}
		}
	}

	@Transactional(readOnly=true)
	@Override
	public void downloadStaffDetailsAsExcel(OutputStream os) {
		WritableWorkbook wwb = null;
		try {
			// get the output stream from HttpResponse
			wwb = Workbook.createWorkbook(os);
			// create an Excel sheet
			WritableSheet excelSheet = wwb.createSheet("Sheet1", 0);
			// set column width
			excelSheet.setColumnView(0, 8);
			excelSheet.setColumnView(1, 6);
			excelSheet.setColumnView(2, 14);
			excelSheet.setColumnView(3, 14);
			excelSheet.setColumnView(4, 10);
			excelSheet.setColumnView(5, 24);
			excelSheet.setColumnView(6, 24);
			excelSheet.setColumnView(7, 14);
			excelSheet.setColumnView(8, 8);
			excelSheet.setColumnView(9, 6);
			excelSheet.setColumnView(10, 12);
			excelSheet.setColumnView(11, 14);
			excelSheet.setColumnView(12, 14);
			// define the cell format for table head
			WritableCellFormat wcfHead = new WritableCellFormat();
			WritableFont wfHead = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
			wfHead.setColour(Colour.RED);
			wcfHead.setFont(wfHead);
			wcfHead.setBackground(Colour.YELLOW);
			wcfHead.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcfHead.setAlignment(Alignment.CENTRE);
			wcfHead.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcfHead.setWrap(true);
			// add cell format for table head
			excelSheet.addCell(new Label(0, 0, "Staff Id", wcfHead));
			excelSheet.addCell(new Label(1, 0, "IMG", wcfHead));
			excelSheet.addCell(new Label(2, 0, "First Name", wcfHead));
			excelSheet.addCell(new Label(3, 0, "Last Name", wcfHead));
			excelSheet.addCell(new Label(4, 0, "Gender", wcfHead));
			excelSheet.addCell(new Label(5, 0, "Position", wcfHead));
			excelSheet.addCell(new Label(6, 0, "Email", wcfHead));
			excelSheet.addCell(new Label(7, 0, "Office", wcfHead));
			excelSheet.addCell(new Label(8, 0, "Extn.", wcfHead));
			excelSheet.addCell(new Label(9, 0, "Age", wcfHead));
			excelSheet.addCell(new Label(10, 0, "Salary", wcfHead));
			excelSheet.addCell(new Label(11, 0, "Start Date", wcfHead));
			// define the cell format for table body
			WritableCellFormat wcfBody = new WritableCellFormat();
			wcfBody.setFont(new WritableFont(WritableFont.ARIAL, 8, WritableFont.NO_BOLD));
			wcfBody.setAlignment(Alignment.LEFT);
			wcfBody.setVerticalAlignment(VerticalAlignment.TOP);
			wcfBody.setWrap(true);
			// output the records into Excel file as the format
			List<StaffDetail> staffList = staffDetailDao.findAll();
			for (int i = 0; i < staffList.size(); i++) {
				excelSheet.setRowView(i + 1, 600);
				excelSheet.addCell(new Label(0, i + 1, staffList.get(i).getStaffId() + "", wcfBody));
				excelSheet.addCell(new Label(1, i + 1, "Y", wcfBody));
				byte[] imageBytes = Base64.decodeBase64(staffList.get(i).getImage());
				excelSheet.addImage(new WritableImage(1, i + 1, 1, 1, imageBytes));
				excelSheet.addCell(new Label(2, i + 1, staffList.get(i).getFirstName(), wcfBody));
				excelSheet.addCell(new Label(3, i + 1, staffList.get(i).getLastName(), wcfBody));
				excelSheet.addCell(new Label(4, i + 1, staffList.get(i).getGender(), wcfBody));
				excelSheet.addCell(new Label(5, i + 1, staffList.get(i).getPosition(), wcfBody));
				excelSheet.addCell(new Label(6, i + 1, staffList.get(i).getEmail(), wcfBody));
				excelSheet.addCell(new Label(7, i + 1, staffList.get(i).getOffice(), wcfBody));
				excelSheet.addCell(new Label(8, i + 1, staffList.get(i).getExtn(), wcfBody));
				excelSheet.addCell(new Label(9, i + 1, staffList.get(i).getAge() + "", wcfBody));
				excelSheet.addCell(new Number(10, i + 1, staffList.get(i).getSalary(), wcfBody));
				excelSheet.addCell(new Label(11, i + 1, staffList.get(i).getStartDateStr(), wcfBody));
			}
			// append the formula in excel
			excelSheet.addCell(new Label(12, 0, "Total:", wcfHead));
			excelSheet.addCell(new Formula(12, 1, "SUM(K2:K6)*10", wcfBody));
			wwb.write();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		} finally {
			if (wwb != null) {
				try {
					wwb.close();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}
		}
	}
}