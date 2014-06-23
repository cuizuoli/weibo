/*
 * @(#)WeiboToolsController.java $version 2014年6月23日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cuizuoli.weibo.service.WeiboService;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.WeiboToolsController.java
 * cuizuoli
 * @date 2014年6月23日
 */
@Controller
@RequestMapping("/weibo/tools")
public class WeiboToolsController extends AbstractController {

	@Resource
	private WeiboService weiboService;

	@RequestMapping("followers")
	public String followers() {
		return "followersExcelView";
	}

}
