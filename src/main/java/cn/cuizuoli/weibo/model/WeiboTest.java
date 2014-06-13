/*
 * @(#)WeiboTest.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang.StringUtils;

import cn.cuizuoli.weibo.enumeration.AppTestStatus;
import cn.cuizuoli.weibo.util.DateUtil;

/**
 * weibo
 * cn.cuizuoli.weibo.model.WeiboTest.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
@Data
public class WeiboTest {
	private int id;
	private String appId;
	private String nickname;
	private AppTestStatus status;
	private String creator;
	private String modifier;
	private Date createTime;
	private Date modifyTime;
	private List<String> statusCodeList;

	public String getModifyTimeFormat() {
		if (modifyTime != null) {
			return DateUtil.toDatetime(getModifyTime());
		} else {
			return null;
		}
	}

	public void setStatusCodes(String statusCodes) {
		String[] statusCodeArray = StringUtils.split(statusCodes, ",");
		if (statusCodeArray != null && statusCodeArray.length > 0) {
			statusCodeList = new ArrayList<String>();
			for (String statusCode : statusCodeArray) {
				statusCodeList.add(statusCode);
			}
			setStatusCodeList(statusCodeList);
		}
	}

}
