/*
 * @(#)WeiboService.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.service;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cuizuoli.weibo.enumeration.AppStatus;
import cn.cuizuoli.weibo.enumeration.AppTestStatus;
import cn.cuizuoli.weibo.model.WeiboInfo;
import cn.cuizuoli.weibo.model.WeiboTest;
import cn.cuizuoli.weibo.repository.WeiboInfoRepository;
import cn.cuizuoli.weibo.repository.WeiboTestRepository;

/**
 * weibo
 * cn.cuizuoli.weibo.service.WeiboService.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
@Slf4j
@Service
public class WeiboService {

	@Resource
	private WeiboInfoRepository weiboInfoRepository;

	@Resource
	private WeiboTestRepository weiboTestRepository;

	/**
	 * getWeiboInfo
	 * @param appId
	 * @return
	 */
	public WeiboInfo getWeiboInfo(String appId) {
		return weiboInfoRepository.select(appId);
	}

	/**
	 * addWeiboInfo
	 * @param weiboInfo
	 */
	@Transactional
	public void addWeiboInfo(WeiboInfo weiboInfo) {
		weiboInfo.setStatus(AppStatus.REQUEST);
		weiboInfo.setCreator("");
		weiboInfo.setModifier("");
		weiboInfoRepository.insert(weiboInfo);
	}

	/**
	 * updateWeiboInfo
	 * @param weiboInfo
	 */
	public void updateWeiboInfo(WeiboInfo weiboInfo) {
		weiboInfo.setModifier("");
		weiboInfoRepository.update(weiboInfo);
	}

	/**
	 * addWeiboTest
	 * @param appId
	 * @param nickname
	 */
	@Transactional
	public void addWeiboTest(String appId, String nickname) {
		WeiboTest weiboTest = weiboTestRepository.select(appId, nickname);
		if (weiboTest == null) {
			weiboTest = new WeiboTest();
			weiboTest.setAppId(appId);
			weiboTest.setNickname(nickname);
			weiboTest.setStatus(AppTestStatus.ADD);
			weiboTest.setCreator("");
			weiboTest.setModifier("");
			weiboTestRepository.insert(weiboTest);
		}
	}

	/**
	 * addedWeiboTest
	 * @param appId
	 * @param nickname
	 */
	@Transactional
	public void addedWeiboTest(String appId, String nickname) {
		WeiboTest weiboTest = weiboTestRepository.select(appId, nickname);
		if (weiboTest != null) {
			AppTestStatus appTestStatus = weiboTest.getStatus();
			switch (appTestStatus) {
				case ADD: {
					weiboTest.setStatus(AppTestStatus.ADDED);
					weiboTestRepository.update(weiboTest);
				}
					break;
				case ADDED: {
				}
					break;
				case DEL: {
				}
					break;
			}
		}
	}

	/**
	 * deleteWeiboTest
	 * @param appId
	 * @param nickname
	 */
	@Transactional
	public void deleteWeiboTest(String appId, String nickname) {
		WeiboTest weiboTest = weiboTestRepository.select(appId, nickname);
		if (weiboTest != null) {
			AppTestStatus appTestStatus = weiboTest.getStatus();
			if (appTestStatus != null) {
				switch (appTestStatus) {
					case ADD: {
						weiboTestRepository.delete(appId, nickname);
					}
						break;
					case ADDED: {
						weiboTest.setStatus(AppTestStatus.DEL);
						weiboTestRepository.update(weiboTest);
					}
						break;
					case DEL: {
						weiboTestRepository.delete(appId, nickname);
					}
						break;
				}
			} else {
				log.error("appTestStatus - " + appTestStatus);
			}
		}
	}

}
