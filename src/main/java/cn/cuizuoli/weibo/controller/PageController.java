/*
 * @(#)PageController.java $version 2014年6月13日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.cuizuoli.weibo.model.WeiboInfo;
import cn.cuizuoli.weibo.service.WeiboService;

import com.weibo.api.OAuth2;
import com.weibo.api.Users;
import com.weibo.model.PageTokenInfo;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.PageController.java
 * @author cuizuoli
 * @date 2014年6月13日
 */
@Slf4j
@Controller
@RequestMapping("/page")
public class PageController extends AbstractController {

	private final static String PAGE_LOGIN = "page/login";

	@Resource
	private WeiboService weiboService;

	@Resource
	private OAuth2 oAuth2;

	@Resource
	private Users users;

	@RequestMapping("{appId}")
	public ModelAndView index(HttpServletRequest request, @PathVariable String appId) {
		WeiboInfo weiboInfo = weiboService.getWeiboInfo(appId);
		if (weiboInfo != null) {
			String accessToken = request.getParameter(ACCESS_TOKEN);
			String userId = request.getParameter(USER_ID);
			String ouid = null;
			if (StringUtils.isBlank(accessToken) || StringUtils.isBlank(userId)) {
				String signedRequest = request.getParameter(SIGNED_REQUEST);
				log.info(SIGNED_REQUEST + " - " + signedRequest);
				if (StringUtils.isBlank(signedRequest)) {
					return new ModelAndView(PAGE_LOGIN)
						.addObject("appKey", weiboInfo.getAppKey())
						.addObject("redirectUri", weiboInfo.getRedirectUri())
						.addObject("appName", weiboInfo.getAppName());
				} else {
					PageTokenInfo tokenInfo = oAuth2.parsePageSignedRequest(signedRequest, weiboInfo.getAppSecret());
					if (tokenInfo != null) {
						accessToken = tokenInfo.getOauthToken();
						userId = tokenInfo.getUserId();
						ouid = tokenInfo.getOuid();
					}
					if (StringUtils.isEmpty(accessToken)) {
						return new ModelAndView(PAGE_LOGIN)
							.addObject("appKey", weiboInfo.getAppKey())
							.addObject("redirectUri", weiboInfo.getRedirectUri())
							.addObject("appName", weiboInfo.getAppName());
					}
				}
			}
			String appUri = new StringBuffer()
				.append("redirect:").append(weiboInfo.getAppUri())
				.append("?access_token=").append(accessToken)
				.append("&user_id=").append(userId)
				.append("&ouid=").append(ouid)
				.toString();
			return new ModelAndView(appUri);
		} else {
			return new ModelAndView("/invalidAppId");
		}
	}

}
