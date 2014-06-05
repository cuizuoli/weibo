/*
 * @(#)WeiboService.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.service;

import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.security.core.userdetails.User;
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

	@Resource
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * getWeiboInfoList
	 * @param weiboInfo
	 * @return
	 */
	public List<WeiboInfo> getWeiboInfoList(WeiboInfo weiboInfo) {
		return weiboInfoRepository.selectList(weiboInfo);
	}

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
	public void addWeiboInfo(WeiboInfo weiboInfo, User user) {
		weiboInfo.setStatus(AppStatus.REQUEST);
		weiboInfoRepository.insert(weiboInfo);
	}

	/**
	 * batchAddWeiboInfo
	 * @param weiboInfoList
	 */
	@Transactional
	public void batchAddWeiboInfo(List<WeiboInfo> weiboInfoList, User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
		WeiboInfoRepository batchWeiboInfoRepository = sqlSession.getMapper(WeiboInfoRepository.class);
		int i = 1;
		for (WeiboInfo weiboInfo : weiboInfoList) {
			weiboInfo.setCreator(user.getUsername());
			weiboInfo.setModifier(user.getUsername());
			batchWeiboInfoRepository.insert(weiboInfo);
			if (i % 100 == 0) {
				sqlSession.commit();
			}
			i++;
		}
		sqlSession.commit();
		sqlSession.close();
	}

	/**
	 * modifyWeiboInfo
	 * @param weiboInfo
	 */
	public void modifyWeiboInfo(WeiboInfo weiboInfo, User user) {
		weiboInfo.setModifier(user.getUsername());
		weiboInfoRepository.update(weiboInfo);
	}

	/**
	 * batchUpdateWeiboInfo
	 * @param weiboInfoList
	 */
	@Transactional
	public void batchUpdateWeiboInfo(List<WeiboInfo> weiboInfoList, User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
		WeiboInfoRepository batchWeiboInfoRepository = sqlSession.getMapper(WeiboInfoRepository.class);
		int i = 1;
		for (WeiboInfo weiboInfo : weiboInfoList) {
			weiboInfo.setModifier(user.getUsername());
			batchWeiboInfoRepository.update(weiboInfo);
			if (i % 100 == 0) {
				sqlSession.commit();
			}
			i++;
		}
		sqlSession.commit();
		sqlSession.close();
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
