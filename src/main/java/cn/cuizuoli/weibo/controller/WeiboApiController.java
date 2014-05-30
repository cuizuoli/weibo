/*
 * @(#)WeiboApiController.java $version 2014年5月29日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cuizuoli.weibo.model.Request;
import cn.cuizuoli.weibo.model.Requests;
import cn.cuizuoli.weibo.model.WeiboInfo;
import cn.cuizuoli.weibo.service.WeiboService;

/**
 * weibo
 * cn.cuizuoli.weibo.controller.WeiboApiController.java
 * @author CN40101
 * @date 2014年5月29日
 */
@Controller
@RequestMapping("/weibo/api")
public class WeiboApiController extends AbstractController {

	@Resource
	private WeiboService weiboService;

	@ResponseBody
	@RequestMapping(value = "requests", method = RequestMethod.GET)
	public Requests getRequests() {
		Requests requests = null;
		List<WeiboInfo> weiboInfoList = weiboService.getWeiboInfoList(null);
		if (weiboInfoList != null && weiboInfoList.size() > 0) {
			requests = new Requests();
			requests.setRequest(weiboInfoList);
		}
		return requests;
	}

	@ResponseBody
	@RequestMapping(value = "requests/{appId}", method = RequestMethod.GET)
	public Request getRequest(@PathVariable String appId) {
		Request request = null;
		WeiboInfo weiboInfo = weiboService.getWeiboInfo(appId);
		if (weiboInfo != null) {
			request = new Request();
			request.setRequest(weiboInfo);
		}
		return request;
	}

	@ResponseBody
	@RequestMapping(value = "requests", method = RequestMethod.POST)
	public void createRequest(@RequestBody Request request) {
		weiboService.addWeiboInfo(request.getRequest());
	}

	@ResponseBody
	@RequestMapping(value = "requests", method = RequestMethod.PUT)
	public void updateRequest(@RequestBody Request request) {
		weiboService.updateWeiboInfo(request.getRequest());
	}

}
