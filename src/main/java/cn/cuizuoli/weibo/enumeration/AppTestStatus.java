/*
 * @(#)AppTestStatus.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.enumeration;

import org.apache.commons.lang.StringUtils;

/**
 * weibo
 * cn.cuizuoli.weibo.enumeration.AppTestStatus.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
public enum AppTestStatus {
	ADD("add", "待添加"),
	DEL("del", "待删除"),
	ADDED("added", "已添加");
	private final String code;
	private final String name;

	private AppTestStatus(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	/**
	 * getObject
	 * @param code
	 * @return
	 */
	public static AppTestStatus getObject(String code) {
		for (AppTestStatus status : AppTestStatus.values()) {
			if (StringUtils.equals(status.getCode(), code)) {
				return status;
			}
		}
		return null;
	}
}
