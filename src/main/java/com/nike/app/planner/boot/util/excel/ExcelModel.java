
package com.nike.app.planner.boot.util.excel;

import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public abstract class ExcelModel {

	private WritableWorkbook wwb = null;
	private OutputStream os = null;

	public ExcelModel() {
		
	}

	public ExcelModel(OutputStream os) {
		try {
			wwb = Workbook.createWorkbook(os);
			this.os = os;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WritableSheet createExcelWritableSheet(String name, int index) {
		return wwb.createSheet(name, index);
	}

	public void setColumnsWidth(WritableSheet ws, int[] arr_width) {
		for (int i = 0; i < arr_width.length; i++) {
			ws.setColumnView(i, arr_width[i]);
		}
	}

	public void writeAndClose() {
		if (wwb != null && os != null) {
			try {
				wwb.write();
				wwb.close();
				os.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (WriteException we) {
				we.printStackTrace();
			}
		}
	}

	public abstract WritableCellFormat getWcfForTfh(Colour bgc);

	public abstract WritableCellFormat getWcfForTbr(Colour bgc);
}