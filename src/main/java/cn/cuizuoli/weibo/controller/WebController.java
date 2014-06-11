/*
 * @(#)WebController.java $version 2014年5月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.cuizuoli.weibo.model.WeiboInfo;
import cn.cuizuoli.weibo.service.WeiboService;

import com.weibo.api.OAuth2;
import com.weibo.api.Users;
import com.weibo.enums.Display;
import com.weibo.enums.Scope;
import com.weibo.model.AccessToken;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.WebController.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
@Controller
@RequestMapping("/web")
public class WebController {

	private static final String DEFAULT_STATE = "weibo.cuizuoli.cn";

	@Resource
	private WeiboService weiboService;

	@Resource
	private OAuth2 oAuth2;

	@Resource
	private Users users;

	@RequestMapping("authorize/{appId}")
	public ModelAndView authorize(@PathVariable String appId) {
		WeiboInfo weiboInfo = weiboService.getWeiboInfo(appId);
		String authorizeUri = oAuth2.authorize(weiboInfo.getAppKey(), weiboInfo.getRedirectUri(), Scope.ALL.getCode(), DEFAULT_STATE, Display.DEFAULT);
		return new ModelAndView("redirect:" + authorizeUri);
	}

	@RequestMapping("access_token/{appId}")
	public ModelAndView accessToken(HttpServletRequest request, @PathVariable String appId) {
		WeiboInfo weiboInfo = weiboService.getWeiboInfo(appId);
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		if (StringUtils.isNotBlank(state) && StringUtils.isNotBlank(code) && StringUtils.equals(DEFAULT_STATE, state)) {
			AccessToken accessToken = oAuth2.accessToken(weiboInfo.getAppKey(), weiboInfo.getAppSecret(), weiboInfo.getRedirectUri(), code);
			String appUri = new StringBuffer()
				.append("redirect:").append(weiboInfo.getAppUri())
				.append("?access_token=").append(accessToken.getAccessToken())
				.append("&user_id=").append(accessToken.getUid())
				.toString();
			return new ModelAndView(appUri);
		} else {
			String authorizeUri = new StringBuffer()
				.append("redirect:/web/authorize/")
				.append(appId)
				.toString();
			return new ModelAndView(authorizeUri);
		}
	}

}
