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

	/**
	 * toDatetime
	 * @param date
	 * @return
	 */
	public static String toDatetime(Date date) {
		return new DateTime(date.getTime()).toString(DATETIME_FORMATTER);
	}

}
