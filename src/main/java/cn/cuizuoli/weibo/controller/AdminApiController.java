/*
 * @(#)AdminApiController.java $version 2014年6月8日
 *
 * Copyright 2014 51gotour.com. All rights Reserved.
 * 51gotour.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
