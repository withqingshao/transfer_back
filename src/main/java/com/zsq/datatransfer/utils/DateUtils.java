package com.zsq.datatransfer.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 日期处理类
 */
public class DateUtils {

	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {

		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd");
		}

	};

	public static final Date convert(String source) throws ParseException {
		// return df.get().format(new Date())
		return df.get().parse(source);
	}

	public static final String dateToString(Date date){
		// return df.get().format(new Date())
		return df.get().format(date);
	}
	

}
