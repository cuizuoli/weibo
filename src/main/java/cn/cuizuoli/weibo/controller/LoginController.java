/*
 * @(#)LoginController.java $version 2014年6月11日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.LoginController.java
 * @author cuizuoli
 * @date 2014年6月11日
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

}
