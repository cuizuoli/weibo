/*
 * @(#)Gender.java $version 2014年6月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.enumeration;

import org.apache.commons.lang.StringUtils;

/**
 * weibo
 * cn.cuizuoli.weibo.enumeration.Gender.java
 * cuizuoli
 * @date 2014年6月23日
 */
public enum Gender {
	MALE("m", "男"),
	FEMALE("f", "女");
	private final String code;
	private final String name;

	private Gender(String code, String name) {
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
	public static Gender getObject(String code) {
		for (Gender gender : Gender.values()) {
			if (StringUtils.equals(code, gender.getCode())) {
				return gender;
			}
		}
		return null;
	}
}
