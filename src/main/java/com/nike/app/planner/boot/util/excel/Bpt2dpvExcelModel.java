
package com.nike.app.planner.boot.util.excel;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

import com.nike.app.planner.boot.common.constant.Bpt2dpvExcel;
import com.nike.app.planner.boot.data.entity.BuyPlanTop2DownPlatformView;
import com.nike.app.planner.boot.util.convert.SimpleFormater;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

public class Bpt2dpvExcelModel extends ExcelModel {

	private final static Colour FONT_COLOR_NIKE_COM = Colour.RED;
	private final static Colour FONT_COLOR_T_MALL   = Colour.BLUE_GREY;
	private final static Colour FONT_COLOR_HK_COM   = Colour.SEA_GREEN;
	private final static Colour FONT_COLOR_GC_TOTAL = Colour.DARK_RED2;

	private final static Hashtable<String, Colour> PLATFORM_COLOR_HASH = new Hashtable<String, Colour>();

	static {
		PLATFORM_COLOR_HASH.put("NIKE.COM", FONT_COLOR_NIKE_COM);
		PLATFORM_COLOR_HASH.put("T-MALL", FONT_COLOR_T_MALL);
		PLATFORM_COLOR_HASH.put("HK.COM", FONT_COLOR_HK_COM);
		PLATFORM_COLOR_HASH.put("GC TOTAL", FONT_COLOR_GC_TOTAL);
	}

	public Bpt2dpvExcelModel() {
		super();
	}

	public Bpt2dpvExcelModel(OutputStream os) {
		super(os);
	}

	public WritableCellFormat getWcfForTgfh(Colour bgc) {
		WritableCellFormat wcfTgfh = new WritableCellFormat();
		WritableFont wfTgfh = new WritableFont(WritableFont.createFont(Bpt2dpvExcel.TABLE_CONTENT_FONT_FAMILY_NAME), 12, WritableFont.BOLD);
		wcfTgfh.setFont(wfTgfh);
		try {
			wcfTgfh.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
			wcfTgfh.setAlignment(Alignment.CENTRE);
			wcfTgfh.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcfTgfh.setWrap(true);
			if (bgc != null) {
				wcfTgfh.setBackground(bgc);
			}
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return wcfTgfh;
	}

	@Override
	public WritableCellFormat getWcfForTfh(Colour bgc) {
		WritableCellFormat wcfFieldHead = new WritableCellFormat();
		WritableFont wfFieldHead = new WritableFont(WritableFont.createFont(Bpt2dpvExcel.TABLE_CONTENT_FONT_FAMILY_NAME), 11, WritableFont.BOLD);
		wcfFieldHead.setFont(wfFieldHead);
		try {
			wcfFieldHead.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
			wcfFieldHead.setAlignment(Alignment.CENTRE);
			wcfFieldHead.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcfFieldHead.setWrap(true);
			if (bgc != null) {
				wcfFieldHead.setBackground(bgc);
			}
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return wcfFieldHead;
	}

	@Override
	public WritableCellFormat getWcfForTbr(Colour color) {
		WritableCellFormat wcfTbr = new WritableCellFormat();
		try {
			WritableFont wfTbr = new WritableFont(WritableFont.createFont(Bpt2dpvExcel.TABLE_CONTENT_FONT_FAMILY_NAME), 8, WritableFont.NO_BOLD);
			if (color != null) {
				wfTbr.setColour(color);
				wfTbr.setBoldStyle(WritableFont.BOLD);
			}
			wcfTbr.setFont(wfTbr);
			wcfTbr.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcfTbr.setAlignment(Alignment.LEFT);
			wcfTbr.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcfTbr.setWrap(true);
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return wcfTbr;
	}

	public void buildForTableGeneralFieldHead(WritableSheet ws) {
		try {
			// merge for table general field head
			ws.mergeCells(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR, Bpt2dpvExcel.TABLE_CONTENT_START_ROW_IDX, Bpt2dpvExcel.IDX_COL_TY_BUY_UNIT, Bpt2dpvExcel.TABLE_CONTENT_START_ROW_IDX);
			ws.mergeCells(Bpt2dpvExcel.IDX_COL_LY_REV_DOLAR, Bpt2dpvExcel.TABLE_CONTENT_START_ROW_IDX, Bpt2dpvExcel.IDX_COL_LY_ST_PERCENT, Bpt2dpvExcel.TABLE_CONTENT_START_ROW_IDX);
			ws.mergeCells(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR_PERCENT, Bpt2dpvExcel.TABLE_CONTENT_START_ROW_IDX, Bpt2dpvExcel.IDX_COL_VAR_REV_DOLAR_PERCENT, Bpt2dpvExcel.TABLE_CONTENT_START_ROW_IDX);
			// define the cell format for table general field head
			ws.addCell(new Label(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR, Bpt2dpvExcel.TABLE_CONTENT_START_ROW_IDX, "THIS YEAR", getWcfForTgfh(Colour.ICE_BLUE)));
			ws.addCell(new Label(Bpt2dpvExcel.IDX_COL_LY_REV_DOLAR, Bpt2dpvExcel.TABLE_CONTENT_START_ROW_IDX, "LAST YEAR",  getWcfForTgfh(Colour.GRAY_25)));
			ws.addCell(new Label(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR_PERCENT, Bpt2dpvExcel.TABLE_CONTENT_START_ROW_IDX, "REV.$", getWcfForTgfh(Colour.GOLD)));
		} catch (RowsExceededException ree) {
			ree.printStackTrace();
		} catch (WriteException we) {
			we.printStackTrace();
		}
	}

	public void buildForTableFieldHead(WritableSheet ws) {
		try {
			for (int i = 0; i < Bpt2dpvExcel.ARR_COLS_NAME.length; i++) {
				ws.addCell(new Label(i, Bpt2dpvExcel.TABLE_FIELD_HEAD_START_ROW_IDX, Bpt2dpvExcel.ARR_COLS_NAME[i], getWcfForTfh(null)));
			}
		} catch (RowsExceededException ree) {
			ree.printStackTrace();
		} catch (WriteException we) {
			we.printStackTrace();
		}
	}

	private void fillTableBodyRowSet(WritableSheet ws, int index, int lineNo, int lineNum, BuyPlanTop2DownPlatformView bpt2dpv, int divisions_len, Hashtable<String, List<Integer>> tyRevLineNumsHash, String mode) {
		try {
			ws.addCell(new Label(Bpt2dpvExcel.IDX_COL_PLATFORM, index, bpt2dpv.getPlatform(), getWcfForTbr(PLATFORM_COLOR_HASH.get(bpt2dpv.getPlatform()))));
			ws.addCell(new Label(Bpt2dpvExcel.IDX_COL_DIVISION, index, bpt2dpv.getDivision(), getWcfForTbr(null)));
			if (mode.equals("basic")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR, index, "I" + lineNo + "*(100+D" + lineNo + ")/100", getWcfForTbr(null)));
			} else if (mode.equals("basic-tapp")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR, index, "SUM(C" + (lineNo - divisions_len) + ":C" + (lineNo - 1) + ")", getWcfForTbr(null)));
			} else if (mode.equals("gctotal")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR, index, "SUM(" + SimpleFormater.convertForExcel("C", tyRevLineNumsHash.get(bpt2dpv.getDivision())) + ")", getWcfForTbr(null)));
			} else if (mode.equals("gctotal-tapp")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR, index, "SUM(C" + (lineNo - divisions_len) + ":C" + (lineNo - 1) + ")", getWcfForTbr(null)));
			}
			if (mode.equals("basic")) {
				if (!tyRevLineNumsHash.containsKey(bpt2dpv.getDivision())) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(lineNo);
					tyRevLineNumsHash.put(bpt2dpv.getDivision(), list);
				} else {
					tyRevLineNumsHash.get(bpt2dpv.getDivision()).add(lineNo);
				}
			}
			if (mode.equals("basic")) {
				ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_TY_DELTA_PERCENT, index, bpt2dpv.getTyDeltaPercent(), getWcfForTbr(Colour.ROSE)));
			} else if (mode.equals("basic-tapp") || mode.equals("gctotal") || mode.equals("gctotal-tapp")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_DELTA_PERCENT, index, "(C" + lineNo + "/I" + lineNo + "-1)*100", getWcfForTbr(null)));
			}
			if (mode.equals("basic") || mode.equals("gctotal")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_SALE_UNIT, index, "C" + lineNo + "/F" + lineNo, getWcfForTbr(null)));
			} else if (mode.equals("basic-tapp") || mode.equals("gctotal-tapp")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_SALE_UNIT, index, "SUM(E" + (lineNo - divisions_len) + ":E" + (lineNo - 1) + ")", getWcfForTbr(null)));
			}
			if (mode.equals("basic") || mode.equals("gctotal")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_AUR_DOLAR, index, "K" + lineNo, getWcfForTbr(null)));
			} else if (mode.equals("basic-tapp") || mode.equals("gctotal-tapp")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_AUR_DOLAR, index, "C" + lineNo + "/E" + lineNo, getWcfForTbr(null)));
			}
			if (mode.equals("basic")) {
				ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_TY_ST_PERCENT, index, bpt2dpv.getTyStPercent(), getWcfForTbr(Colour.ROSE)));
			} else if (mode.equals("basic-tapp") || mode.equals("gctotal-tapp")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_ST_PERCENT, index, "E" + lineNo + "/H" + lineNo + "*100", getWcfForTbr(null)));
			} else if (mode.equals("gctotal")) {
				ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_TY_ST_PERCENT, index, 60, getWcfForTbr(null)));
			}
			if (mode.equals("basic") || mode.equals("gctotal")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_BUY_UNIT, index, "E" + lineNo + "/G" + lineNo + "*100", getWcfForTbr(null)));
			} else if (mode.equals("basic-tapp") || mode.equals("gctotal-tapp")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_BUY_UNIT, index, "SUM(H" + (lineNo - divisions_len) + ":H" + (lineNo - 1) + ")", getWcfForTbr(null)));
			}
			ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_LY_REV_DOLAR, index, bpt2dpv.getLyRevDolar(), getWcfForTbr(null)));
			ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_LY_SALE_UNIT, index, bpt2dpv.getLySaleUnit(), getWcfForTbr(null)));
			ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_LY_AUR_DOLAR, index, bpt2dpv.getLyAurDolar(), getWcfForTbr(null)));
			ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_LY_MD_PERCENT, index, bpt2dpv.getLyMdPercent(), getWcfForTbr(null)));
			ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_LY_IN_SEA_PERCENT, index, bpt2dpv.getLyInSeasonPercent(), getWcfForTbr(null)));
			ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_LY_BUY_UNIT, index, bpt2dpv.getLyBuyUnit(), getWcfForTbr(null)));
			ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_LY_ST_PERCENT, index, bpt2dpv.getLyStPercent(), getWcfForTbr(null)));
			if (mode.equals("basic") || mode.equals("gctotal")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR_PERCENT, index, "(C" + lineNo + "/C" + (lineNum + divisions_len) + ")*100", getWcfForTbr(null)));
			} else if (mode.equals("basic-tapp") || mode.equals("gctotal-tapp")) {
				ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_TY_REV_DOLAR_PERCENT, index, 100, getWcfForTbr(null)));
			}
			if (mode.equals("basic") || mode.equals("gctotal")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_LY_REV_DOLAR_PERCENT, index, "(I" + lineNo + "/I" + (lineNum + divisions_len) + ")*100", getWcfForTbr(null)));
			} else if (mode.equals("basic-tapp") || mode.equals("gctotal-tapp")) {
				ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_LY_REV_DOLAR_PERCENT, index, 100, getWcfForTbr(null)));
			}
			if (mode.equals("basic") || mode.equals("gctotal")) {
				ws.addCell(new Formula(Bpt2dpvExcel.IDX_COL_VAR_REV_DOLAR_PERCENT, index, "(P" + lineNo + "-Q" + lineNo + ")*10000", getWcfForTbr(null)));
			} else if (mode.equals("basic-tapp") || mode.equals("gctotal-tapp")) {
				ws.addCell(new Number(Bpt2dpvExcel.IDX_COL_VAR_REV_DOLAR_PERCENT, index, 0, getWcfForTbr(null)));
			}
		} catch (RowsExceededException ree) {
			ree.printStackTrace();
		} catch (WriteException we) {
			we.printStackTrace();
		}
	}

	public void buildForTableBodyRows(WritableSheet ws, List<BuyPlanTop2DownPlatformView> bpt2dpvList, String[] platforms, String[] divisions) {
		try {
			int index = Bpt2dpvExcel.TABLE_BODY_ROW_START_ROW_IDX;
			int lineNum = Bpt2dpvExcel.TABLE_BODY_ROW_START_ROW_IDX + 1;
			Hashtable<String, List<Integer>> tyRevLineNumsHash = new Hashtable<String, List<Integer>>();
			for (String platform : platforms) {
				List<BuyPlanTop2DownPlatformView> bpt2dpvSubList = bpt2dpvList.stream().filter((bpt2dpv) -> bpt2dpv.getPlatform().equals(platform) && !bpt2dpv.getDivision().equals("TOTAL APP")).collect(Collectors.toList());
				ws.mergeCells(Bpt2dpvExcel.IDX_COL_PLATFORM, index, Bpt2dpvExcel.IDX_COL_PLATFORM, index + divisions.length);
				for (int i = 0; i < bpt2dpvSubList.size(); i++) {
					final int lineNo = index + 1;
					fillTableBodyRowSet(ws, index, lineNo, lineNum, bpt2dpvSubList.get(i), divisions.length, tyRevLineNumsHash, "basic");
					index++;
				}
				BuyPlanTop2DownPlatformView bpt2dpvTotalApp = bpt2dpvList.stream().filter((bpt2dpv) -> bpt2dpv.getPlatform().equals(platform) && bpt2dpv.getDivision().equals("TOTAL APP")).findFirst().get();
				final int lineNo = index + 1;
				fillTableBodyRowSet(ws, index, lineNo, lineNum, bpt2dpvTotalApp, divisions.length, tyRevLineNumsHash, "basic-tapp");
				index++;
				lineNum += divisions.length + 1;
			}
			List<BuyPlanTop2DownPlatformView> bpt2dpvGcTotalList = bpt2dpvList.stream().filter((bpt2dpv) -> bpt2dpv.getPlatform().equals("GC TOTAL") && !bpt2dpv.getDivision().equals("TOTAL APP")).collect(Collectors.toList());
			ws.mergeCells(Bpt2dpvExcel.IDX_COL_PLATFORM, index, Bpt2dpvExcel.IDX_COL_PLATFORM, index + divisions.length);
			for (int i = 0; i < bpt2dpvGcTotalList.size(); i++) {
				final int lineNo = index + 1;
				fillTableBodyRowSet(ws, index, lineNo, lineNum, bpt2dpvGcTotalList.get(i), divisions.length, tyRevLineNumsHash, "gctotal");
				index++;
			}
			BuyPlanTop2DownPlatformView bpt2dpvGcTotalTotalApp = bpt2dpvList.stream().filter((bpt2dpv) -> bpt2dpv.getPlatform().equals("GC TOTAL") && bpt2dpv.getDivision().equals("TOTAL APP")).findFirst().get();
			final int lineNo = index + 1;
			fillTableBodyRowSet(ws, index, lineNo, lineNum, bpt2dpvGcTotalTotalApp, divisions.length, tyRevLineNumsHash, "gctotal-tapp");
		} catch (RowsExceededException ree) {
			ree.printStackTrace();
		} catch (WriteException we) {
			we.printStackTrace();
		}
	}
}