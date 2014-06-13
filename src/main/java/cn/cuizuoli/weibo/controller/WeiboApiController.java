/*
 * @(#)WeiboApiController.java $version 2014年5月29日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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

import cn.cuizuoli.weibo.enumeration.AppTestStatus;
import cn.cuizuoli.weibo.model.WeiboInfo;
import cn.cuizuoli.weibo.model.WeiboInfos;
import cn.cuizuoli.weibo.model.WeiboTest;
import cn.cuizuoli.weibo.model.WeiboTests;
import cn.cuizuoli.weibo.service.WeiboService;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.WeiboApiController.java
 * @author cuizuoli
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
	public ModelMap getWeiboInfos(WeiboInfo weiboInfo, User user) {
		weiboInfo.setCreator(user.getUsername());
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

	@ResponseBody
	@RequestMapping(value = "weiboTests", method = RequestMethod.GET)
	public ModelMap getWeiboInfos(WeiboTest weiboTest, User user) {
		weiboTest.setCreator(user.getUsername());
		List<WeiboTest> weiboTestList = weiboService.getWeiboTestList(weiboTest);
		return new ModelMap()
			.addAttribute("weiboTests", weiboTestList);
	}

	@ResponseBody
	@RequestMapping(value = "weiboTests", method = RequestMethod.POST)
	public ModelMap addWeiboTest(@RequestBody WeiboTests weiboTests, User user) {
		WeiboTest weiboTest = weiboTests.getWeiboTest();
		weiboService.addWeiboTest(weiboTest, user);
		return new ModelMap()
			.addAttribute("weiboTest", weiboTest);
	}

	@ResponseBody
	@RequestMapping(value = "weiboTests/{id}", method = RequestMethod.PUT)
	public ModelMap modifyWeiboTest(@PathVariable int id, @RequestBody WeiboTests weiboTests, User user) {
		WeiboTest weiboTest = weiboTests.getWeiboTest();
		weiboTest.setId(id);
		AppTestStatus status = weiboTest.getStatus();
		if (status == AppTestStatus.DEL) {
			weiboService.deleteWeiboTest(weiboTest);
		}
		weiboTest = weiboService.getWeiboTest(weiboTest.getId());
		return new ModelMap()
			.addAttribute("weiboTest", weiboTest);
	}

}
