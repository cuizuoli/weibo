/*
 * @(#)WeiboToolsServiceTest.java $version 2014年6月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.service;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import cn.cuizuoli.weibo.test.AbstractTest;

import com.weibo.model.User;

/**
 * weibo
 * cn.cuizuoli.weibo.service.WeiboToolsServiceTest.java
 * cuizuoli
 * @date 2014年6月23日
 */
@Slf4j
public class WeiboToolsServiceTest extends AbstractTest {

	@Resource
	private WeiboService weiboService;

	@Resource
	private WeiboToolsService weiboToolsService;

	@Test
	public void followersByName() {
		User[] users = weiboToolsService.followers("2139839683", 200, 0, "2.00RDYo1CWcEyRE1a02f5c3580s62aE");
		if (users != null) {
			for (User user : users) {
				log.debug(user.toString());
			}
		}
	}
}
