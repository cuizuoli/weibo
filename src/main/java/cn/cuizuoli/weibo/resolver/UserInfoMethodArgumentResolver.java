/*
 * @(#)UserInfoMethodArgumentResolver.java $version 2014年6月3日
 *
 * Copyright 2014 51gotour.com. All rights Reserved.
 * 51gotour.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * weibo
 * cn.cuizuoli.weibo.resolver.UserInfoMethodArgumentResolver.java
 * @author cuizuoli
 * @date 2014年6月3日
 */
public class UserInfoMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> paramType = parameter.getParameterType();
		return User.class.isAssignableFrom(paramType);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		Class<?> paramType = parameter.getParameterType();
		if (User.class.isAssignableFrom(paramType)) {
			SecurityContext securityContext = SecurityContextHolder.getContext();
			Authentication authentication = securityContext.getAuthentication();
			if (authentication != null) {
				Object principal = authentication.getPrincipal();
				if (principal instanceof User) {
					return (User)principal;
				}
			}
		}
		return null;
	}

}
