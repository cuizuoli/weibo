/*
 * @(#)AppTypeJsonDeserializer.java $version 2014年6月4日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.map.deser;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import cn.cuizuoli.weibo.enumeration.AppType;

/**
 * weibo
 * cn.cuizuoli.weibo.map.deser.AppTypeJsonDeserializer.java
 * @author cuizuoli
 * @date 2014年6月4日
 */
public class AppTypeJsonDeserializer extends JsonDeserializer<AppType> {

	private static final String CODE_FIELD = "code";

	@Override
	public AppType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
			JsonProcessingException {
		AppType type = null;
		JsonNode codeNode = jp.getCodec().readTree(jp).get(CODE_FIELD);
		if (codeNode != null) {
			String code = codeNode.getTextValue();
			if (StringUtils.isNotEmpty(code)) {
				type = AppType.getObject(code);
			}
		}
		return type;
	}
}
