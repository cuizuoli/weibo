/*
 * @(#)EnterpriseController.java $version 2014年5月23日
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
import com.weibo.model.ProfessionalTokenInfo;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.EnterpriseController.java
 * @author cuizuoli
 * @date 2014年5月23日
 */
@Slf4j
@Controller
@RequestMapping("/page")
public class EnterpriseController extends AbstractController {

	private final static String ENTERPRISE_LOGIN = "enterprise/login";

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
			if (StringUtils.isBlank(accessToken) || StringUtils.isBlank(userId)) {
				String cid = request.getParameter(CID);//当前被访问的专业版用户uid
				String viewer = request.getParameter(VIEWER);//当前登陆用户uid
				String subAppkey = request.getParameter(SUB_APPKEY);//企业安装应用后的子key
				String tokenString = request.getParameter(TOKEN_STRING);//access token，请按.分割为两部分，后一部分先base64_decode，然后json_decode
				log.info(CID + " - " + cid);
				log.info(VIEWER + " - " + viewer);
				log.info(SUB_APPKEY + " - " + subAppkey);
				log.info(TOKEN_STRING + " - " + tokenString);
				if (StringUtils.isBlank(subAppkey)) {
					return new ModelAndView(ENTERPRISE_LOGIN)
						.addObject("appKey", weiboInfo.getAppKey())
						.addObject("redirectUri", weiboInfo.getRedirectUri())
						.addObject("appName", weiboInfo.getAppName());
				} else if (StringUtils.isBlank(tokenString)) {
					return new ModelAndView(ENTERPRISE_LOGIN)
						.addObject("appKey", subAppkey)
						.addObject("redirectUri", weiboInfo.getRedirectUri())
						.addObject("appName", weiboInfo.getAppName());
				} else {
					ProfessionalTokenInfo tokenInfo = oAuth2.parseSignedRequest(tokenString, weiboInfo.getAppSecret());
					if (tokenInfo != null) {
						accessToken = tokenInfo.getOauthToken();
						userId = tokenInfo.getUserId();
					} else {
						return new ModelAndView(ENTERPRISE_LOGIN)
							.addObject("appKey", subAppkey)
							.addObject("redirectUri", weiboInfo.getRedirectUri())
							.addObject("appName", weiboInfo.getAppName());
					}
				}
			}
			String appUri = new StringBuffer()
				.append("redirect:").append(weiboInfo.getAppUri())
				.append("?access_token=").append(accessToken)
				.append("&user_id=").append(userId)
				.toString();
			return new ModelAndView(appUri);
		} else {
			return new ModelAndView("/invalidAppId");
		}
	}

}
