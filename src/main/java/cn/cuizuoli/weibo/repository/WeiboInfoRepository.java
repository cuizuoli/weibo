/*
 * @(#)WeiboInfoRepository.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.cuizuoli.weibo.model.WeiboInfo;

/**
 * weibo
 * cn.cuizuoli.weibo.repository.WeiboInfoRepository.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
@Repository
public interface WeiboInfoRepository {
	/**
	 * selectList
	 * @param weiboInfo
	 * @return
	 */
	List<WeiboInfo> selectList(WeiboInfo weiboInfo);

	/**
	 * select
	 * @param id
	 * @return
	 */
	WeiboInfo select(@Param("id") String id);

	/**
	 * insert
	 * @param weiboInfo
	 */
	void insert(WeiboInfo weiboInfo);

	/**
	 * update
	 * @param weiboInfo
	 */
	void update(WeiboInfo weiboInfo);

	/**
	 * delete
	 * @param appId
	 */
	void delete(@Param("appId") String appId);
}
