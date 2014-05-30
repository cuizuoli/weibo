/*
 * @(#)AppStatusJsonDeserializer.java $version 2014年5月30日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.map.deser;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import cn.cuizuoli.weibo.enumeration.AppStatus;

/**
 * weibo
 * cn.cuizuoli.weibo.map.deser.AppStatusJsonDeserializer.java
 * @author CN40101
 * @date 2014年5月30日
 */
public class AppStatusJsonDeserializer extends JsonDeserializer<AppStatus> {

	private static final String CODE_FIELD = "code";

	@Override
	public AppStatus deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		AppStatus status = null;
		JsonNode codeNode = jp.getCodec().readTree(jp).get(CODE_FIELD);
		if (codeNode != null) {
			String code = codeNode.getTextValue();
			if (StringUtils.isNotEmpty(code)) {
				status = AppStatus.getObject(code);
			}
		}
		return status;
	}

}
