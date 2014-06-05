/*
 * @(#)WeiboApiController.java $version 2014年5月29日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cuizuoli.weibo.model.WeiboInfo;
import cn.cuizuoli.weibo.model.WeiboInfos;
import cn.cuizuoli.weibo.service.WeiboService;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.WeiboApiController.java
 * @author CN40101
 * @date 2014年5月29日
 */
@Slf4j
@Controller
@RequestMapping("/weibo/api")
public class WeiboApiController extends AbstractController {

	@Resource
	private WeiboService weiboService;

	@ResponseBody
	@RequestMapping(value = "weiboInfos", method = RequestMethod.GET)
	public ModelMap getWeiboInfos(User user) {
		WeiboInfo weiboInfo = new WeiboInfo();
		weiboInfo.setCreator(user.getUsername());
		List<WeiboInfo> weiboInfoList = weiboService.getWeiboInfoList(weiboInfo);
		return new ModelMap()
			.addAttribute("weiboInfos", weiboInfoList);
	}

	@ResponseBody
	@RequestMapping(value = "weiboInfos/{appId}", method = RequestMethod.GET)
	public ModelMap getWeiboInfo(@PathVariable String appId) {
		WeiboInfo weiboInfo = weiboService.getWeiboInfo(appId);
		if (weiboInfo == null) {
			weiboInfo = new WeiboInfo();
		}
		return new ModelMap()
			.addAttribute("weiboInfo", weiboInfo);
	}

	@ResponseBody
	@RequestMapping(value = "weiboInfos", method = RequestMethod.POST)
	public boolean addWeiboInfo(@RequestBody WeiboInfos weiboInfos, User user) {
		weiboService.addWeiboInfo(weiboInfos.getRequest(), user);
		return true;
	}

	@ResponseBody
	@RequestMapping(value = "weiboInfos", method = RequestMethod.PUT)
	public void modifyWeiboInfo(@RequestBody WeiboInfos weiboInfos, User user) {
		weiboService.modifyWeiboInfo(weiboInfos.getRequest(), user);
	}

}
