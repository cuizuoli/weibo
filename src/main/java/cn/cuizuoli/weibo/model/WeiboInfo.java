/*
 * @(#)WeiboInfo.java $version 2014年5月23日
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

import cn.cuizuoli.weibo.enumeration.AppStatus;
import cn.cuizuoli.weibo.enumeration.AppType;
import cn.cuizuoli.weibo.util.DateUtil;

/**
 * weibo
 * cn.cuizuoli.weibo.model.WeiboInfo.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
@Data
public class WeiboInfo {
	private int id;
	private String appId;
	private String appKey;
	private String appSecret;
	private String redirectUri;
	private String appUri;
	private String appName;
	private String appSummary;
	private String appIntro;
	private AppType appType;
	private String officialId;
	private String officialPassword;
	private String icon16;
	private String icon80;
	private String icon120;
	private String preview01;
	private String preview02;
	private String preview03;
	private String preview04;
	private AppStatus status;
	private String statusCode;
	private String creator;
	private String modifier;
	private Date createTime;
	private Date modifyTime;
	private List<String> statusCodeList;
	private WeiboTest[] weiboTests;

	public String getModifyTimeFormat() {
		if (modifyTime != null) {
			return DateUtil.toDatetime(getModifyTime());
		} else {
			return null;
		}
	}

	public void setStatusCode(String statusCode) {
		setStatus(AppStatus.getObject(statusCode));
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
