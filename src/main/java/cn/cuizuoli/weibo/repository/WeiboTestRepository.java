/*
 * @(#)WeiboTestRepository.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.cuizuoli.weibo.model.WeiboTest;

/**
 * weibo
 * cn.cuizuoli.weibo.repository.WeiboTestRepository.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
@Repository
public interface WeiboTestRepository {
	/**
	 * selectList
	 * @param weiboTest
	 * @return
	 */
	List<WeiboTest> selectList(WeiboTest weiboTest);

	/**
	 * select
	 * @param id
	 * @return
	 */
	WeiboTest select(@Param("id") int id);

	/**
	 * insert
	 * @param weiboTest
	 */
	void insert(WeiboTest weiboTest);

	/**
	 * update
	 * @param weiboTest
	 */
	void update(WeiboTest weiboTest);

	/**
	 * delete
	 * @param id
	 */
	void delete(@Param("id") int id);
}
