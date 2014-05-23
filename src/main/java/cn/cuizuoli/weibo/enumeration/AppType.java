/*
 * @(#)AppType.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.enumeration;

/**
 * weibo
 * cn.cuizuoli.weibo.enumeration.AppType.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
public enum AppType {
	APP("app", "站内应用"),
	WEB("web", "网页应用"),
	ENTERPRISE("enterprise", "PAGE应用企业版");
	private final String code;
	private final String name;

	private AppType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
