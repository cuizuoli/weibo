/*
 * @(#)AppTestStatusJsonDeserializer.java $version 2014年5月30日
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

import cn.cuizuoli.weibo.enumeration.AppTestStatus;

/**
 * weibo
 * cn.cuizuoli.weibo.map.deser.AppTestStatusJsonDeserializer.java
 * @author CN40101
 * @date 2014年5月30日
 */
public class AppTestStatusJsonDeserializer extends JsonDeserializer<AppTestStatus> {

	private static final String CODE_FIELD = "code";

	@Override
	public AppTestStatus deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		AppTestStatus status = null;
		JsonNode codeNode = jp.getCodec().readTree(jp).get(CODE_FIELD);
		if (codeNode != null) {
			String code = codeNode.getTextValue();
			if (StringUtils.isNotEmpty(code)) {
				status = AppTestStatus.getObject(code);
			}
		}
		return status;
	}

}
