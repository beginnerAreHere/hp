package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期格式化
 * @Date 2020年5月7日
 * @author hxl
 *
 */
public class DateUtil {
	//yyyy-MM-dd HH:mm:ss
	public final static String STD_YMD = "yyyy-MM-dd HH:mm:ss";
	public final static SimpleDateFormat STD_YMD_DF = new SimpleDateFormat(STD_YMD);
	/**
	 * 把Date转化成yyyy-MM-dd HH:mm:ss
	 * @param date  日期
	 * @return
	 */
	public static String dateToSTD_YMD(Date date) {
		if (date == null) {
			return "";
		}
		return STD_YMD_DF.format(date);
	}
	
	/**
	 * 把yyyy-MM-dd HH:mm:ss转化成 date
	 * @param date  日期
	 * @return
	 * @throws ParseException 
	 */
	public static Date STD_YMDToDate(String date) throws ParseException {
		return STD_YMD_DF.parse(date);
	}

}
