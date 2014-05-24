/*
 * @(#)AppStatus.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.enumeration;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import cn.cuizuoli.weibo.map.ser.AppStatusJsonSerializer;

/**
 * weibo
 * cn.cuizuoli.weibo.enumeration.AppStatus.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
@JsonSerialize(using = AppStatusJsonSerializer.class)
public enum AppStatus {
	REQUEST("request", "申请"),
	REQUESTED("requested", "已申请"),
	COMPLETED("completed", "开发完成"),
	VERIFY("verify", "审核"),
	SQUARE("square", "广场"),
	RELEASE("release", "上线");
	private final String code;
	private final String name;

	private AppStatus(String code, String name) {
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
	public static AppStatus getObject(String code) {
		for (AppStatus status : AppStatus.values()) {
			if (StringUtils.equals(status.getCode(), code)) {
				return status;
			}
		}
		return null;
	}
}
