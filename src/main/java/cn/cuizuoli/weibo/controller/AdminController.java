/*
 * @(#)AdminController.java $version 2014年6月4日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.AdminController.java
 * @author CN40101
 * @date 2014年6月4日
 */
@Controller
@RequestMapping("/a")
public class AdminController extends AbstractController {

	@RequestMapping("")
	public ModelAndView index() {
		return new ModelAndView("admin/index");
	}
}
