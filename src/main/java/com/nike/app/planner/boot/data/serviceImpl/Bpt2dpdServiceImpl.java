
package com.nike.app.planner.boot.data.serviceImpl;

import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nike.app.planner.boot.common.constant.Bpt2dpvExcel;
import com.nike.app.planner.boot.common.constant.WebAppConstant;
import com.nike.app.planner.boot.common.model.JsonCjsLabelYModel;
import com.nike.app.planner.boot.data.dao.Bpt2dpdDao;
import com.nike.app.planner.boot.data.dao.Bpt2dpvDao;
import com.nike.app.planner.boot.data.entity.BuyPlanTop2DownPlatformDetail;
import com.nike.app.planner.boot.data.entity.BuyPlanTop2DownPlatformView;
import com.nike.app.planner.boot.data.service.Bpt2dpdService;
import com.nike.app.planner.boot.util.convert.UrlEncodedFormFactory;
import com.nike.app.planner.boot.util.excel.Bpt2dpvExcelModel;
import com.nike.app.planner.boot.util.log.SimpleLogger;
import com.nike.app.planner.boot.web.mvc.bean.form.Bpt2dAutofillForm;
import com.nike.app.planner.boot.web.mvc.bean.form.Bpt2dpvEditForm;

import jxl.write.WritableSheet;

import com.nike.app.planner.boot.common.model.JsonBpt2dpvDivisionGcTotal;
import com.nike.app.planner.boot.common.model.JsonBpt2dpvDivisionTyLyRev;

@Service("bpt2dpdService")
public class Bpt2dpdServiceImpl implements Bpt2dpdService {

	@Autowired
	private Bpt2dpvDao bpt2dpvDao = null;

	@Autowired
	private Bpt2dpdDao bpt2dpdDao = null;

	@Transactional(readOnly=true)
	@Override
	public List<BuyPlanTop2DownPlatformView> getAllBuyPlanTop2DownPlatformViews() {
		return bpt2dpvDao.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public double getBpt2dpvPlannedCost() {
		BuyPlanTop2DownPlatformView bpt2dpv = bpt2dpvDao.findBuyPlanTop2DownPlatformViewByPlatformAndDivision("GC TOTAL", "TOTAL APP");
		return bpt2dpv.getTyRevDolar();
	}
	
	@Transactional(readOnly=true)
	@Override
	public Map<String, List<JsonCjsLabelYModel>> getCjsDivisionTyLyRevsByPlatform(String platform) {
		Map<String, List<JsonCjsLabelYModel>> result = new HashMap<String, List<JsonCjsLabelYModel>>();
		List<BuyPlanTop2DownPlatformView> list = bpt2dpvDao.findBuyPlanTop2DownPlatformViewByPlatform(platform);
		List<JsonCjsLabelYModel> tyList = list.stream()
			.filter((bpt2dpv) -> !bpt2dpv.getDivision().equals("TOTAL APP"))
			.map((bpt2dpv) -> new JsonCjsLabelYModel(bpt2dpv.getDivision(), bpt2dpv.getTyRevDolar()))
			.collect(Collectors.toList());
		List<JsonCjsLabelYModel> lyList = list.stream()
			.filter((bpt2dpv) -> !bpt2dpv.getDivision().equals("TOTAL APP"))
			.map((bpt2dpv) -> new JsonCjsLabelYModel(bpt2dpv.getDivision(), bpt2dpv.getLyRevDolar()))
			.collect(Collectors.toList());
		result.put("tyList", tyList);
		result.put("lyList", lyList);
		return result;
	}

	@Transactional(readOnly=true)
	@Override
	public List<JsonCjsLabelYModel> getCjsDivisionGcTotal() {
		List<JsonCjsLabelYModel> result = bpt2dpvDao.findBuyPlanTop2DownPlatformViewByPlatform("GC TOTAL").stream()
			.filter((bpt2dpv) -> !bpt2dpv.getDivision().equals("TOTAL APP"))
			.map((bpt2dpv) -> new JsonCjsLabelYModel(bpt2dpv.getDivision(), bpt2dpv.getTyRevDolar()))
			.collect(Collectors.toList());
		return result;
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	@Override
	public void processActionOfBpt2dpv(String requestBody) {
		Bpt2dpvEditForm bpt2dpvef = null;
		try {
			bpt2dpvef = (Bpt2dpvEditForm)UrlEncodedFormFactory.getInstance().generate(WebAppConstant.URL_ENCODED_BPT2DPV_EDIT_FORM, requestBody);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		if (bpt2dpvef.getActionName().equals("edit")) {
			BuyPlanTop2DownPlatformView bpt2dpv = bpt2dpvDao.findOne(bpt2dpvef.getId());
			BuyPlanTop2DownPlatformDetail bpt2dpd = bpt2dpdDao.findBuyPlanTop2DownPlatformDetailByPlatformAndDivisionAndYearNum(bpt2dpv.getPlatform(), bpt2dpv.getDivision(), Calendar.getInstance().get(Calendar.YEAR));
			if (bpt2dpd == null) {
				bpt2dpd = new BuyPlanTop2DownPlatformDetail();
				bpt2dpd.setPlatform(bpt2dpv.getPlatform());
				bpt2dpd.setDivision(bpt2dpv.getDivision());
				bpt2dpd.setDeltaPercent((bpt2dpvef.getTyDeltaPercent() != null && !bpt2dpvef.getTyDeltaPercent().equals("")) ? Double.valueOf(bpt2dpvef.getTyDeltaPercent()) : (double)60.0);
				bpt2dpd.setStPercent((bpt2dpvef.getTyStPercent() != null && !bpt2dpvef.getTyStPercent().equals("")) ? Double.valueOf(bpt2dpvef.getTyStPercent()) : (double)60.0);
				bpt2dpd.setRevDolar((double)(bpt2dpv.getLyRevDolar()*((double)(1 + (double)(bpt2dpd.getDeltaPercent()/100)))));
				bpt2dpd.setAurDolar(bpt2dpv.getLyAurDolar());
				bpt2dpd.setSaleUnit((int)(bpt2dpd.getRevDolar()/bpt2dpd.getAurDolar()));
				bpt2dpd.setBuyUnit((int)((double)bpt2dpd.getSaleUnit()/(double)((double)bpt2dpd.getStPercent()/(double)100.0)));
				bpt2dpd.setYearNum(Calendar.getInstance().get(Calendar.YEAR));
				bpt2dpdDao.saveAndFlush(bpt2dpd);
			} else {
				bpt2dpd.setDeltaPercent((bpt2dpvef.getTyDeltaPercent() != null && !bpt2dpvef.getTyDeltaPercent().equals("")) ? Double.valueOf(bpt2dpvef.getTyDeltaPercent()) : bpt2dpv.getTyDeltaPercent());
				bpt2dpd.setStPercent((bpt2dpvef.getTyStPercent() != null && !bpt2dpvef.getTyStPercent().equals("")) ? Double.valueOf(bpt2dpvef.getTyStPercent()) : bpt2dpv.getTyStPercent());
				bpt2dpd.setRevDolar((double)(bpt2dpv.getLyRevDolar()*((double)(1 + (double)(bpt2dpd.getDeltaPercent()/100)))));
				bpt2dpd.setAurDolar(bpt2dpv.getLyAurDolar());
				bpt2dpd.setSaleUnit((int)(bpt2dpd.getRevDolar()/bpt2dpd.getAurDolar()));
				bpt2dpd.setBuyUnit((int)((double)bpt2dpd.getSaleUnit()/(double)((double)bpt2dpd.getStPercent()/(double)100.0)));
				bpt2dpdDao.saveAndFlush(bpt2dpd);
			}
		}
	}

	@Transactional(readOnly=true)
	@Override
	public List<BuyPlanTop2DownPlatformView> getBpt2dpvByCriteria(String platform, String division) {
		List<BuyPlanTop2DownPlatformView> resList = null;
		if (!platform.equals("-") && division.equals("-")) {
			resList = bpt2dpvDao.findBuyPlanTop2DownPlatformViewByPlatform(platform);
		} else if (platform.equals("-") && !division.equals("-")) {
			resList = bpt2dpvDao.findBuyPlanTop2DownPlatformViewByDivision(division);
		} else {
			resList = bpt2dpvDao.findBuyPlanTop2DownPlatformViewListByPlatformAndDivision(platform, division);
		}
		return resList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<JsonBpt2dpvDivisionTyLyRev> getDivisionTyLyRevsByPlatform(String platform) {
		List<JsonBpt2dpvDivisionTyLyRev> result = bpt2dpvDao.findBuyPlanTop2DownPlatformViewByPlatform(platform)
			.stream()
			.map((bpt2dpv) -> new JsonBpt2dpvDivisionTyLyRev(bpt2dpv.getDivision(), bpt2dpv.getTyRevDolar(), bpt2dpv.getLyRevDolar()))
			.collect(Collectors.toList());
		return result;
	}

	@Transactional(readOnly=true)
	@Override
	public List<JsonBpt2dpvDivisionGcTotal> getDivisionGcTotal() {
		List<JsonBpt2dpvDivisionGcTotal> result = bpt2dpvDao.findBuyPlanTop2DownPlatformViewByPlatform("GC TOTAL")
			.stream()
			.filter((bpt2dpv) -> !bpt2dpv.getDivision().equals("TOTAL APP"))
			.map((bpt2dpv) -> new JsonBpt2dpvDivisionGcTotal(bpt2dpv.getDivision(), bpt2dpv.getTyRevDolar()))
			.collect(Collectors.toList());
		return result;
	}

	@Transactional(readOnly=true)
	@Override
	public void downloadBpt2dpvAsExcel(OutputStream os) {
		Bpt2dpvExcelModel bpt2dpvExcelModel = new Bpt2dpvExcelModel(os);
		// create an Excel sheet
		WritableSheet excelSheet = bpt2dpvExcelModel.createExcelWritableSheet(Bpt2dpvExcel.NAME_OF_BPT2D_STEP_01_XLS_SHEET, Bpt2dpvExcel.IDX_XLS_SHEET_OF_BPT2D_STEP_01);
		// set column width
		bpt2dpvExcelModel.setColumnsWidth(excelSheet, Bpt2dpvExcel.ARR_COLS_WIDTH);
		// build the general field titles
		bpt2dpvExcelModel.buildForTableGeneralFieldHead(excelSheet);
		// define the cell format for table field head
		bpt2dpvExcelModel.buildForTableFieldHead(excelSheet);
		// fetch the bpt2dpv data which be used for rendering
		List<BuyPlanTop2DownPlatformView> bpt2dpvList = bpt2dpvDao.findAll();
		// write all the records into excel
		bpt2dpvExcelModel.buildForTableBodyRows(excelSheet, bpt2dpvList, Bpt2dpvExcel.ARR_PLATFORM_NAME, Bpt2dpvExcel.ARR_DIVISION_NAME);
		bpt2dpvExcelModel.writeAndClose();
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	@Override
	public void commitAllBpt2dpvs() {
		bpt2dpvDao.findAll()
			.stream()
			.filter((bpt2dpv) -> !bpt2dpv.getPlatform().equals("GC TOTAL") && !bpt2dpv.getDivision().equals("TOTAL APP"))
			.forEach((bpt2dpv) -> {
				BuyPlanTop2DownPlatformDetail bpt2dpd = bpt2dpdDao.findBuyPlanTop2DownPlatformDetailByPlatformAndDivisionAndYearNum(bpt2dpv.getPlatform(), bpt2dpv.getDivision(), Calendar.getInstance().get(Calendar.YEAR));
				if (bpt2dpd == null) {
					bpt2dpd = new BuyPlanTop2DownPlatformDetail();
					bpt2dpd.setPlatform(bpt2dpv.getPlatform());
					bpt2dpd.setDivision(bpt2dpv.getDivision());
					bpt2dpd.setDeltaPercent(bpt2dpv.getTyDeltaPercent());
					bpt2dpd.setStPercent(bpt2dpv.getTyStPercent());
					bpt2dpd.setRevDolar(bpt2dpv.getTyRevDolar());
					bpt2dpd.setAurDolar(bpt2dpv.getTyAurDolar());
					bpt2dpd.setSaleUnit(bpt2dpv.getTySaleUnit());
					bpt2dpd.setBuyUnit(bpt2dpv.getTyBuyUnit());
					bpt2dpd.setYearNum(Calendar.getInstance().get(Calendar.YEAR));
					bpt2dpdDao.saveAndFlush(bpt2dpd);
				}
			});
		SimpleLogger.log(SimpleLogger.DEBUG, getClass(), "The records of TY Bpt2dpd is : " + bpt2dpdDao.findAll().stream().filter((bpt2dpd) -> bpt2dpd.getYearNum() == Calendar.getInstance().get(Calendar.YEAR)).collect(Collectors.toList()).size());
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	@Override
	public void processBpt2dpvAutoFillForm(Bpt2dAutofillForm bpt2dpvAutofillForm) {
		for (int rowId : bpt2dpvAutofillForm.getRows()) {
			BuyPlanTop2DownPlatformView bpt2dpv = bpt2dpvDao.findOne(rowId);
			BuyPlanTop2DownPlatformDetail bpt2dpd = bpt2dpdDao.findBuyPlanTop2DownPlatformDetailByPlatformAndDivisionAndYearNum(bpt2dpv.getPlatform(), bpt2dpv.getDivision(), Calendar.getInstance().get(Calendar.YEAR));
			if (bpt2dpd == null) {
				bpt2dpd = new BuyPlanTop2DownPlatformDetail();
				bpt2dpd.setPlatform(bpt2dpv.getPlatform());
				bpt2dpd.setDivision(bpt2dpv.getDivision());
				bpt2dpd.setDeltaPercent((bpt2dpvAutofillForm.getField().equals("deltaPercent")) ? bpt2dpvAutofillForm.getValue() : (double)60.0);
				bpt2dpd.setStPercent((bpt2dpvAutofillForm.getField().equals("stPercent")) ? bpt2dpvAutofillForm.getValue() : (double)60.0);
				bpt2dpd.setRevDolar((double)(bpt2dpv.getLyRevDolar()*((double)(1 + (double)(bpt2dpd.getDeltaPercent()/100)))));
				bpt2dpd.setAurDolar(bpt2dpv.getLyAurDolar());
				bpt2dpd.setSaleUnit((int)(bpt2dpd.getRevDolar()/bpt2dpd.getAurDolar()));
				bpt2dpd.setBuyUnit((int)((double)bpt2dpd.getSaleUnit()/(double)((double)bpt2dpd.getStPercent()/(double)100.0)));
				bpt2dpd.setYearNum(Calendar.getInstance().get(Calendar.YEAR));
				bpt2dpdDao.saveAndFlush(bpt2dpd);
			} else {
				bpt2dpd.setDeltaPercent((bpt2dpvAutofillForm.getField().equals("deltaPercent")) ? bpt2dpvAutofillForm.getValue() : bpt2dpv.getTyDeltaPercent());
				bpt2dpd.setStPercent((bpt2dpvAutofillForm.getField().equals("stPercent")) ? bpt2dpvAutofillForm.getValue() : bpt2dpv.getTyStPercent());
				bpt2dpd.setRevDolar((double)(bpt2dpv.getLyRevDolar()*((double)(1 + (double)(bpt2dpd.getDeltaPercent()/100)))));
				bpt2dpd.setAurDolar(bpt2dpv.getLyAurDolar());
				bpt2dpd.setSaleUnit((int)(bpt2dpd.getRevDolar()/bpt2dpd.getAurDolar()));
				bpt2dpd.setBuyUnit((int)((double)bpt2dpd.getSaleUnit()/(double)((double)bpt2dpd.getStPercent()/(double)100.0)));
				bpt2dpdDao.saveAndFlush(bpt2dpd);
			}
		}
	}
}