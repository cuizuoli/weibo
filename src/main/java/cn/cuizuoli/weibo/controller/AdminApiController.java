/*
 * @(#)AdminApiController.java $version 2014年6月8日
 *
 * Copyright 2014 51gotour.com. All rights Reserved.
 * 51gotour.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import java.util.List;

import javax.annotation.Resource;

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
 * cn.cuizuoli.weibo.controller.AdminApiController.java
 * @author cuizuoli
 * @date 2014年6月8日
 */
@Controller
@RequestMapping("/a/api")
public class AdminApiController extends AbstractController {

	@Resource
	private WeiboService weiboService;

	@ResponseBody
	@RequestMapping(value = "weiboInfos", method = RequestMethod.GET)
	public ModelMap getWeiboInfos(WeiboInfo weiboInfo, User user) {
		List<WeiboInfo> weiboInfoList = weiboService.getWeiboInfoList(weiboInfo);
		return new ModelMap()
			.addAttribute("weiboInfos", weiboInfoList);
	}

	@ResponseBody
	@RequestMapping(value = "weiboInfos/{id}", method = RequestMethod.GET)
	public ModelMap getWeiboInfo(@PathVariable int id) {
		WeiboInfo weiboInfo = weiboService.getWeiboInfo(id);
		if (weiboInfo == null) {
			weiboInfo = new WeiboInfo();
		}
		return new ModelMap()
			.addAttribute("weiboInfo", weiboInfo);
	}

	@ResponseBody
	@RequestMapping(value = "weiboInfos", method = RequestMethod.POST)
	public ModelMap addWeiboInfo(@RequestBody WeiboInfos weiboInfos, User user) {
		WeiboInfo weiboInfo = weiboInfos.getWeiboInfo();
		weiboService.addWeiboInfo(weiboInfo, user);
		return new ModelMap()
			.addAttribute("weiboInfo", weiboInfo);
	}

	@ResponseBody
	@RequestMapping(value = "weiboInfos/{id}", method = RequestMethod.PUT)
	public ModelMap modifyWeiboInfo(@PathVariable int id, @RequestBody WeiboInfos weiboInfos, User user) {
		WeiboInfo weiboInfo = weiboInfos.getWeiboInfo();
		weiboInfo.setId(id);
		weiboService.modifyWeiboInfo(weiboInfo, user);
		weiboInfo = weiboService.getWeiboInfo(id);
		return new ModelMap()
			.addAttribute("weiboInfo", weiboInfo);
	}

}
