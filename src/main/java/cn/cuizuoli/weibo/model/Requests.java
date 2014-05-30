/*
 * @(#)Requests.java $version 2014年5月30日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.model;

import java.util.List;

import lombok.Data;

/**
 * weibo
 * cn.cuizuoli.weibo.model.Requests.java
 * @author CN40101
 * @date 2014年5月30日
 */
@Data
public class Requests {
	private List<WeiboInfo> request;
}
