/*
 * @(#)WeiboToolsService.java $version 2014年6月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weibo.api.Friendships;
import com.weibo.model.User;
import com.weibo.model.UserResult;

/**
 * weibo
 * cn.cuizuoli.weibo.service.WeiboToolsService.java
 * cuizuoli
 * @date 2014年6月23日
 */
@Service
public class WeiboToolsService {

	@Resource
	private Friendships friendships;

	/**
	 * followers
	 * @param uid - 需要查询的用户UID。 
	 * @param count - 单页返回的记录条数，默认为50，最大不超过200。 
	 * @param cursor - 返回结果的游标，下一页用返回值里的next_cursor，上一页用previous_cursor，默认为0。
	 * @param accessToken
	 * @return
	 */
	public User[] followers(String uid, int count, int cursor, String accessToken) {
		UserResult userResult = friendships.followers(uid, count, cursor, accessToken);
		if (userResult != null) {
			return userResult.getUsers();
		}
		return null;
	}

	/**
	 * followersByName
	 * @param screenName - 需要查询的用户昵称。 
	 * @param count - 单页返回的记录条数，默认为50，最大不超过200。 
	 * @param cursor - 返回结果的游标，下一页用返回值里的next_cursor，上一页用previous_cursor，默认为0。
	 * @param accessToken
	 * @return
	 */
	public User[] followersByName(String screenName, int count, int cursor, String accessToken) {
		UserResult userResult = friendships.followersByName(screenName, count, cursor, accessToken);
		if (userResult != null) {
			return userResult.getUsers();
		}
		return null;
	}

}
