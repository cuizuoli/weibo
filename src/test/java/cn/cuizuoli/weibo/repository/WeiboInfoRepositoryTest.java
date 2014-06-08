/*
 * @(#)WeiboInfoRepositoryTest.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.repository;

import javax.annotation.Resource;

import org.junit.Test;

import cn.cuizuoli.weibo.enumeration.AppStatus;
import cn.cuizuoli.weibo.model.WeiboInfo;
import cn.cuizuoli.weibo.test.AbstractTest;

/**
 * weibo
 * cn.cuizuoli.weibo.repository.WeiboInfoRepositoryTest.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
public class WeiboInfoRepositoryTest extends AbstractTest {

	@Resource
	private WeiboInfoRepository weiboInfoRepository;

	@Test
	public void selectList() {
		WeiboInfo weiboInfo = new WeiboInfo();
		weiboInfo.setStatus(AppStatus.REQUEST);
		weiboInfoRepository.selectList(weiboInfo);
	}

	@Test
	public void select() {
		weiboInfoRepository.select(1);
	}

	@Test
	public void insert() {
		WeiboInfo weiboInfo = new WeiboInfo();
		weiboInfo.setAppId("appranking");
		weiboInfo.setAppUri("http://appranking.weibo.cn/");
		weiboInfo.setAppName("测试");
		weiboInfo.setAppSummary("测试");
		weiboInfo.setAppIntro("测试");
		weiboInfo.setStatus(AppStatus.REQUEST);
		weiboInfo.setCreator("cuizuoli");
		weiboInfo.setModifier("cuizuoli");
		weiboInfoRepository.insert(weiboInfo);
	}

	@Test
	public void update() {
		WeiboInfo weiboInfo = new WeiboInfo();
		weiboInfo.setAppId("appranking");
		weiboInfo.setAppKey("1279823338");
		weiboInfo.setAppSecret("58fb0c16850275585d7a613e0253a650");
		weiboInfo.setRedirectUri("http://weibo.cuizuoli.cn/web/access_token/appranking/");
		weiboInfo.setAppUri("http://appranking.weibo.cn/");
		weiboInfo.setAppName("测试");
		weiboInfo.setAppSummary("测试");
		weiboInfo.setAppIntro("测试");
		weiboInfo.setStatus(AppStatus.REQUEST);
		weiboInfo.setModifier("cuizuoli");
		weiboInfoRepository.update(weiboInfo);
	}

	@Test
	public void delete() {
		weiboInfoRepository.delete(1);
	}

}
