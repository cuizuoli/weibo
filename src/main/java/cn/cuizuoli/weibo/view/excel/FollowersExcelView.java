/*
 * @(#)FollowersExcelView.java $version 2014年6月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.view.excel;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.CharEncoding;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import cn.cuizuoli.weibo.enumeration.Gender;
import cn.cuizuoli.weibo.service.WeiboToolsService;
import cn.cuizuoli.weibo.util.DateUtil;
import cn.cuizuoli.weibo.view.AbstractExcelView;

import com.weibo.model.User;

/**
 * weibo
 * cn.cuizuoli.weibo.view.excel.FollowersExcelView.java
 * cuizuoli
 * @date 2014年6月23日
 */
@Component
public class FollowersExcelView extends AbstractExcelView {

	private final static String ACCESS_TOKEN = "access_token";
	private final static String USER_ID = "user_id";
	private final static String FILE_NAME = "followers";

	private final static String WEIBO_URL = "http://weibo.com/";

	@Resource
	private WeiboToolsService weiboToolsService;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, SXSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fileName = new String((FILE_NAME + "_" + DateUtil.toDay(DateTime.now()) + EXTENSION).getBytes(), CharEncoding.UTF_8);
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		Sheet sheet = workbook.createSheet();
		setText(getCell(sheet, 0, 0), "ID");
		setText(getCell(sheet, 0, 1), "昵称");
		setText(getCell(sheet, 0, 2), "地点");
		setText(getCell(sheet, 0, 3), "描述");
		setText(getCell(sheet, 0, 4), "头像");
		setText(getCell(sheet, 0, 5), "主页地址");
		setText(getCell(sheet, 0, 6), "性别");
		setText(getCell(sheet, 0, 7), "followersCount");
		setText(getCell(sheet, 0, 8), "friendsCount");
		setText(getCell(sheet, 0, 9), "statusesCount");
		setText(getCell(sheet, 0, 10), "favouritesCount");
		setText(getCell(sheet, 0, 11), "avatarLarge");
		setText(getCell(sheet, 0, 12), "avatarHd");
		setText(getCell(sheet, 0, 13), "following");
		setText(getCell(sheet, 0, 14), "followMe");
		setText(getCell(sheet, 0, 15), "语言");
		setText(getCell(sheet, 0, 16), "createdAt");

		String accessToken = request.getParameter(ACCESS_TOKEN);
		String userId = request.getParameter(USER_ID);
		User[] users = weiboToolsService.followers(userId, 200, 0, accessToken);

		if (users != null) {
			int i = 1;
			for (User user : users) {
				setText(getCell(sheet, i, 0), user.getId());
				setText(getCell(sheet, i, 1), user.getScreenName());
				setText(getCell(sheet, i, 2), user.getLocation());
				setText(getCell(sheet, i, 3), user.getDescription());
				setText(getCell(sheet, i, 4), user.getProfileImageUrl());
				setText(getCell(sheet, i, 5), WEIBO_URL + user.getProfileUrl());
				setText(getCell(sheet, i, 6), Gender.getObject(user.getGender()).getName());
				setNumber(getCell(sheet, i, 7), user.getFollowersCount());
				setNumber(getCell(sheet, i, 8), user.getFriendsCount());
				setNumber(getCell(sheet, i, 9), user.getStatusesCount());
				setNumber(getCell(sheet, i, 10), user.getFavouritesCount());
				setText(getCell(sheet, i, 11), user.getAvatarLarge());
				setText(getCell(sheet, i, 12), user.getAvatarHd());
				setBoolean(getCell(sheet, i, 13), user.isFollowing());
				setBoolean(getCell(sheet, i, 14), user.isFollowMe());
				setText(getCell(sheet, i, 15), user.getLang());
				setText(getCell(sheet, i, 16), user.getCreatedAt());
				i++;
			}
		}

	}

}
