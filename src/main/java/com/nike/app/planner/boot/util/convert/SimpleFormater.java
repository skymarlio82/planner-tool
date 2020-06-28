
package com.nike.app.planner.boot.util.convert;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SimpleFormater {

	public final String[] ENGLISH_LETTERS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	private final static String SHORT_SIMPLE_DATE_FORMATE = "yyyy-MM-dd";
	private final static SimpleDateFormat sdf             = new SimpleDateFormat(SHORT_SIMPLE_DATE_FORMATE);

	public final static String convertForExcel(String appendix, List<Integer> list) {
		String result = "";
		for (Integer i : list) {
			result += appendix + i + ",";
		}
		return result.substring(0, result.length() - 1);
	}

	public final static String simpleFormate(Date date) {
		return sdf.format(date);
	}

	public final static Date simpleFormate(String date) {
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public final static double d2d2(double dv) {
		BigDecimal bd = new BigDecimal(dv);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}