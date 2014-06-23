/*
 * @(#)DateUtil.java $version 2014年6月4日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * weibo
 * cn.cuizuoli.weibo.util.DateUtil.java
 * @author cuizuoli
 * @date 2014年6月4日
 */
public class DateUtil {

	public final static DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
	public final static DateTimeFormatter HOUR_FORMATTER = DateTimeFormat.forPattern("yyyyMMddHH");
	public final static DateTimeFormatter DAY_FORMATTER = DateTimeFormat.forPattern("yyyyMMdd");
	public final static DateTimeFormatter MONTH_FORMATTER = DateTimeFormat.forPattern("yyyyMM");

	/**
	 * toDatetime
	 * @param date
	 * @return
	 */
	public static String toDatetime(Date date) {
		return new DateTime(date.getTime()).toString(DATETIME_FORMATTER);
	}

	/**
	 * fromHour
	 * @param hour
	 * @return
	 */
	public static DateTime fromHour(String hour) {
		return HOUR_FORMATTER.parseDateTime(hour);
	}

	/**
	 * fromDay
	 * @param day
	 * @return
	 */
	public static DateTime fromDay(String day) {
		return DAY_FORMATTER.parseDateTime(day);
	}

	/**
	 * fromMonth
	 * @param month
	 * @return
	 */
	public static DateTime fromMonth(String month) {
		return MONTH_FORMATTER.parseDateTime(month);
	}

	/**
	 * toHour
	 * @param datetime
	 * @return
	 */
	public static String toHour(DateTime datetime) {
		return datetime.toString(HOUR_FORMATTER);
	}

	/**
	 * toDay
	 * @param datetime
	 * @return
	 */
	public static String toDay(DateTime datetime) {
		return datetime.toString(DAY_FORMATTER);
	}

	/**
	 * toMonth
	 * @param datetime
	 * @return
	 */
	public static String toMonth(DateTime datetime) {
		return datetime.toString(MONTH_FORMATTER);
	}

}
