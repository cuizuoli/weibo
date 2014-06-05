/*
 * @(#)AppTypeJsonSerializer.java $version 2014年6月4日
 *
 * Copyright 2014 NHN China. All rights Reserved.
 * NHN China PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.map.ser;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import cn.cuizuoli.weibo.enumeration.AppType;

/**
 * weibo
 * cn.cuizuoli.weibo.map.ser.AppTypeJsonSerializer.java
 * @author CN40101
 * @date 2014年6月4日
 */
public class AppTypeJsonSerializer extends JsonSerializer<AppType> {

	private static final String CODE_FIELD = "code";
	private static final String NAME_FIELD = "name";

	@Override
	public void serialize(AppType value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeStringField(CODE_FIELD, value.getCode());
		jgen.writeStringField(NAME_FIELD, value.getName());
		jgen.writeEndObject();
	}

}
