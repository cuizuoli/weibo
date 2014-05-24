/*
 * @(#)AppStatusJsonSerializer.java $version 2014年5月24日
 *
 * Copyright 2014 51gotour.com. All rights Reserved.
 * 51gotour.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.map.ser;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import cn.cuizuoli.weibo.enumeration.AppStatus;

/**
 * weibo
 * cn.cuizuoli.weibo.map.ser.AppStatusJsonSerializer.java
 * @author cuizuoli
 * @date 2014年5月24日
 */
public class AppStatusJsonSerializer extends JsonSerializer<AppStatus> {

	private static final String CODE_FIELD = "code";
	private static final String NAME_FIELD = "name";

	@Override
	public void serialize(AppStatus value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeStringField(CODE_FIELD, value.getCode());
		jgen.writeStringField(NAME_FIELD, value.getName());
		jgen.writeEndObject();
	}

}
