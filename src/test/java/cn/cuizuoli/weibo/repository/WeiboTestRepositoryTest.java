/*
 * @(#)WeiboTestRepositoryTest.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.repository;

import javax.annotation.Resource;

import org.junit.Test;

import cn.cuizuoli.weibo.enumeration.AppTestStatus;
import cn.cuizuoli.weibo.model.WeiboTest;
import cn.cuizuoli.weibo.test.AbstractTest;

/**
 * weibo
 * cn.cuizuoli.weibo.repository.WeiboTestRepositoryTest.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
public class WeiboTestRepositoryTest extends AbstractTest {

	@Resource
	private WeiboTestRepository weiboTestRepository;

	@Test
	public void selectList() {
		WeiboTest weiboTest = new WeiboTest();
		weiboTest.setAppId("appranking");
		weiboTest.setStatus(AppTestStatus.ADD);
		weiboTestRepository.selectList(weiboTest);
	}

	@Test
	public void select() {
		weiboTestRepository.select("appranking", "o风平浪静o");
	}

	@Test
	public void insert() {
		WeiboTest weiboTest = new WeiboTest();
		weiboTest.setAppId("appranking");
		weiboTest.setNickname("o风平浪静o");
		weiboTest.setStatus(AppTestStatus.ADD);
		weiboTest.setCreator("cuizuoli");
		weiboTest.setModifier("cuizuoli");
		weiboTestRepository.insert(weiboTest);
	}

	@Test
	public void update() {
		WeiboTest weiboTest = new WeiboTest();
		weiboTest.setStatus(AppTestStatus.ADD);
		weiboTest.setModifier("cuizuoli");
		weiboTestRepository.update(weiboTest);
	}

	@Test
	public void delete() {
		weiboTestRepository.delete("appranking", "o风平浪静o");
	}

}
