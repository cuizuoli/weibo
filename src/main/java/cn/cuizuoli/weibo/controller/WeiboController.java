/*
 * @(#)WeiboController.java $version 2014年5月24日
 *
 * Copyright 2014 51gotour.com. All rights Reserved.
 * 51gotour.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.cuizuoli.weibo.model.WeiboInfo;
import cn.cuizuoli.weibo.service.WeiboService;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.WeiboController.java
 * @author cuizuoli
 * @date 2014年5月24日
 */
@Controller
@RequestMapping("/weibo")
public class WeiboController extends AbstractController {

	@Resource
	private WeiboService weiboService;

	@RequestMapping("")
	public ModelAndView weibo() {
		return new ModelAndView("weibo/index");
	}

	@RequestMapping(value = "request", method = RequestMethod.GET)
	public ModelAndView request() {
		return new ModelAndView("weibo/request");
	}

	@RequestMapping(value = "request", method = RequestMethod.POST)
	public boolean request(HttpServletRequest request, @RequestBody WeiboInfo weiboInfo) {
		return false;
	}

}
