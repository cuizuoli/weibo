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
	 * @param id
	 * @return
	 */
	public WeiboInfo getWeiboInfo(int id) {
		return weiboInfoRepository.select(id);
	}

	/**
	 * getWeiboInfo
	 * @param appId
	 * @return
	 */
	public WeiboInfo getWeiboInfo(String appId) {
		WeiboInfo weiboInfo = new WeiboInfo();
		weiboInfo.setAppId(appId);
		List<WeiboInfo> weiboInfoList = weiboInfoRepository.selectList(weiboInfo);
		if (weiboInfoList.size() > 0) {
			return weiboInfoList.get(0);
		}
		return null;
	}

	/**
	 * addWeiboInfo
	 * @param weiboInfo
	 */
	@Transactional
	public void addWeiboInfo(WeiboInfo weiboInfo, User user) {
		weiboInfo.setStatus(AppStatus.REQUEST);
		weiboInfo.setCreator(user.getUsername());
		weiboInfo.setModifier(user.getUsername());
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
	@Transactional
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
	 * getWeiboTestList
	 * @param weiboTest
	 * @return
	 */
	public List<WeiboTest> getWeiboTestList(WeiboTest weiboTest) {
		return weiboTestRepository.selectList(weiboTest);
	}

	/**
	 * getWeiboTest
	 * @param id
	 * @return
	 */
	public WeiboTest getWeiboTest(int id) {
		return weiboTestRepository.select(id);
	}

	/**
	 * addWeiboTest
	 * @param weiboTest
	 * @param user
	 */
	@Transactional
	public void addWeiboTest(WeiboTest weiboTest, User user) {
		weiboTest.setStatus(AppTestStatus.ADD);
		weiboTest.setCreator(user.getUsername());
		weiboTest.setModifier(user.getUsername());
		weiboTestRepository.insert(weiboTest);
	}

	/**
	 * addedWeiboTest
	 * @param weiboTest
	 */
	@Transactional
	public void addedWeiboTest(WeiboTest weiboTest) {
		weiboTest = weiboTestRepository.select(weiboTest.getId());
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
	public void deleteWeiboTest(WeiboTest weiboTest) {
		weiboTest = weiboTestRepository.select(weiboTest.getId());
		if (weiboTest != null) {
			AppTestStatus appTestStatus = weiboTest.getStatus();
			if (appTestStatus != null) {
				switch (appTestStatus) {
					case ADD: {
						weiboTestRepository.delete(weiboTest.getId());
					}
						break;
					case ADDED: {
						weiboTest.setStatus(AppTestStatus.DEL);
						weiboTestRepository.update(weiboTest);
					}
						break;
					case DEL: {
						weiboTestRepository.delete(weiboTest.getId());
					}
						break;
				}
			} else {
				log.error("appTestStatus - " + appTestStatus);
			}
		}
	}

}
