/*
 * @(#)WeiboServiceTest.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.service;

import javax.annotation.Resource;

import org.junit.Test;

import cn.cuizuoli.weibo.enumeration.AppStatus;
import cn.cuizuoli.weibo.model.WeiboInfo;
import cn.cuizuoli.weibo.test.AbstractTest;

/**
 * weibo
 * cn.cuizuoli.weibo.service.WeiboServiceTest.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
public class WeiboServiceTest extends AbstractTest {

	@Resource
	private WeiboService weiboService;

	@Test
	public void getWeiboInfo() {
		weiboService.getWeiboInfo("appranking");
	}

	@Test
	public void addWeiboInfo() {
		WeiboInfo weiboInfo = new WeiboInfo();
		weiboInfo.setAppId("appranking");
		weiboInfo.setAppUri("http://appranking.weibo.cn/");
		weiboInfo.setAppName("测试");
		weiboInfo.setAppSummary("测试");
		weiboInfo.setAppIntro("测试");
		weiboService.addWeiboInfo(weiboInfo);
	}

	@Test
	public void updateWeiboInfo() {
		WeiboInfo weiboInfo = new WeiboInfo();
		weiboInfo.setAppId("appranking");
		weiboInfo.setAppKey("1279823338");
		weiboInfo.setAppSecret("58fb0c16850275585d7a613e0253a650");
		weiboInfo.setRedirectUri("http://weibo.cuizuoli.cn/web/access_token/appranking/");
		weiboInfo.setAppUri("http://appranking.weibo.cn/");
		weiboInfo.setStatus(AppStatus.REQUESTED.getCode());
		weiboService.updateWeiboInfo(weiboInfo);
	}

	@Test
	public void addWeiboTest() {
		weiboService.addedWeiboTest("appranking", "测试");
	}

	@Test
	public void addedWeiboTest() {
		weiboService.addedWeiboTest("appranking", "测试");
	}

	@Test
	public void deleteWeiboTest() {
		weiboService.deleteWeiboTest("appranking", "测试");
	}

}
