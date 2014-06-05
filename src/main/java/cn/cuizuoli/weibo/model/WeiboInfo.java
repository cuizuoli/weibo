/*
 * @(#)WeiboInfo.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.model;

import java.util.Date;

import lombok.Data;
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
	private AppStatus status;
	private String creator;
	private String modifier;
	private Date createTime;
	private Date modifyTime;

	public String getModifyTimeFormat() {
		if (modifyTime != null) {
			return DateUtil.toDatetime(getModifyTime());
		} else {
			return null;
		}
	}
}
