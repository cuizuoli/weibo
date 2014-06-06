/*
 * @(#)AppTypeTypeHandler.java $version 2014年6月4日
 *
 * Copyright 2014 cuizuoli.cn. All rights Reserved.
 * cuizuoli.cn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.cuizuoli.weibo.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import cn.cuizuoli.weibo.enumeration.AppType;

/**
 * weibo
 * cn.cuizuoli.weibo.typehandler.AppTypeTypeHandler.java
 * @author cuizuoli
 * @date 2014年6月4日
 */
public class AppTypeTypeHandler extends BaseTypeHandler<AppType> {

	@Override
	public AppType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		AppType appType = null;
		String s = rs.getString(columnName);
		if (StringUtils.isNotEmpty(s)) {
			appType = AppType.getObject(s);
		}
		return appType;
	}

	@Override
	public AppType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		AppType appType = null;
		String s = rs.getString(columnIndex);
		if (StringUtils.isNotEmpty(s)) {
			appType = AppType.getObject(s);
		}
		return appType;
	}

	@Override
	public AppType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		AppType appType = null;
		String s = cs.getString(columnIndex);
		if (StringUtils.isNotEmpty(s)) {
			appType = AppType.getObject(s);
		}
		return appType;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, AppType parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.getCode());
	}

}
